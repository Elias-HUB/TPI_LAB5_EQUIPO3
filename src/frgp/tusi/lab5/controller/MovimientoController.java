package frgp.tusi.lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovimientoController {
	
	@Autowired
	@Qualifier("ModelAndViewBean")
	private ModelAndView mv;
	
	public MovimientoController() {}
	
	@RequestMapping("movimientos")
	public ModelAndView movimientos() {
		return mv;
	}
	
	@RequestMapping("listarMovimientos")
	public ModelAndView listarMovimientos() {
		return mv;
	}
}