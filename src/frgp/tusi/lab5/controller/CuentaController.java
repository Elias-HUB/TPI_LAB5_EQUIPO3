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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.model.Cliente;
import frgp.tusi.lab5.model.Cuenta;
import frgp.tusi.lab5.model.Movimiento;
import frgp.tusi.lab5.model.TipoCuenta;
import frgp.tusi.lab5.service.ClienteService;
import frgp.tusi.lab5.serviceImpl.ClienteServiceImpl;
import frgp.tusi.lab5.serviceImpl.CuentaServiceImpl;
import frgp.tusi.lab5.serviceImpl.MovimientoServiceImpl;
import frgp.tusi.lab5.serviceImpl.TipoCuentaServiceImpl;

@Controller
public class CuentaController {
	 
	@Autowired
	@Qualifier("ClienteServiceImplBean")
	private ClienteServiceImpl clienteService;
	private CuentaServiceImpl cuentaService;
	private TipoCuentaServiceImpl tipoCuentaService;
	private MovimientoServiceImpl movimientoService;
	public CuentaController() {
		cuentaService = new CuentaServiceImpl();
		tipoCuentaService = new TipoCuentaServiceImpl();
		movimientoService = new MovimientoServiceImpl();
	}
	
	@RequestMapping("listarCuentas")
	public ModelAndView listarCuenta(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
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
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		try {
			if (request.getParameter("txtNombre") != null) {
				
				Cliente cli = clienteService.buscarPorDni(Integer.parseInt(request.getParameter("txtDni")));
				cli.setId(cli.getId());
				
				List<Cuenta> listCli = cuentaService.buscarCantidadCuentas(cli.getId());
				
				if(listCli.size() < 4) {
					
					Random rnd = new Random();
					Cuenta cuen = new Cuenta();
					cuen.setCbu(rnd.nextInt(1000000000));
					cuen.setNroCuenta(rnd.nextInt(1000000000));
					
					if (request.getParameter("btnradio").equals("Cuenta CA")) {
							cuen.setNombre("Cuenta CA");
							TipoCuenta tc = tipoCuentaService.buscar("Caja de ahorro en pesos");
							cuen.setTipoCuenta(tc);
					} else {
						cuen.setNombre("Cuenta CD");
						TipoCuenta tc = tipoCuentaService.buscar("Caja de ahorro en dólares");
						cuen.setTipoCuenta(tc);
					}

					cuen.setSaldo(0);
					cuen.setEstado(true);
					
			    	SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
			        Calendar calendar = Calendar.getInstance();
			        Date dateObj = calendar.getTime();
			        String formattedDate = dtf.format(dateObj);
					cuen.setFechaAlta(formattedDate);
					cuen.setFechaUltimaModificacion("");
					cuen.setCliente(cli);
					cuentaService.crear(cuen);

					session.setAttribute("success", "Se creo la cuenta " + cuen.getNroCuenta() + " de manera correcta.");
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
		return mv;
	}
	
	@RequestMapping("modificarCuenta")
	public ModelAndView modificacionCuenta(HttpServletRequest request, Integer cbu) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		mv.setViewName("modificarCuenta");
		return mv;
	}
	
	@RequestMapping("listarCuentasPorCliente")
	public ModelAndView listarCuentasPorCliente(HttpServletRequest request, Integer dni) throws NumberFormatException, Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		
		if (dni != null) {
			try {
				Cliente cli = clienteService.buscarPorDni(dni);
				cli.setId(cli.getId());
				mv.addObject("Cuenta", cuentaService.buscarCantidadCuentas(cli.getId()));
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
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		try {
			Cuenta cuen = cuentaService.buscar(cbu.toString());
			cuentaService.eliminar(cuen);
			session.setAttribute("success",
					"Se desactivó la cuenta " + cuen.getNroCuenta() + " de manera correcta.");
			mv = new ModelAndView("redirect:listarCuentas.html");		
			
		} catch (Exception e) {
			session.setAttribute("error", "Problemas para eliminar cuenta.");
			mv = new ModelAndView("redirect:listarCuentas.html");
		}
		return mv;
	}
	
	@RequestMapping("resumen")
	public ModelAndView resumen(HttpServletRequest request, Integer Val) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		Cliente cliente = (Cliente)session.getAttribute("persona");
		List<Cuenta> cuentas = cuentaService.buscarCantidadCuentas(cliente.getId());
		
		mv.addObject("Cliente", cliente);
		mv.addObject("Cuentas", cuentas);
		if(Val == 1) {
			Cuenta cuenta = cuentas.get(0);
			mv.addObject("Cuenta", cuenta);
			List<Movimiento> mov = movimientoService.listarPorIdCuenta(cuenta.getId());
			mv.addObject("Movimientos", mov);
		}else {
			String cbu = request.getParameter("selectCuenta").toString();
			Cuenta cuenta = cuentaService.buscar(cbu);
			mv.addObject("Cuenta", cuenta);
			List<Movimiento> mov = movimientoService.listarPorIdCuenta(cuenta.getId());
			mv.addObject("Movimientos", mov);
		}
		mv.setViewName("resumen");
		return mv;
	}

}
