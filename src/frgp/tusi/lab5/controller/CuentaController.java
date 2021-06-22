package frgp.tusi.lab5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CuentaController {
	
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
		mv.setViewName("listarCuentas");
		return mv;
	}

}
