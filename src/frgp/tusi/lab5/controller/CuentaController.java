package frgp.tusi.lab5.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
import frgp.tusi.lab5.model.TipoCuenta;
import frgp.tusi.lab5.model.TipoMovimiento;
import frgp.tusi.lab5.serviceImpl.ClienteServiceImpl;
import frgp.tusi.lab5.serviceImpl.CuentaServiceImpl;
import frgp.tusi.lab5.serviceImpl.MovimientoServiceImpl;
import frgp.tusi.lab5.serviceImpl.TipoCuentaServiceImpl;
import frgp.tusi.lab5.serviceImpl.TipoMovimientoServiceImpl;

@Controller
public class CuentaController {
	 
	@Autowired
	@Qualifier("ClienteServiceImplBean")
	private ClienteServiceImpl clienteService;
	
	@Autowired
	@Qualifier("CuentaServiceImplBean")
	private CuentaServiceImpl cuentaService;
	
	@Autowired
	@Qualifier("TipoCuentaServiceImplBean")
	private TipoCuentaServiceImpl tipoCuentaService;
	
	@Autowired
	@Qualifier("MovimientoServiceImplBean")
	private MovimientoServiceImpl movimientoService;
	
	@Autowired
	@Qualifier("TipoMovimientoServiceImplBean")
	private TipoMovimientoServiceImpl tipoMovimientoService;
	
	@Autowired
	@Qualifier("MovimientoServiceImplBean")
	private MovimientoServiceImpl movimientoServiceImpl;
	
	@Autowired
	@Qualifier("ModelAndViewBean")
	private ModelAndView mv;
	
	private Cliente cliente;

	private Cuenta cuenta;
	
	private Movimiento movimiento;
	
	public CuentaController() {}
	
	@RequestMapping("listarCuentas")
	public ModelAndView listarCuenta(HttpServletRequest request) {
		HttpSession session = request.getSession();
		try {
			mv.addObject("Cuenta", cuentaService.listar());
			mv.setViewName("listarCuentas");
		} catch (Exception e) {
			session.setAttribute("error", "Problemas para buscar las cuentas.");
			mv.setViewName("listarCuentas");
		}
		return mv;
	}

	@RequestMapping("altaCuenta")
	public ModelAndView altaCuenta( HttpServletRequest request, Integer dni) {
		HttpSession session = request.getSession();
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		
		cliente = (Cliente)appContext.getBean("ClienteBean");
		cuenta = (Cuenta)appContext.getBean("CuentaBean");
		try {
			if (request.getParameter("txtNombre") != null) {
				
				cliente = clienteService.buscarPorDni(Integer.parseInt(request.getParameter("txtDni")));
				cliente.setId(cliente.getId());
				
				List<Cuenta> listCli = cuentaService.buscarCantidadCuentas(cliente.getId());
				
				if(listCli.size() < 4) {
					
					Random rnd = new Random();
					cuenta.setCbu(rnd.nextInt(1000000000));
					cuenta.setNroCuenta(rnd.nextInt(1000000000));
					
					if (request.getParameter("btnradio").equals("Cuenta CA")) {
						cuenta.setNombre("Cuenta CA");
						TipoCuenta tc = tipoCuentaService.buscar("Caja de ahorro en pesos");
					cuenta.setTipoCuenta(tc);
					} else {
						cuenta.setNombre("Cuenta CD");
						TipoCuenta tc = tipoCuentaService.buscar("Caja de ahorro en dólares");
						cuenta.setTipoCuenta(tc);
					}

					cuenta.setSaldo(10000);
					cuenta.setEstado(true);
					
			    	SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
			        Calendar calendar = Calendar.getInstance();
			        Date dateObj = calendar.getTime();
			        String formattedDate = dtf.format(dateObj);
			        cuenta.setFechaAlta(formattedDate);
			        cuenta.setFechaUltimaModificacion("");
			        cuenta.setCliente(cliente);
					cuentaService.crear(cuenta);					
					
					TipoMovimiento tipoAltaCuenta = tipoMovimientoService.buscar("Alta de Cuenta");

					movimiento = (Movimiento)appContext.getBean("MovimientoBean");
					movimiento.setDetalle("Alta de Cuenta");
					movimiento.setEstado(true);
					movimiento.setFecha(new Date());
					movimiento.setFechaUltimaModificacion(new Date());
					movimiento.setTipoMovimiento(tipoAltaCuenta);
					movimiento.setImporte(10000);

					movimiento.setCuenta(cuenta);
					movimientoServiceImpl.crear(movimiento);
					
					session.setAttribute("success", "Se creo la cuenta " + cuenta.getNroCuenta() + " de manera correcta.");
					Integer dniCli = Integer.parseInt(request.getParameter("txtDni"));
					System.out.println(dniCli);
					mv = new ModelAndView("redirect:listarCuentasPorCliente.html?dni="+ dniCli);
				}else {
					session.setAttribute("error", "El cliente no puede tener más de 4 cuentas");
//					mv.setViewName("listarCuentas");
					mv = new ModelAndView("redirect:listarClientes.html");
				}
			}else {
				mv.addObject("Cliente", clienteService.buscarPorDni(dni));
				mv.setViewName("altaCuenta");
			}	
		} catch (Exception e) {
			session.setAttribute("error", "Problemas para crear la cuenta.");
			mv = new ModelAndView("redirect:listarClientes.html");
		}
		((ConfigurableApplicationContext)(appContext)).close();
		return mv;
	}
	
	@RequestMapping("modificarCuenta")
	public ModelAndView modificacionCuenta(HttpServletRequest request, Integer cbu) {
		mv.setViewName("modificarCuenta");
		return mv;
	}
	
	@RequestMapping("listarCuentasPorCliente")
	public ModelAndView listarCuentasPorCliente(HttpServletRequest request, Integer dni) throws NumberFormatException, Exception {
		HttpSession session = request.getSession();
		
		if (dni != null) {
			try {
				cliente = clienteService.buscarPorDni(dni);
				cliente.setId(cliente.getId());
				mv.addObject("Cuenta", cuentaService.buscarCantidadCuentas(cliente.getId()));
				mv.setViewName("listarCuentasPorCliente");

			} catch (Exception e) {
				session.setAttribute("error", "Problemas para buscar las cuentas.");
				mv.setViewName("listarCuentasPorCliente");
			}	
		}
		return mv;
	}
	
	@RequestMapping("eliminarCuenta")
	public ModelAndView eliminacionCuenta(HttpServletRequest request, Integer cbu) throws Exception {
		HttpSession session = request.getSession();
		try {
			cuenta = cuentaService.buscar(cbu.toString());
			cuentaService.eliminar(cuenta);
			session.setAttribute("success", "Se desactivó la cuenta " + cuenta.getNroCuenta() + " de manera correcta.");
			mv = new ModelAndView("redirect:listarCuentas.html");		
			
		} catch (Exception e) {
			session.setAttribute("error", "Problemas para eliminar cuenta.");
			mv = new ModelAndView("redirect:listarCuentas.html");
		}
		return mv;
	}
	
	@RequestMapping("resumen")
	public ModelAndView resumen(HttpServletRequest request, Integer Val) throws Exception {
		HttpSession session = request.getSession();
		cliente = (Cliente)session.getAttribute("persona");
		List<Cuenta> cuentas = cuentaService.buscarCantidadCuentas(cliente.getId());
		
		mv.addObject("Cliente", cliente);
		mv.addObject("Cuentas", cuentas);
		if(Val == 1) {
			cuenta = cuentas.get(0);
			mv.addObject("Cuenta", cuenta);
			List<Movimiento> mov = movimientoService.listarPorIdCuenta(cuenta.getId());
			mv.addObject("Movimientos", mov);
		}else {
			String cbu = request.getParameter("selectCuenta").toString();
			cuenta = cuentaService.buscar(cbu);
			mv.addObject("Cuenta", cuenta);
			List<Movimiento> mov = movimientoService.listarPorIdCuenta(cuenta.getId());
			mv.addObject("Movimientos", mov);
		}
		mv.setViewName("resumen");
		return mv;
	}
}