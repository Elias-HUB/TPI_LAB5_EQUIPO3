package frgp.tusi.lab5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.model.Cliente;
import frgp.tusi.lab5.model.Empleado;
import frgp.tusi.lab5.model.Usuario;
import frgp.tusi.lab5.service.EmpleadoService;
import frgp.tusi.lab5.serviceImpl.ClienteServiceImpl;
import frgp.tusi.lab5.serviceImpl.EmpleadoServiceImpl;
import frgp.tusi.lab5.serviceImpl.UsuarioServiceImpl;

@Controller
public class UsuarioController {
	
	private UsuarioServiceImpl usuarioService;
	private ClienteServiceImpl clienteService;
	private EmpleadoServiceImpl empleadoService;
	
	public UsuarioController() {
		usuarioService = new UsuarioServiceImpl();
		clienteService = new ClienteServiceImpl();
		empleadoService = new EmpleadoServiceImpl();
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
		HttpSession session = request.getSession();
		try {
			Usuario usuario = usuarioService.buscarUsuario(user, pass);
			if(usuario.getEstado() == true) {				
				session.setAttribute("user", usuario);
				if (usuario.getTipoUsuario().equals("empleado")) {		
					Empleado empleado = empleadoService.buscarPorDni(Integer.parseInt(user));
					session.setAttribute("persona", empleado);
					return new ModelAndView("redirect:listarClientes.html");
				}
				else {
					Cliente cliente = clienteService.buscarPorDni(Integer.parseInt(user));
					session.setAttribute("persona", cliente);
					return new ModelAndView("redirect:resumen.html?Val=1");
				}
			} else {
				session.setAttribute("error", "Usuario desactivado.");
				mv.setViewName("login");	
			}
		} catch (Exception e) {
			session.setAttribute("error", "Usuario o contraseña invalida.");			
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
	
	@RequestMapping("CerrarSession")
	public ModelAndView CerrarSession(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		mv.setViewName("login");
		return mv;
	}
}
