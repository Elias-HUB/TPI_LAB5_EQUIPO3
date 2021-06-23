package frgp.tusi.lab5.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
	
	@RequestMapping("altaUsuario")
	public ModelAndView altaUsuario() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("modificacionUsuario")
	public ModelAndView modificacionUsuario() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("eliminacionUsuario")
	public ModelAndView eliminacionUsuario() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("listarUsuario")
	public ModelAndView listarUsuario() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("inicioSessionUsuario")
	public ModelAndView inicioSessionUsuario(String user) {
		ModelAndView mv = new ModelAndView();
		if(user.toLowerCase().equals("admin")) {
			mv.setViewName("cliente");
			mv.addObject("user", user.toLowerCase());
		}
		else if (user.toLowerCase().equals("cliente")) {
			mv.setViewName("resumen");
			mv.addObject("user", user.toLowerCase());
		}
		else{
			mv.setViewName("login");
		}
		return mv;
	}

	@RequestMapping("login")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
}
