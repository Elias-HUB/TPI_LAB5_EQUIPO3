package frgp.tusi.lab5.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.model.Cliente;
import frgp.tusi.lab5.model.Cuenta;
import frgp.tusi.lab5.model.TipoCuenta;
import frgp.tusi.lab5.serviceImpl.ClienteServiceImpl;
import frgp.tusi.lab5.serviceImpl.CuentaServiceImpl;
import frgp.tusi.lab5.serviceImpl.TipoCuentaServiceImpl;

@Controller
public class CuentaController {
	
	private ClienteServiceImpl clienteService;
	private CuentaServiceImpl cuentaService;
	private TipoCuentaServiceImpl tipoCuentaService;
	
	public CuentaController() {
		clienteService = new ClienteServiceImpl();
		cuentaService = new CuentaServiceImpl();
		tipoCuentaService = new TipoCuentaServiceImpl();
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
						TipoCuenta tc = tipoCuentaService.buscar("Caja de ahorro en d�lares");
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
					session.setAttribute("error", "El cliente no puede tener m�s de 4 cuentas");
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
					"Se desactiv� la cuenta " + cuen.getNroCuenta() + " de manera correcta.");
			mv = new ModelAndView("redirect:listarCuentas.html");		
			
		} catch (Exception e) {
			session.setAttribute("error", "Problemas para eliminar cuenta.");
			mv = new ModelAndView("redirect:listarCuentas.html");
		}
		return mv;
	}
	
	@RequestMapping("resumen")
	public ModelAndView resumen() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resumen");
		return mv;
	}

}
