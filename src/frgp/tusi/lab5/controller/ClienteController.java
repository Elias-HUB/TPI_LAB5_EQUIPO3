package frgp.tusi.lab5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {
	
	@RequestMapping("altaCliente")
	public ModelAndView altaCliente() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("altaCliente");
		return mv;
	}
	
	@RequestMapping("detalleCliente")
	public ModelAndView detalleCliente() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("detalleCliente");
		return mv;
	}
	
	
	@RequestMapping("modificarCliente")
	public ModelAndView modificarCliente() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("modificarCliente");
		return mv;
	}
	
	@RequestMapping("eliminarCliente")
	public ModelAndView eliminarCliente() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("listarClientes")
	public ModelAndView listarClientes() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cliente");
		return mv;
	}

}
