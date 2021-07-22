package frgp.tusi.lab5.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.config.Config;
import frgp.tusi.lab5.model.Cliente;
import frgp.tusi.lab5.model.Cuenta;
import frgp.tusi.lab5.model.Movimiento;
import frgp.tusi.lab5.model.TipoMovimiento;
import frgp.tusi.lab5.model.Transferencia;
import frgp.tusi.lab5.serviceImpl.ClienteServiceImpl;
import frgp.tusi.lab5.serviceImpl.CuentaServiceImpl;
import frgp.tusi.lab5.serviceImpl.MovimientoServiceImpl;
import frgp.tusi.lab5.serviceImpl.TipoMovimientoServiceImpl;
import frgp.tusi.lab5.serviceImpl.TransferenciaServiceImpl;

@Controller
public class TrasferenciaController {

	@Autowired
	@Qualifier("MovimientoServiceImplBean")
	private MovimientoServiceImpl movimientoService;
	
	@Autowired
	@Qualifier("TransferenciaServiceImplBean")
	private TransferenciaServiceImpl transferenciaService;
	
	@Autowired
	@Qualifier("CuentaServiceImplBean")
	private CuentaServiceImpl cuentaService;
	
	@Autowired
	@Qualifier("TipoMovimientoServiceImplBean")
	private TipoMovimientoServiceImpl tipoMovimientoService;

	@Autowired
	@Qualifier("ClienteServiceImplBean")
	private ClienteServiceImpl clienteService;
	
	private HttpSession session;	

	private Cliente cliente;
	
//	@Autowired
//	@Qualifier("TransferenciaBean")
	private Transferencia transferencia;
	
//	@Autowired
//	@Qualifier("CuentaBean")
	private Cuenta cuentaOrigen;

//	@Autowired
//	@Qualifier("CuentaBean")
	private Cuenta cuentaDestino;
	
//	@Autowired
//	@Qualifier("MovimientoBean")
	private Movimiento movimientoOrigen;
	
//	@Autowired
//	@Qualifier("MovimientoBean")
	private Movimiento movimientoDestino;
	
	@Autowired
	@Qualifier("ModelAndViewBean")
	private ModelAndView mv;
	
	public TrasferenciaController() {}
	
	@RequestMapping("transferencia")
	public ModelAndView transferencia(Integer dni) {
		try {
			cliente = clienteService.buscarPorDni(dni);
			mv.addObject("Cliente", cliente);
			mv.addObject("Cuentas", cuentaService.buscarCantidadCuentas(cliente.getId()));
			mv.setViewName("transferencia");
			return mv;
		} catch (Exception e) {
			mv.setViewName("index");
			return mv;
		}		
	}
	
	@RequestMapping("listarTransferencias")
	public ModelAndView listarTransferencias() {
		return mv;
	}
	
	@RequestMapping("crearTransferencia")
	public ModelAndView crearTransferencia(HttpServletRequest request) {
		session = request.getSession();
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		try {
			if(ValidarRequestTransferencia(request)){
				cuentaOrigen = cuentaService.buscar(request.getParameter("cuentas"));
				cuentaDestino = cuentaService.buscar(request.getParameter("txtDestino"));
				double importe = Double.parseDouble(request.getParameter("txtImporte"));
				ValidarCuentas(cuentaOrigen, cuentaDestino, importe);
				
				TipoMovimiento tipoMovOrigen = tipoMovimientoService.buscar("Transferencia Débito");
				TipoMovimiento tipoMovDestino = tipoMovimientoService.buscar("Transferencia Crédito");
				
				movimientoOrigen = (Movimiento)appContext.getBean("MovimientoBean");
				movimientoOrigen.setImporte(Double.parseDouble(request.getParameter("txtImporte"))*-1);
				movimientoOrigen.setCuenta(cuentaOrigen);
				movimientoOrigen.setTipoMovimiento(tipoMovOrigen);
				movimientoOrigen.setDetalle("Transferencia");
				movimientoOrigen.setFecha(new Date());
				movimientoOrigen.setEstado(true);
				
				movimientoDestino = (Movimiento)appContext.getBean("MovimientoBean");
				movimientoDestino.setImporte(importe);
				movimientoDestino.setCuenta(cuentaDestino);
				movimientoDestino.setTipoMovimiento(tipoMovDestino);
				movimientoDestino.setDetalle("Transferencia");
				movimientoDestino.setFecha(new Date());
				movimientoDestino.setEstado(true);
				
				cuentaOrigen = (Cuenta)appContext.getBean("CuentaBean");
				cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - importe);
				cuentaOrigen.getMovimientos().add(movimientoOrigen);
				
				cuentaDestino = (Cuenta)appContext.getBean("CuentaBean");
				cuentaDestino.setSaldo(cuentaDestino.getSaldo() + importe);
				cuentaDestino.getMovimientos().add(movimientoDestino);
				
				
				transferencia = (Transferencia)appContext.getBean("TransferenciaBean");
				transferencia.setCuentaOrigen(cuentaOrigen);
				transferencia.setCuentaDestino(cuentaDestino);
				transferencia.setMovimientoOrigen(movimientoOrigen);
				transferencia.setMovimientoDestino(movimientoDestino);	
				
				transferenciaService.crear(transferencia);
				
				session.setAttribute("success", "Se realizó la transferencia a la cuenta CBU " + cuentaDestino.getCbu() + " por un total de $ " + movimientoDestino.getImporte());
				mv = new ModelAndView("redirect:resumen.html?Val=1");
			}
			else {
				String dni = request.getParameter("txtDni");
				mv = new ModelAndView("redirect:transferencia.html?dni=" + dni);
			}
		}
		catch(Exception ex) {
			if(session.getAttribute("error") == null || session.getAttribute("error") ==  "")
				session.setAttribute("error", ex.getMessage());
			String dni = request.getParameter("txtDni");
			mv = new ModelAndView("redirect:transferencia.html?dni=" + dni);	
		}
		((ConfigurableApplicationContext)(appContext)).close();
		return mv;
	}

	private void ValidarCuentas(Cuenta cuentaOrigen, Cuenta cuentaDestino, double importe) throws Exception {
		if (cuentaOrigen == null) {
			session.setAttribute("error", "Cuenta origen inexistente.");
			throw new Exception();
		}
		if (cuentaDestino == null) {
			session.setAttribute("error", "Cuenta destino inexistente.");
			throw new Exception();
		}		
		if (!cuentaOrigen.getEstado()) {
			session.setAttribute("error", "Cuenta origen inactiva.");
			throw new Exception();
		} 
		if (!cuentaDestino.getEstado()) {
			session.setAttribute("error", "Cuenta destino inactiva.");
			throw new Exception();
		}
		if (cuentaOrigen.getSaldo() < importe ) {
			session.setAttribute("error", "Saldo insuficiente.");
			throw new Exception();
		}	        
	}

	private boolean ValidarRequestTransferencia(HttpServletRequest request) {
		String cbuDestino = request.getParameter("txtDestino").trim();
		String importe = request.getParameter("txtImporte").trim();
		
		if (cbuDestino == null || cbuDestino == "") {
			session.setAttribute("error", "No se ingresó CBU para la cuenta destino.");
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(cbuDestino);
	    } 
	    catch (NumberFormatException nfe) {
	    	session.setAttribute("error", "El CBU de destino debe tener sólo números.");
	        return false;
	    }
	    if (importe == null || importe == "") {
			session.setAttribute("error", "No se ingresó importe.");
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(importe);
	        if (d <= 0) {
	        	session.setAttribute("error", "El importe a transferir debe ser mayor que cero.");
		        return false;
	        }
	        	
	    } catch (NumberFormatException nfe) {
	    	session.setAttribute("error", "El importe debe tener sólo números.");
	        return false;
	    }
	    return true;		    
	}
}