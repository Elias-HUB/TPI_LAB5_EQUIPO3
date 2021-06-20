package frgp.tusi.lab5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {
	
	@RequestMapping("altaCliente")
	public ModelAndView altaCliente() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping("modificacionCliente")
	public ModelAndView modificacionCliente() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("eliminacionCliente")
	public ModelAndView eliminacionCliente() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("listarClientes")
	public ModelAndView listarClientes() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

}
