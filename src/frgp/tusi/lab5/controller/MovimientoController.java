package frgp.tusi.lab5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovimientoController {
	
	@RequestMapping("movimientos")
	public ModelAndView movimientos() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("listarMovimientos")
	public ModelAndView listarMovimientos() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

}
