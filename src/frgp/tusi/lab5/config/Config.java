package frgp.tusi.lab5.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.serviceImpl.ClienteServiceImpl;
import frgp.tusi.lab5.serviceImpl.EmpleadoServiceImpl;
import frgp.tusi.lab5.serviceImpl.UsuarioServiceImpl;

@Configuration
public class Config {

	@Bean
	public ClienteServiceImpl ClienteServiceImplBean() {
		ClienteServiceImpl ClienteServiceImplBean = new ClienteServiceImpl(); //Inyeccion de dependencia por Set
		return ClienteServiceImplBean;
	}
	
	@Bean
	public UsuarioServiceImpl UsuarioServiceImplBean() {
		UsuarioServiceImpl UsuarioServiceImplBean = new UsuarioServiceImpl();
		return UsuarioServiceImplBean;
	}
	
	@Bean
	public EmpleadoServiceImpl EmpleadoServiceImplBean() {
		EmpleadoServiceImpl EmpleadoServiceImplBean = new EmpleadoServiceImpl();
		return EmpleadoServiceImplBean;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public ModelAndView ModelAndViewBean() {
		ModelAndView ModelAndViewBean = new ModelAndView();
		return ModelAndViewBean;
	}
	
	
	

}
