package frgp.tusi.lab5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.modelImpl.Cliente;
import frgp.tusi.lab5.modelImpl.Usuario;
import frgp.tusi.lab5.serviceImpl.ClienteServiceImpl;
import frgp.tusi.lab5.serviceImpl.UsuarioServiceImpl;

@Controller
public class UsuarioController {
	
	private UsuarioServiceImpl usuarioService;
	private ClienteServiceImpl clienteService;
	
	public UsuarioController() {
		usuarioService = new UsuarioServiceImpl();
		clienteService = new ClienteServiceImpl();
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
		Cliente cli = new Cliente();
    	cli.setApellido("Suárez");
    	cli.setNombre("Jacinta");
    	cli.setDni(1325464);
    	cli.setSexo("F");
    	cli.setNacionalidad("Argentina");
    	cli.setFechaNacimiento("02/11/1944");
    	cli.setDomicilio("Javascript 99");
//    	cli.setCuentas(cuentasCliente3);
		
		clienteService.eliminar(cli);
		try {
			HttpSession session = request.getSession();
			Usuario usuario = usuarioService.buscarUsuario(user, pass);
				if (usuario.getTipoUsuario() == "cliente") {
					mv.setViewName("cliente");
					session.setAttribute("user", usuario.getTipoUsuario());
				}
				else {
					mv.setViewName("resumen");
					session.setAttribute("user", usuario.getTipoUsuario());
				}
		} catch (Exception e) {
			mv.addObject("Usuario o contraseña invalida.");
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
