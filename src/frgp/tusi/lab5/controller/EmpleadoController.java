package frgp.tusi.lab5.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.model.Empleado;
import frgp.tusi.lab5.serviceImpl.EmpleadoServiceImpl;

@Controller
public class EmpleadoController {

	@Autowired
	@Qualifier("EmpleadoServiceImplBean")
	private EmpleadoServiceImpl empleadoServiceImpl;
	
	@Autowired
	@Qualifier("ModelAndViewBean")
	private ModelAndView mv;

	@Autowired
	@Qualifier("EmpleadoBean")
	private Empleado empleado;
	

	@RequestMapping(value ="/altaEmpleado.html" , method= { RequestMethod.POST})
	public ModelAndView altaEmpleado() {		
		try {
			SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
	        Calendar calendar = Calendar.getInstance();
	        Date dateObj = calendar.getTime();
	        String formattedDate = dtf.format(dateObj);	        
			
	        empleado.setLegajo(4);
	        empleado.setApellido("Oscar");
	        empleado.setNombre("Ditolbi");
	        empleado.setDni(12546514);
	        empleado.setEstado(true);
	        empleado.setFechaNacimiento(formattedDate);
	        empleado.setSexo("M");
			empleadoServiceImpl.crear(empleado);
			
		} catch (Exception e) {
			mv.addObject("Usuario o contraseña invalida.");
			mv.setViewName("login");
		}
		return mv;
	}
	
	@RequestMapping(value ="/modificacionEmpleado.html" , method= { RequestMethod.POST})
	public ModelAndView modificacionEmpleado() {
		return mv;
	}
	
	@RequestMapping(value ="/eliminacionEmpleado.html" , method= { RequestMethod.POST})
	public ModelAndView eliminacionEmpleado() {
		return mv;
	}
	
	@RequestMapping(value ="/listarEmpleados.html" , method= { RequestMethod.POST})
	public ModelAndView listarEmpleados() {
		return mv;
	}
}