package frgp.tusi.lab5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CuentaController {
	
	@RequestMapping("altaCuenta")
	private ModelAndView altaCuenta() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("modificacionCuenta")
	private ModelAndView modificacionCuenta() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("eliminacionCuenta")
	private ModelAndView eliminacionCuenta() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("listarCuentas")
	private ModelAndView listarCuenta() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

}
