package frgp.tusi.lab5.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.daoImpl.ClienteDaoImpl;
import frgp.tusi.lab5.daoImpl.EmpleadoDaoImpl;
import frgp.tusi.lab5.daoImpl.UsuarioDaoImpl;
import frgp.tusi.lab5.serviceImpl.ClienteServiceImpl;
import frgp.tusi.lab5.serviceImpl.EmpleadoServiceImpl;
import frgp.tusi.lab5.serviceImpl.UsuarioServiceImpl;

@Configuration
public class Config {

	@Bean
	public ClienteServiceImpl ClienteServiceImplBean() {
		ClienteServiceImpl ClienteServiceImplBean = new ClienteServiceImpl();
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
	
	@Bean
	public ClienteDaoImpl ClienteDaoImplBean() {
		ClienteDaoImpl clienteDaoImplBean = new ClienteDaoImpl();
		return clienteDaoImplBean;
	}
	
	@Bean
	public UsuarioDaoImpl UsuarioDaoImplBean() {
		UsuarioDaoImpl usuarioDaoImplBean = new UsuarioDaoImpl();
		return usuarioDaoImplBean;
	}
	
	@Bean
	public EmpleadoDaoImpl EmpleadoDaoImplBean() {
		EmpleadoDaoImpl empleadoDaoImplBean = new EmpleadoDaoImpl();
		return empleadoDaoImplBean;
	}

}
