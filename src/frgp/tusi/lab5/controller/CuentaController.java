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

import frgp.tusi.lab5.model.Cuenta;
import frgp.tusi.lab5.model.TipoCuenta;
import frgp.tusi.lab5.serviceImpl.ClienteServiceImpl;
import frgp.tusi.lab5.serviceImpl.CuentaServiceImpl;
import frgp.tusi.lab5.serviceImpl.UsuarioServiceImpl;

@Controller
public class CuentaController {
	
	private UsuarioServiceImpl usuarioService;
	private ClienteServiceImpl clienteService;
	private CuentaServiceImpl cuentaService;
	
	public CuentaController() {
		usuarioService = new UsuarioServiceImpl();
		clienteService = new ClienteServiceImpl();
		cuentaService = new CuentaServiceImpl();
	}
	
	@RequestMapping("listarCuentas")
	public ModelAndView listarCuenta() {
		ModelAndView mv = new ModelAndView();
		try {
//			List<Cuenta> cuentas = cuentaService.listar();
//			mv.addObject(cuentas);			
			mv.addObject("Cuenta", cuentaService.listar());
		} catch (Exception e) {
			mv.addObject(e.getMessage());
		}
		mv.setViewName("listarCuentas");
		return mv;
	}
		
//	private ModelAndView listarCuentas() {
//		ModelAndView mv = new ModelAndView();
//		try {
////			List<Cuenta> cuentas = cuentaService.listar();
////			mv.addObject(cuentas);			
//			mv.addObject("Cuenta", cuentaService.listar());
//		} catch (Exception e) {
//			mv.addObject(e.getMessage());
//		}
//		mv.setViewName("listarCuentas");
//		return mv;
//	}
	
//	@RequestMapping("altaCuenta")
//	public ModelAndView altaCuenta(HttpServletRequest request, String user, String pass) throws Exception  {
//		ModelAndView mv = new ModelAndView();
////		mv = new ModelAndView("redirect:altaCliente.html");
//		mv.setViewName("altaCuenta");
//		return mv;
//	}

	@RequestMapping("altaCuenta")
	public ModelAndView altaCuenta( HttpServletRequest request, String dni, String tipoCuenta) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		try {
			if (request.getParameter("txtNombre") != null) {
//				Cuenta
				Random rnd = new Random();
				Cuenta cuen = new Cuenta();
				cuen.setCbu(rnd.nextInt(10));
				cuen.setNroCuenta(rnd.nextInt(10));
				cuen.setNombre(tipoCuenta);
				
				TipoCuenta tc = new TipoCuenta();
				tc.setDescripcion(tipoCuenta);
				cuen.setTipoCuenta(tc);
				cuen.setSaldo(0);
				cuen.setEstado(true);
				
		    	SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
		        Calendar calendar = Calendar.getInstance();
		        Date dateObj = calendar.getTime();
		        String formattedDate = dtf.format(dateObj);
				
				cuen.setFechaAlta(formattedDate);

				
			}else {
				mv.addObject("DNI", dni);				
			}
//			String a = request.getParameter("btnCaja");
//			String b = request.getParameter("txtNombre");
//			String c = request.getParameter("txtApellido");
//			String d = request.getParameter("TboxFecha");
//			String e = request.getParameter("btnradio");
//			String f = request.getParameter("txtCalle");
//			String g = request.getParameter("txtLocalidad");
//			String h = request.getParameter("txtProvincia");
//			String i = request.getParameter("TboxNacionalidad");
//			String j = request.getParameter("txtDni");
			
//			mv.addObject("Cliente", clienteService.buscarPorDni(dni));
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		mv.setViewName("altaCuenta");
		return mv;
	}
	
	@RequestMapping("modificarCuenta")
	public ModelAndView modificacionCuenta(HttpServletRequest request, Integer cbu) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		mv.setViewName("modificarCuenta");
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
	public ModelAndView resumen() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resumen");
		return mv;
	}

}
