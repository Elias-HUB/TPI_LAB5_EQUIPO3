package frgp.tusi.lab5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.model.Cliente;
import frgp.tusi.lab5.model.Domicilio;
import frgp.tusi.lab5.serviceImpl.ClienteServiceImpl;

@Controller
public class ClienteController {

	private ClienteServiceImpl clienteService;

	public ClienteController() {
		clienteService = new ClienteServiceImpl();
	}

	@RequestMapping("altaCliente")
	public ModelAndView altaCliente() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("altaCliente");
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
				cli.setApellido(request.getParameter("txtApellido"));
				cli.setNombre(request.getParameter("txtNombre"));
				cli.setDni(Integer.parseInt(request.getParameter("txtDni").toString()));
				if (request.getParameter("btnradio").equals("on")) {
					cli.setSexo("M");
				} else {
					cli.setSexo("F");
				}
				cli.setEstado(true);
				cli.setNacionalidad(request.getParameter("TboxNacionalidad"));
				cli.setFechaNacimiento(request.getParameter("TboxFecha"));
				Domicilio domicilio = cli.getDomicilio();
				domicilio.setDireccion(request.getParameter("txtCalle"));
				domicilio.setLocalidad(request.getParameter("txtLocalidad"));
				domicilio.setProvincia(request.getParameter("txtProvincia"));
				cli.setDomicilio(domicilio);
				clienteService.actualizar(cli);
				session.setAttribute("success",
						"Se modificó al cliente " + cli.getNombre() + " " + cli.getApellido() + " de manera correcta.");
				mv = new ModelAndView("redirect:listarClientes.html");
			} else {
				mv = new ModelAndView("redirect:modificarCliente.html");
				mv.addObject("Cliente", clienteService.buscarPorDni(dni));
				mv.setViewName("modificarCliente");
			}
		} catch (Exception e) {
			session.setAttribute("error", "Problemas para modificar clientes.");
			mv = new ModelAndView("redirect:listarClientes.html");
		}
		return mv;
	}

	@RequestMapping("eliminarCliente")
	public ModelAndView eliminarCliente() {
		ModelAndView mv = new ModelAndView();
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
