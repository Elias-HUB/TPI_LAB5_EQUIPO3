package frgp.tusi.lab5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.model.Usuario;
import frgp.tusi.lab5.serviceImpl.UsuarioServiceImpl;

@Controller
public class UsuarioController {
	
	private UsuarioServiceImpl usuarioService;
//	private ClienteServiceImpl clienteService;
	
	public UsuarioController() {
		usuarioService = new UsuarioServiceImpl();
//		clienteService = new ClienteServiceImpl();
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
	
	//@RequestMapping("inicioSessionUsuario")
	@RequestMapping(value ="/inicioSessionUsuario.html" , method= { RequestMethod.POST})
	public ModelAndView inicioSessionUsuario(HttpServletRequest request, String user, String pass) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			HttpSession session = request.getSession();
			Usuario usuario = usuarioService.buscarUsuario(user, pass);
				if (usuario.getTipoUsuario().equals("empleado")) {
					session.setAttribute("user", usuario.getTipoUsuario());
					return new ModelAndView("redirect:listarClientes.html");
//					mv.setViewName("cliente");					
				}
				else {
					session.setAttribute("user", usuario.getTipoUsuario());
					return new ModelAndView("redirect:resumen.html");
//					mv.setViewName("resumen");
				}
		} catch (Exception e) {
			mv.addObject("ErrorLogin","Usuario o contraseña invalida.");			
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
