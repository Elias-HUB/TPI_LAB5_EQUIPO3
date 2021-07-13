 package frgp.tusi.lab5.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.model.Cliente;
import frgp.tusi.lab5.model.Domicilio;
import frgp.tusi.lab5.model.Nacionalidad;
import frgp.tusi.lab5.model.Provincia;
import frgp.tusi.lab5.model.Usuario;
import frgp.tusi.lab5.serviceImpl.ClienteServiceImpl;
import frgp.tusi.lab5.serviceImpl.UsuarioServiceImpl;
import frgp.tusi.lab5.serviceImpl.NacionalidadServicesImpl;
import frgp.tusi.lab5.serviceImpl.ProvinciaServicesImpl;;

@Controller
public class ClienteController {

	private ClienteServiceImpl clienteService;
	private UsuarioServiceImpl usuarioService;	
	private NacionalidadServicesImpl nacionalidadService;
	private ProvinciaServicesImpl provinciaService;

	public ClienteController() {
		clienteService = new ClienteServiceImpl();
		usuarioService = new UsuarioServiceImpl(); 
		nacionalidadService = new NacionalidadServicesImpl();
		provinciaService = new ProvinciaServicesImpl();
	}

	@RequestMapping("altaCliente")
	public ModelAndView altaCliente(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		try {
			if (request.getParameter("txtNombre") != null) {
				Cliente cli = new Cliente();
				try {
				usuarioService.buscarPorUsuario(request.getParameter("txtDni").toString());			
				session.setAttribute("error", "Ya existe un usuario con el mismo documento.");
				mv = new ModelAndView("redirect:listarClientes.html");
				} catch (Exception e) {
				cli.setApellido(request.getParameter("txtApellido").substring(0,1).toUpperCase() + request.getParameter("txtApellido").substring(1));				
				cli.setNombre(request.getParameter("txtNombre").substring(0,1).toUpperCase() + request.getParameter("txtNombre").substring(1));
				cli.setDni(Integer.parseInt(request.getParameter("txtDni").toString()));
				if (request.getParameter("btnradio").equals("on")) {
					cli.setSexo("M");
				} else {
					cli.setSexo("F");
				}
				cli.setEstado(true);
				Nacionalidad nacionalidad = nacionalidadService.BuscarPorID(Integer.parseInt(request.getParameter("TboxNacionalidad").toString()));				
				Provincia provincia = provinciaService.BuscarPorID(Integer.parseInt(request.getParameter("txtProvincia").toString()));
				cli.setNacionalidad(nacionalidad);
				cli.setProvincia(provincia);
				cli.setFechaNacimiento(request.getParameter("TboxFecha"));
				
				Domicilio domicilio = new Domicilio();
				domicilio.setDireccion(request.getParameter("txtCalle"));
				domicilio.setLocalidad(request.getParameter("txtLocalidad"));
				
				Usuario usuario = new Usuario();
		    	usuario.setEstado(true);
		    	usuario.setFechaAlta(new Date());
		    	usuario.setFechaUltimaModificacion(new Date());
		    	usuario.setTipoUsuario("cliente");
		    	usuario.setPass("1234");
		    	usuario.setUserName(cli.getDni().toString());
		    	
		    	cli.setUsuario(usuario);
				cli.setDomicilio(domicilio);
				clienteService.crear(cli);
				session.setAttribute("success",
						"Se creó al cliente " + cli.getNombre() + " " + cli.getApellido() + " con su usuario de manera correcta.");
				mv = new ModelAndView("redirect:listarClientes.html");
				}
			} else {
				mv = new ModelAndView("redirect:altaCliente.html");
				mv.addObject("Nacionalidades", nacionalidadService.listar());
				mv.addObject("Provincias", provinciaService.listar());				
				mv.setViewName("altaCliente");
			}
		} catch (Exception e) {
			session.setAttribute("error", "Problemas para crear al clientes.");
			mv = new ModelAndView("redirect:listarClientes.html");
		}
		return mv;
	}

	@RequestMapping("detalleCliente")
	public ModelAndView detalleCliente(Integer dni) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("Cliente", clienteService.buscarPorDni(dni));
			mv.setViewName("detalleCliente");
			// mv = new ModelAndView("redirect:detalleCliente.html");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mv;
	}

	@RequestMapping("modificarCliente")
	public ModelAndView modificarCliente(HttpServletRequest request, Integer dni) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		try {
			if (request.getParameter("txtDni") != null) {
				Cliente cli = clienteService.buscarPorDni(dni);				
				try {
					if(Integer.parseInt(request.getParameter("txtDni").toString()) == dni) {
						throw new Exception("");
					} else {
					usuarioService.buscarPorUsuario(request.getParameter("txtDni").toString());
					session.setAttribute("error", "Ya existe un usuario con el mismo documento. No se pudo modificar al cliente "
							+ cli.getNombre() +" "+ cli.getApellido()+".");
					mv = new ModelAndView("redirect:listarClientes.html");
					}
				} catch (Exception e) {
					cli.setApellido(request.getParameter("txtApellido").substring(0,1).toUpperCase() + request.getParameter("txtApellido").substring(1));				
					cli.setNombre(request.getParameter("txtNombre").substring(0,1).toUpperCase() + request.getParameter("txtNombre").substring(1));
					cli.setDni(Integer.parseInt(request.getParameter("txtDni").toString()));
					if (request.getParameter("btnradio").equals("on")) {
						cli.setSexo("M");
					} else {
						cli.setSexo("F");
					}
					Nacionalidad nacionalidad = nacionalidadService.BuscarPorID(Integer.parseInt(request.getParameter("TboxNacionalidad").toString()));				
					Provincia provincia = provinciaService.BuscarPorID(Integer.parseInt(request.getParameter("txtProvincia").toString()));
					cli.setNacionalidad(nacionalidad);
					cli.setProvincia(provincia);
					cli.setFechaNacimiento(request.getParameter("TboxFecha"));
					cli.setEstado(Boolean.parseBoolean(request.getParameter("tboxEstado")));
					Usuario usuario = cli.getUsuario();
					usuario.setEstado(Boolean.parseBoolean(request.getParameter("tboxEstado")));
					usuario.setUserName(cli.getDni().toString());
					cli.setUsuario(usuario);
					Domicilio domicilio = cli.getDomicilio();
					domicilio.setDireccion(request.getParameter("txtCalle"));
					domicilio.setLocalidad(request.getParameter("txtLocalidad"));
					cli.setDomicilio(domicilio);
					clienteService.actualizar(cli);
					session.setAttribute("success",
							"Se modificó al cliente " + cli.getNombre() + " " + cli.getApellido() + " de manera correcta.");
					mv = new ModelAndView("redirect:listarClientes.html");
				}
			} else {
				mv = new ModelAndView("redirect:modificarCliente.html");
				mv.addObject("Cliente", clienteService.buscarPorDni(dni));
				mv.addObject("Nacionalidades", nacionalidadService.listar());
				mv.addObject("Provincias", provinciaService.listar());
				mv.setViewName("modificarCliente");
			}
		} catch (Exception e) {
			session.setAttribute("error", "Problemas para modificar clientes.");
			mv = new ModelAndView("redirect:listarClientes.html");
		}
		return mv;
	}

	@RequestMapping("eliminarCliente")
	public ModelAndView eliminarCliente(HttpServletRequest request, Integer dni) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		try {
		Cliente cli = clienteService.buscarPorDni(dni);
		Usuario usu = cli.getUsuario();
		usuarioService.eliminarUsuario(usu);
		clienteService.eliminar(cli);
		session.setAttribute("success",
				"Se desactivó al cliente " + cli.getNombre() + " " + cli.getApellido() + " de manera correcta.");
		mv = new ModelAndView("redirect:listarClientes.html");		
		} catch (Exception e) {
			session.setAttribute("error", "Problemas para eliminar clientes.");
			mv = new ModelAndView("redirect:listarClientes.html");
		}
		return mv;
	}

	@RequestMapping("listarClientes")
	public ModelAndView listarClientes() throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("Clientes", clienteService.listar());
			mv.setViewName("cliente");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mv;
	}
}
