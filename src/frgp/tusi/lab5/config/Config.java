package frgp.tusi.lab5.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.daoImpl.ClienteDaoImpl;
import frgp.tusi.lab5.daoImpl.CuentaDaoImpl;
import frgp.tusi.lab5.daoImpl.EmpleadoDaoImpl;
import frgp.tusi.lab5.daoImpl.MovimientoDaoImpl;
import frgp.tusi.lab5.daoImpl.NacionalidadDaoImpl;
import frgp.tusi.lab5.daoImpl.ProvinciaDaoImpl;
import frgp.tusi.lab5.daoImpl.TipoCuentaDaoImpl;
import frgp.tusi.lab5.daoImpl.TipoMovimientoDaoImpl;
import frgp.tusi.lab5.daoImpl.TransferenciaDaoImpl;
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
import frgp.tusi.lab5.serviceImpl.CuentaServiceImpl;
import frgp.tusi.lab5.serviceImpl.EmpleadoServiceImpl;
import frgp.tusi.lab5.serviceImpl.MovimientoServiceImpl;
import frgp.tusi.lab5.serviceImpl.NacionalidadServicesImpl;
import frgp.tusi.lab5.serviceImpl.ProvinciaServicesImpl;
import frgp.tusi.lab5.serviceImpl.TipoCuentaServiceImpl;
import frgp.tusi.lab5.serviceImpl.TipoMovimientoServiceImpl;
import frgp.tusi.lab5.serviceImpl.TransferenciaServiceImpl;
import frgp.tusi.lab5.serviceImpl.UsuarioServiceImpl;

@Configuration
public class Config {

	//Models
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Cliente ClienteBean() {
		Cliente cliente = new Cliente();
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		cliente.setCuentas(cuentas);
		return cliente;
	}
	
	@Bean
//	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Cuenta CuentaBean() {
		Cuenta cuenta = new Cuenta();
		cuenta.setTipoCuenta(this.TipoCuentaBean());
		List<Movimiento> movimientos = new ArrayList<Movimiento>();
		cuenta.setMovimientos(movimientos);
		return cuenta; 
	}
		
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Domicilio DomicilioBean() {
		return new Domicilio(); 
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Empleado EmpleadoBean() {
		return new Empleado(); 
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Movimiento MovimientoBean() {
		Movimiento movimiento = new Movimiento();
		movimiento.setTipoMovimiento(this.TipoMovimientoBean());
		movimiento.setCuenta(this.CuentaBean());
		return movimiento; 
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Nacionalidad NacionalidadBean() {
		return new Nacionalidad(); 
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Persona PersonaBean() {
		Persona persona = new Persona();
		persona.setDomicilio(this.DomicilioBean());
		persona.setNacionalidad(this.NacionalidadBean());
		persona.setProvincia(this.ProvinciaBean());
		persona.setUsuario(this.UsuarioBean());
		return persona;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Provincia ProvinciaBean() {
		return new Provincia(); 
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public TipoCuenta TipoCuentaBean() {
		return new TipoCuenta(); 
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public TipoMovimiento TipoMovimientoBean() {
		return new TipoMovimiento(); 
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Transferencia TransferenciaBean() {
		Transferencia transferencia = new Transferencia();
		transferencia.setCuentaOrigen(this.CuentaBean());
		transferencia.setCuentaDestino(this.CuentaBean());
		transferencia.setMovimientoOrigen(this.MovimientoBean());
		transferencia.setMovimientoDestino(this.MovimientoBean());
		return transferencia;
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Usuario UsuarioBean() {
		return new Usuario(); 
	}	
	
	//Dao
	@Bean
	public ClienteDaoImpl ClienteDaoImplBean() {
		ClienteDaoImpl clienteDaoImplBean = new ClienteDaoImpl();
		return clienteDaoImplBean;
	}
	
	@Bean
	public CuentaDaoImpl CuentaDaoImplBean() {
		CuentaDaoImpl cuentaDaoImplBean = new CuentaDaoImpl();
		return cuentaDaoImplBean;
	}
	
	@Bean
	public EmpleadoDaoImpl EmpleadoDaoImplBean() {
		EmpleadoDaoImpl empleadoDaoImplBean = new EmpleadoDaoImpl();
		return empleadoDaoImplBean;
	}
	
	@Bean
	public MovimientoDaoImpl MovimientoDaoImplBean() { 
		return new MovimientoDaoImpl();
	}
	
	@Bean
	public NacionalidadDaoImpl NacionalidadDaoImplBean() {
		return new NacionalidadDaoImpl();
	}
	
	@Bean
	public ProvinciaDaoImpl ProvinciaDaoImplBean() {
		return new ProvinciaDaoImpl();
	}
	
	@Bean
	public TipoCuentaDaoImpl TipoCuentaDaoImplBean() {
		return new TipoCuentaDaoImpl();
	}
	
	@Bean
	public TipoMovimientoDaoImpl TipoMovimientoDaoImplBean() {
		return new TipoMovimientoDaoImpl();
	}
	
	@Bean
	public TransferenciaDaoImpl TransferenciaDaoImplBean() {
		return new TransferenciaDaoImpl();
	}
	
	@Bean
	public UsuarioDaoImpl UsuarioDaoImplBean() {
		UsuarioDaoImpl usuarioDaoImplBean = new UsuarioDaoImpl();
		return usuarioDaoImplBean;
	}
	
	//Config
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public ModelAndView ModelAndViewBean() {
		ModelAndView ModelAndViewBean = new ModelAndView();
		return ModelAndViewBean;
	}
	
//	@Bean
//	public HibernateConfiguration HibernateConfigurationBean() {
//		return new HibernateConfiguration();
//	}
	
	//Services
	@Bean
	public ClienteServiceImpl ClienteServiceImplBean() {
		ClienteServiceImpl ClienteServiceImplBean = new ClienteServiceImpl();
		return ClienteServiceImplBean;
	}
	
	@Bean
	public CuentaServiceImpl CuentaServiceImplBean() {
		return new CuentaServiceImpl();
	}
	
	@Bean
	public EmpleadoServiceImpl EmpleadoServiceImplBean() {
		EmpleadoServiceImpl EmpleadoServiceImplBean = new EmpleadoServiceImpl();
		return EmpleadoServiceImplBean;
	}	
	
	@Bean
	public MovimientoServiceImpl MovimientoServiceImplBean() {
		return new MovimientoServiceImpl();
	}
	
	@Bean
	public NacionalidadServicesImpl NacionalidadServicesImplBean() {
		return new NacionalidadServicesImpl();
	}
	
	@Bean
	public ProvinciaServicesImpl ProvinciaServicesImplBean() {
		return new ProvinciaServicesImpl();
	}
	
	@Bean
	public TipoCuentaServiceImpl TipoCuentaServiceImplBean() {
		return new TipoCuentaServiceImpl();
	}
	
	@Bean
	public TipoMovimientoServiceImpl TipoMovimientoServiceImplBean() {
		return new TipoMovimientoServiceImpl();
	}
	
	@Bean
	public TransferenciaServiceImpl TransferenciaServiceImplBean() {
		return new TransferenciaServiceImpl();
	}
	
	@Bean
	public UsuarioServiceImpl UsuarioServiceImplBean() {
		UsuarioServiceImpl UsuarioServiceImplBean = new UsuarioServiceImpl();
		return UsuarioServiceImplBean;
	}
}
