package frgp.tusi.lab5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.modelImpl.Usuario;
import frgp.tusi.lab5.serviceImpl.UsuarioServiceImpl;

@Controller
public class UsuarioController {
	
	private UsuarioServiceImpl usuarioService;
	
	public UsuarioController() {
		usuarioService = new UsuarioServiceImpl(); 
		
	}
	
	
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
	public ModelAndView inicioSessionUsuario(HttpServletRequest request, String user, String pass) {
		
		try {
			ModelAndView mv = new ModelAndView();
			HttpSession session = request.getSession();
			
			Usuario usuario = usuarioService.buscarUsuario(user, pass);
			mv.addObject(usuario);
			
			if(usuario != null) {		
				
				if (usuario.getTipoUsuario() == "cliente") {
					mv.setViewName("cliente");
					session.setAttribute("user", usuario.getTipoUsuario());
				}
				else {
					mv.setViewName("resumen");
					session.setAttribute("user", usuario.getTipoUsuario());
				}
			}
			else {
				mv.setViewName("login");
			}
			
			return mv;
		} catch (Exception e) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Rompe");
		}
		
	}

	@RequestMapping("login")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
}
