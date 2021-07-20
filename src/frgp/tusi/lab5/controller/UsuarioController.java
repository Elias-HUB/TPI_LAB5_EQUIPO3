package frgp.tusi.lab5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.codegen.AnnotationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.config.Config;
import frgp.tusi.lab5.model.Cliente;
import frgp.tusi.lab5.model.Empleado;
import frgp.tusi.lab5.model.Usuario;
import frgp.tusi.lab5.serviceImpl.ClienteServiceImpl;
import frgp.tusi.lab5.serviceImpl.EmpleadoServiceImpl;
import frgp.tusi.lab5.serviceImpl.UsuarioServiceImpl;

@Controller
public class UsuarioController {
	
	
	private ApplicationContext appContext;
	private UsuarioServiceImpl usuarioService;
	private ClienteServiceImpl clienteService;
	private EmpleadoServiceImpl empleadoService;
	
	public UsuarioController() {
		appContext = new AnnotationConfigApplicationContext(Config.class);
		usuarioService = (UsuarioServiceImpl) appContext.getBean("UsuarioServiceImplBean");
		clienteService = (ClienteServiceImpl) appContext.getBean("ClienteServiceImplBean");
		empleadoService = (EmpleadoServiceImpl) appContext.getBean("EmpleadoServiceImplBean");
	}
	
	@RequestMapping("altaUsuario")
	public ModelAndView altaUsuario() {
		ModelAndView mv = (ModelAndView) appContext.getBean("ModelAndViewBean");
		return mv;
	}
	
	@RequestMapping("modificacionUsuario")
	public ModelAndView modificacionUsuario() {
		ModelAndView mv = (ModelAndView) appContext.getBean("ModelAndViewBean");
		return mv;
	}
	
	@RequestMapping("eliminacionUsuario")
	public ModelAndView eliminacionUsuario() {
		ModelAndView mv = (ModelAndView) appContext.getBean("ModelAndViewBean");
		return mv;
	}
	
	@RequestMapping("listarUsuario")
	public ModelAndView listarUsuario() {
		ModelAndView mv = (ModelAndView) appContext.getBean("ModelAndViewBean");
		return mv;
	}
	
	//@RequestMapping("inicioSessionUsuario")
	@RequestMapping(value ="/inicioSessionUsuario.html" , method= { RequestMethod.POST})
	public ModelAndView inicioSessionUsuario(HttpServletRequest request, String user, String pass) throws Exception {		
		ModelAndView mv = (ModelAndView) appContext.getBean("ModelAndViewBean");
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
		} finally {
			//((ConfigurableApplicationContext)(appContext)).close();
		}
		return mv;
	}

	@RequestMapping("login")
	public ModelAndView index() {		
		ModelAndView mv = (ModelAndView) appContext.getBean("ModelAndViewBean");
		mv.setViewName("login");
		//((ConfigurableApplicationContext)(appContext)).close();
		return mv;
	}
	
	@RequestMapping("CerrarSession")
	public ModelAndView CerrarSession(HttpServletRequest request) {
		ModelAndView mv = (ModelAndView) appContext.getBean("ModelAndViewBean");
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		mv.setViewName("login");
		//((ConfigurableApplicationContext)(appContext)).close();
		return mv;
	}
}
