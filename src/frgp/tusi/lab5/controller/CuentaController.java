package frgp.tusi.lab5.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.model.Cuenta;
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
		return listarCuentas();
	}
	
	@RequestMapping("altaCuentaView")
	public ModelAndView altaCuenta(HttpServletRequest request, String user, String pass) throws Exception  {		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("altaCuenta");
		return mv;
//		Cuenta cuenta = new Cuenta();
//		cuentaService.crear(cuenta);
//		return listarCuentas();
	}
	
	private ModelAndView listarCuentas() {
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
	
	@RequestMapping("altaCuenta")
	public ModelAndView altaCuentaVie(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
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
