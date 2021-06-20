package frgp.tusi.lab5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpleadoController {

	@RequestMapping("altaEmpleado")
	public ModelAndView altaEmpleado() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("modificacionEmpleado")
	public ModelAndView modificacionEmpleado() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("eliminacionEmpleado")
	public ModelAndView eliminacionEmpleado() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("listarEmpleados")
	public ModelAndView listarEmpleados() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

}
