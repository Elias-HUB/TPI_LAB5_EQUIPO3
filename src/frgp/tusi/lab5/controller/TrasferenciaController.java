package frgp.tusi.lab5.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.model.Cuenta;
import frgp.tusi.lab5.model.Movimiento;
import frgp.tusi.lab5.model.TipoMovimiento;
import frgp.tusi.lab5.model.Transferencia;
import frgp.tusi.lab5.model.Usuario;
import frgp.tusi.lab5.serviceImpl.ClienteServiceImpl;
import frgp.tusi.lab5.serviceImpl.CuentaServiceImpl;
import frgp.tusi.lab5.serviceImpl.TipoMovimientoServiceImpl;
import frgp.tusi.lab5.serviceImpl.TransferenciaServiceImpl;

@Controller
public class TrasferenciaController {
	
	private TransferenciaServiceImpl transferenciaService;
	private CuentaServiceImpl cuentaService; 
	private TipoMovimientoServiceImpl tipoMovimientoService;
	private ClienteServiceImpl clienteService;
	private HttpSession session;
	
	@RequestMapping("transferencia")
	public ModelAndView transferencia() {
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("Cuentas", clienteService.buscarPorDni(123).getCuentas());
			mv.setViewName("transferencia");
			return mv;
		} catch (Exception e) {
			mv.setViewName("index");
			return mv;
		}		
	}
	
	@RequestMapping("listarTransferencias")
	public ModelAndView listarTransferencias() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("crearTransferencia")
	public ModelAndView crearTransferencia(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		session = request.getSession();
		Transferencia transferencia = new Transferencia();
		Cuenta cuentaDestino = new Cuenta();
		Cuenta cuentaOrigen = new Cuenta();
		Movimiento movimientoOrigen = new Movimiento();
		Movimiento movimientoDestino = new Movimiento();
		try {
			if(ValidarRequestTransferencia(request)){
				cuentaOrigen = cuentaService.buscar(request.getParameter("cuentas"));
				cuentaDestino = cuentaService.buscar(request.getParameter("txtDestino"));
				Usuario usuario = (Usuario)session.getAttribute("user");
				TipoMovimiento tipoMovOrigen = tipoMovimientoService.buscar("Transferencia Débito");
				TipoMovimiento tipoMovDestino = tipoMovimientoService.buscar("Transferencia Crédito");
				
				movimientoOrigen.setImporte(Double.parseDouble(request.getParameter("txtImporte"))*-1);
				movimientoOrigen.setCuenta(cuentaOrigen);
				movimientoOrigen.setTipoMovimiento(tipoMovOrigen);
				movimientoOrigen.setDetalle("Transferencia");
				movimientoOrigen.setFecha(new Date());
				movimientoOrigen.setEstado(true);
				
				movimientoDestino.setImporte(Double.parseDouble(request.getParameter("txtImporte")));
				movimientoDestino.setCuenta(cuentaDestino);
				movimientoDestino.setTipoMovimiento(tipoMovDestino);
				movimientoDestino.setDetalle("Transferencia");
				movimientoDestino.setFecha(new Date());
				movimientoDestino.setEstado(true);
				
				transferencia.setCuentaOrigen(cuentaOrigen);
				transferencia.setCuentaDestino(cuentaDestino);
				transferencia.setMovimientoOrigen(movimientoOrigen);
				transferencia.setMovimientoDestino(movimientoDestino);	
				
				transferenciaService.crear(transferencia);
				
				session.setAttribute("success", "Se realizó la transferencia a la cuenta CBU " + cuentaDestino.getCbu() + " por un total de $ " + movimientoDestino.getImporte());
				mv = new ModelAndView("redirect:resumen.html");
			}
			else {
				mv = new ModelAndView("redirect:transferencia.html");
				mv.setViewName("transferencia");
			}
		}
		catch(Exception ex) {
			session.setAttribute("error", "No se pudo realizar la transferencia.");
			mv = new ModelAndView("redirect:transferencia.html");
			mv.setViewName("transferencia");			
		}		
		return mv;
	}

	private boolean ValidarRequestTransferencia(HttpServletRequest request) {
		String cbuDestino = request.getParameter("txtDestino").trim();
		String importe = request.getParameter("importe").trim();
		
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
	        double d = Double.parseDouble(cbuDestino);
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