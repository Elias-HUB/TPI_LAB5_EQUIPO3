package frgp.tusi.lab5.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.modelImpl.Cuenta;
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
	
	@RequestMapping("altaCuenta")
	private ModelAndView altaCuenta() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("altaCuenta");
		return mv;
	}
	
	@RequestMapping("modificarCuenta")
	private ModelAndView modificacionCuenta() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("modificarCuenta");
		return mv;
	}
	
	@RequestMapping("eliminarCuenta")
	private ModelAndView eliminacionCuenta() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("listarCuentas")
	private ModelAndView listarCuenta() {
		ModelAndView mv = new ModelAndView();
		try {
			List<Cuenta> cuentas = cuentaService.listar();
			mv.addObject(cuentas);
		} catch (Exception e) {
			mv.addObject(e.getMessage());
			mv.setViewName("listarCuentas");
		}
		
		mv.setViewName("listarCuentas");
		return mv;
	}
	
	@RequestMapping("resumen")
	private ModelAndView resumen() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resumen");
		return mv;
	}

}
