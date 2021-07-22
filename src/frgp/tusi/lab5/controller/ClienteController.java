package frgp.tusi.lab5.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.config.Config;
import frgp.tusi.lab5.model.Cliente;
import frgp.tusi.lab5.model.Cuenta;
import frgp.tusi.lab5.model.Domicilio;
import frgp.tusi.lab5.model.Movimiento;
import frgp.tusi.lab5.model.Nacionalidad;
import frgp.tusi.lab5.model.Provincia;
import frgp.tusi.lab5.model.TipoCuenta;
import frgp.tusi.lab5.model.TipoMovimiento;
import frgp.tusi.lab5.model.Usuario;
import frgp.tusi.lab5.serviceImpl.ClienteServiceImpl;
import frgp.tusi.lab5.serviceImpl.CuentaServiceImpl;
import frgp.tusi.lab5.serviceImpl.NacionalidadServicesImpl;
import frgp.tusi.lab5.serviceImpl.ProvinciaServicesImpl;
import frgp.tusi.lab5.serviceImpl.TipoCuentaServiceImpl;
import frgp.tusi.lab5.serviceImpl.TipoMovimientoServiceImpl;
import frgp.tusi.lab5.serviceImpl.UsuarioServiceImpl;;

@Controller
public class ClienteController {

	@Autowired
	@Qualifier("ClienteServiceImplBean")
	private ClienteServiceImpl clienteService;
	
	@Autowired
	@Qualifier("CuentaServiceImplBean")
	private CuentaServiceImpl cuentaService;
	
	@Autowired
	@Qualifier("UsuarioServiceImplBean")
	private UsuarioServiceImpl usuarioService;
	
	@Autowired
	@Qualifier("NacionalidadServicesImplBean")
	private NacionalidadServicesImpl nacionalidadService;
	
	@Autowired
	@Qualifier("ProvinciaServicesImplBean")
	private ProvinciaServicesImpl provinciaService;
	
	@Autowired
	@Qualifier("TipoCuentaServiceImplBean")
	private TipoCuentaServiceImpl tipoCuentaService;
	
	@Autowired
	@Qualifier("TipoMovimientoServiceImplBean")
	private TipoMovimientoServiceImpl tipoMovimientoService;
	
	@Autowired
	@Qualifier("ModelAndViewBean")
	private ModelAndView mv;

	private Movimiento movimiento;
	
	private Domicilio domicilio;

	private Usuario usuario;
	
	private Cuenta cuenta;
	
	private Cliente cliente;
	
	public ClienteController() {}

	@RequestMapping("altaCliente")
	public ModelAndView altaCliente(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		
		cliente = (Cliente)appContext.getBean("ClienteBean");
		cuenta = (Cuenta)appContext.getBean("CuentaBean");
		usuario = (Usuario)appContext.getBean("UsuarioBean");
		movimiento = (Movimiento)appContext.getBean("MovimientoBean");
		domicilio = (Domicilio)appContext.getBean("DomicilioBean");
		
		try {
			if (request.getParameter("txtNombre") != null) {

				try {
					usuarioService.buscarPorUsuario(request.getParameter("txtDni").toString());
					session.setAttribute("error", "Ya existe un usuario con el mismo documento.");
					mv = new ModelAndView("redirect:listarClientes.html");
				} catch (Exception e) {
					cliente.setApellido(request.getParameter("txtApellido").substring(0, 1).toUpperCase()
							+ request.getParameter("txtApellido").substring(1));
					cliente.setNombre(request.getParameter("txtNombre").substring(0, 1).toUpperCase()
							+ request.getParameter("txtNombre").substring(1));
					cliente.setDni(Integer.parseInt(request.getParameter("txtDni").toString()));
					if (request.getParameter("btnradio").equals("on")) {
						cliente.setSexo("M");
					} else {
						cliente.setSexo("F");
					}
					cliente.setEstado(true);
					Nacionalidad nacionalidad = nacionalidadService
							.BuscarPorID(Integer.parseInt(request.getParameter("TboxNacionalidad").toString()));
					Provincia provincia = provinciaService
							.BuscarPorID(Integer.parseInt(request.getParameter("txtProvincia").toString()));
					cliente.setNacionalidad(nacionalidad);
					cliente.setProvincia(provincia);
					cliente.setFechaNacimiento(request.getParameter("TboxFecha"));

					domicilio.setDireccion(request.getParameter("txtCalle"));
					domicilio.setLocalidad(request.getParameter("txtLocalidad"));

					usuario.setEstado(true);
					usuario.setFechaAlta(new Date());
					usuario.setFechaUltimaModificacion(new Date());
					usuario.setTipoUsuario("cliente");
					usuario.setPass("1234");
					usuario.setUserName(cliente.getDni().toString());

					cliente.setUsuario(usuario);
					cliente.setDomicilio(domicilio);

					// Generar cuenta y movimiento
					Random rnd = new Random();
					List<Cuenta> cuentasCliente = new ArrayList<Cuenta>();
					List<Movimiento> movimientosCuentaOrigen = new ArrayList<Movimiento>();

					SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
					Calendar calendar = Calendar.getInstance();
					Date dateObj = calendar.getTime();
					String formattedDate = dtf.format(dateObj);

					TipoCuenta tipoCuentaCA = tipoCuentaService.buscar("Caja de ahorro en pesos");
					TipoMovimiento tipoAltaCuenta = tipoMovimientoService.buscar("Alta de Cuenta");


					movimiento.setDetalle("Alta de Cuenta");
					movimiento.setEstado(true);
					movimiento.setFecha(new Date());
					movimiento.setFechaUltimaModificacion(new Date());
					movimiento.setTipoMovimiento(tipoAltaCuenta);
					movimiento.setImporte(10000);
					movimientosCuentaOrigen.add(movimiento);

					
					cuenta.setCbu(rnd.nextInt(1000000000));
					cuenta.setNroCuenta(rnd.nextInt(1000000000));
					cuenta.setNombre("Cuenta CA");
					cuenta.setSaldo(10000);
					cuenta.setEstado(true);
					cuenta.setTipoCuenta(tipoCuentaCA);
					cuenta.setFechaAlta(formattedDate);
					cuenta.setFechaUltimaModificacion(formattedDate);
					cuenta.setMovimientos(movimientosCuentaOrigen);
					
					
					cuentasCliente.add(cuenta);

					cliente.setCuentas(cuentasCliente);
					clienteService.crear(cliente);
//					Cliente cli = clienteService.buscarPorDni(cliente.getDni());
//					cuenta.setCliente(cli);
//					cuentaService.crear(cuenta);
//					
					session.setAttribute("success", "Se creó al cliente " + cliente.getNombre() + " " + cliente.getApellido()
							+ " con su usuario y cuenta de manera correcta.");
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
	public ModelAndView detalleCliente(HttpServletRequest request, Integer dni) {
		HttpSession session = request.getSession();
		Cliente cliente;
		try {
			if (dni == null) {
				cliente = (Cliente) session.getAttribute("persona");
			} else {
				cliente = clienteService.buscarPorDni(dni);
			}

			mv.addObject("Cliente", cliente);
			mv.setViewName("detalleCliente");
		} catch (Exception e) {
			session.setAttribute("error", e.getMessage());
			mv.setViewName("detalleCliente");
		}
		return mv;
	}

	@RequestMapping("modificarCliente")
	public ModelAndView modificarCliente(HttpServletRequest request, Integer dni) throws Exception {
		HttpSession session = request.getSession();
		try {
			if (request.getParameter("txtDni") != null) {
				Cliente cli = clienteService.buscarPorDni(dni);
				try {
					if (Integer.parseInt(request.getParameter("txtDni").toString()) == dni) {
						throw new Exception("");
					} else {
						usuarioService.buscarPorUsuario(request.getParameter("txtDni").toString());
						session.setAttribute("error",
								"Ya existe un usuario con el mismo documento. No se pudo modificar al cliente "
										+ cli.getNombre() + " " + cli.getApellido() + ".");
						mv = new ModelAndView("redirect:listarClientes.html");
					}
				} catch (Exception e) {
					cli.setApellido(request.getParameter("txtApellido").substring(0, 1).toUpperCase()
							+ request.getParameter("txtApellido").substring(1));
					cli.setNombre(request.getParameter("txtNombre").substring(0, 1).toUpperCase()
							+ request.getParameter("txtNombre").substring(1));
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
					session.setAttribute("success", "Se modificó al cliente " + cli.getNombre() + " "
							+ cli.getApellido() + " de manera correcta.");
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
		HttpSession session = request.getSession();
		try {
			Cliente cli = clienteService.buscarPorDni(dni);
			Usuario usu = cli.getUsuario();
			usuarioService.eliminarUsuario(usu);
			clienteService.eliminar(cli);
			List<Cuenta> cuentas = cuentaService.buscarCantidadCuentas(cli.getId());
			for (Cuenta cuenta : cuentas) {
				cuentaService.eliminar(cuenta);
			}
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
		try {
			mv.addObject("Clientes", clienteService.listar());
			mv.setViewName("cliente");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mv;
	}
}