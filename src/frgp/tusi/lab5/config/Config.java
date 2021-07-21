package frgp.tusi.lab5.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.daoImpl.ClienteDaoImpl;
import frgp.tusi.lab5.daoImpl.EmpleadoDaoImpl;
import frgp.tusi.lab5.daoImpl.UsuarioDaoImpl;
import frgp.tusi.lab5.model.Cliente;
import frgp.tusi.lab5.model.Cuenta;
import frgp.tusi.lab5.model.Domicilio;
import frgp.tusi.lab5.model.Empleado;
import frgp.tusi.lab5.model.Movimiento;
import frgp.tusi.lab5.model.Nacionalidad;
import frgp.tusi.lab5.model.Persona;
import frgp.tusi.lab5.model.Provincia;
import frgp.tusi.lab5.model.TipoCuenta;
import frgp.tusi.lab5.model.TipoMovimiento;
import frgp.tusi.lab5.model.Transferencia;
import frgp.tusi.lab5.model.Usuario;
import frgp.tusi.lab5.serviceImpl.ClienteServiceImpl;
import frgp.tusi.lab5.serviceImpl.EmpleadoServiceImpl;
import frgp.tusi.lab5.serviceImpl.UsuarioServiceImpl;

@Configuration
public class Config {

	//Models
	@Bean
	public Cliente ClienteBean() {
		Cliente cliente = new Cliente();
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		cliente.setCuentas(cuentas);
		return cliente;
	}
	
	@Bean
	public Cuenta CuentaBean() {
		Cuenta cuenta = new Cuenta();
		TipoCuenta tipoCuenta = this.TipoCuentaBean();
		cuenta.setTipoCuenta(tipoCuenta);
		List<Movimiento> movimientos = new ArrayList<Movimiento>();
		cuenta.setMovimientos(movimientos);
		return cuenta; 
	}
	
	@Bean
	public TipoCuenta TipoCuentaBean() {
		return new TipoCuenta(); 
	}
	
	@Bean
	public Domicilio DomicilioBean() {
		return new Domicilio(); 
	}
	
	@Bean
	public Empleado EmpleadoBean() {
		return new Empleado(); 
	}
	
	@Bean
	public Movimiento MovimientoBean() {
		Movimiento movimiento = new Movimiento();
		movimiento.setTipoMovimiento(this.TipoMovimientoBean());
		movimiento.setCuenta(this.CuentaBean());
		return movimiento; 
	}
	
	@Bean
	public Nacionalidad NacionalidadBean() {
		return new Nacionalidad(); 
	}
	
	@Bean
	public Persona PersonaBean() {
		Persona persona = new Persona();
		persona.setDomicilio(this.DomicilioBean());
		persona.setNacionalidad(this.NacionalidadBean());
		persona.setProvincia(this.ProvinciaBean());
		persona.setUsuario(this.UsuarioBean());
		return persona;
	}
	
	@Bean
	public Provincia ProvinciaBean() {
		return new Provincia(); 
	}
	
	@Bean
	public Usuario UsuarioBean() {
		return new Usuario(); 
	}	
	
	@Bean
	public TipoMovimiento TipoMovimientoBean() {
		return new TipoMovimiento(); 
	}
	
	@Bean
	public Transferencia TransferenciaBean() {
		Transferencia transferencia = new Transferencia();
		transferencia.setCuentaOrigen(this.CuentaBean());
		transferencia.setCuentaDestino(this.CuentaBean());
		transferencia.setMovimientoOrigen(this.MovimientoBean());
		transferencia.setMovimientoDestino(this.MovimientoBean());
		return transferencia;
	}
	
	//Dao
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
	
	//Config
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public ModelAndView ModelAndViewBean() {
		ModelAndView ModelAndViewBean = new ModelAndView();
		return ModelAndViewBean;
	}
	
	//Services
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

}
