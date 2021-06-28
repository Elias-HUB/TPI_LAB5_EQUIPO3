package frgp.tusi.lab5.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.model.Empleado;
import frgp.tusi.lab5.serviceImpl.EmpleadoServiceImpl;

@Controller
public class EmpleadoController {

	private EmpleadoServiceImpl empleadoServiceImpl;

//	@RequestMapping("altaEmpleado")
	@RequestMapping(value ="/altaEmpleado.html" , method= { RequestMethod.POST})
	public ModelAndView altaEmpleado() {
		ModelAndView mv = new ModelAndView();
		
		try {
			SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
	        Calendar calendar = Calendar.getInstance();
	        Date dateObj = calendar.getTime();
	        String formattedDate = dtf.format(dateObj);
	        
			Empleado em = new Empleado();
			em.setLegajo(4);
	    	em.setApellido("Oscar");
	    	em.setNombre("Ditolbi");
	    	em.setDni(12546514);
//	    	em.setDomicilio("Fagnano 2784");
	    	em.setEstado(true);
	    	em.setFechaNacimiento(formattedDate);
	    	em.setNacionalidad("Argentina");
	    	em.setSexo("M");
			empleadoServiceImpl.crear(em);
			
//				if (usuario.getTipoUsuario() == "cliente") {
//					mv.setViewName("cliente");
//					session.setAttribute("user", usuario.getTipoUsuario());
//				}
//				else {
//					mv.setViewName("resumen");
//					session.setAttribute("user", usuario.getTipoUsuario());
//				}
		} catch (Exception e) {
			mv.addObject("Usuario o contraseña invalida.");
			mv.setViewName("login");
		}
		return mv;
	}
	
//	@RequestMapping("modificacionEmpleado")
	@RequestMapping(value ="/modificacionEmpleado.html" , method= { RequestMethod.POST})
	public ModelAndView modificacionEmpleado() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
//	@RequestMapping("eliminacionEmpleado")
	@RequestMapping(value ="/eliminacionEmpleado.html" , method= { RequestMethod.POST})
	public ModelAndView eliminacionEmpleado() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
//	@RequestMapping("listarEmpleados")
	@RequestMapping(value ="/listarEmpleados.html" , method= { RequestMethod.POST})
	public ModelAndView listarEmpleados() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
}
