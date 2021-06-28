package frgp.tusi.lab5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.modelImpl.Cliente;
import frgp.tusi.lab5.serviceImpl.ClienteServiceImpl;
import frgp.tusi.lab5.serviceImpl.UsuarioServiceImpl;

@Controller
public class ClienteController {

	private ClienteServiceImpl clienteService;
	private ModelAndView mv;

	public ClienteController() {
		clienteService = new ClienteServiceImpl();
		mv = new ModelAndView();
	}

	@RequestMapping("altaCliente")
	public ModelAndView altaCliente() {

		mv.setViewName("altaCliente");
		return mv;
	}

	@RequestMapping("detalleCliente")
	public ModelAndView detalleCliente(Integer dni) {
		try {
			mv.addObject("Cliente", clienteService.buscarPorDni(dni));
			mv.setViewName("detalleCliente");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mv;
	}

	@RequestMapping("modificarCliente")
	public ModelAndView modificarCliente() {
		mv.setViewName("modificarCliente");
		return mv;
	}

	@RequestMapping("eliminarCliente")
	public ModelAndView eliminarCliente() {
		return mv;
	}

	@RequestMapping("listarClientes")
	public ModelAndView listarClientes() throws Exception {
		try {
			mv.addObject("Clientes", clienteService.listar());
			mv.setViewName("cliente");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mv;
	}

}
