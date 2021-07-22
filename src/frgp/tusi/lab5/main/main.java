package frgp.tusi.lab5.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import frgp.tusi.lab5.model.Cliente;
import frgp.tusi.lab5.model.Cuenta;
import frgp.tusi.lab5.model.Domicilio;
import frgp.tusi.lab5.model.Empleado;
import frgp.tusi.lab5.model.Movimiento;
import frgp.tusi.lab5.model.Nacionalidad;
import frgp.tusi.lab5.model.Provincia;
import frgp.tusi.lab5.model.TipoCuenta;
import frgp.tusi.lab5.model.TipoMovimiento;
import frgp.tusi.lab5.model.Transferencia;
import frgp.tusi.lab5.model.Usuario;

public class main {

	public static void main(String[] args) {

		SessionFactory sessionFactory;
    	
    	Configuration configuration = new Configuration();
    	configuration.configure();	
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	Session session = sessionFactory.openSession();

    	
    	session.beginTransaction();
    	
    	SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);
        
    	TipoMovimiento tipoTransferenciaDeb = new TipoMovimiento();
    	TipoMovimiento tipoTransferenciaCred = new TipoMovimiento();
    	TipoMovimiento tipoAltaCuenta = new TipoMovimiento();
    	
    	tipoTransferenciaDeb.setDescripcion("Transferencia Débito");
    	tipoTransferenciaCred.setDescripcion("Transferencia Crédito");
    	tipoAltaCuenta.setDescripcion("Alta de Cuenta");
    	session.save(tipoAltaCuenta);
    	session.save(tipoTransferenciaDeb);
    	session.save(tipoTransferenciaCred);
    	
    	TipoCuenta tipoCuentaCA = new TipoCuenta();
    	tipoCuentaCA.setDescripcion("Caja de ahorro en pesos");
    	session.save(tipoCuentaCA);
    	TipoCuenta tipoCuentaCD = new TipoCuenta();
    	tipoCuentaCD.setDescripcion("Caja de ahorro en dólares");
    	session.save(tipoCuentaCD);   	
    	
    	
    	Nacionalidad nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Bolivia");
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Brasil");
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Chile");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Colombia");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Costa Rica");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Cuba");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Ecuador");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("El Salvador");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Guayana Francesa");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Granada");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Guatemala");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Guayana");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Haití");
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Honduras");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Jamaica");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("México");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Nicaragua");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Paraguay");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Panamá");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Perú");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Puerto Rico");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("República Dominicana");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Surinam");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Uruguay");    	
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Venezuela");
    	session.save(nacionalidad);
    	
    	nacionalidad = new Nacionalidad();
    	nacionalidad.setNombre("Argentina");
    	session.save(nacionalidad);
    	
    	Provincia provincia = new Provincia();
    	provincia.setNombre("Capital Federal");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Catamarca");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Chaco");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Chubut");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Córdoba");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Corrientes");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Entre Ríos");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Formosa");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Jujuy");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("La Pampa");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("La Rioja");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Mendoza");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Misiones");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Neuquén");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Río Negro");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Salta");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("San Juan");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("San Luis");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Santa Cruz");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Santa Fe");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Santiago del Estero");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Tierra del Fuego");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Tucumán");
    	session.save(provincia);
    	
    	provincia = new Provincia();
    	provincia.setNombre("Buenos Aires");
    	session.save(provincia);

////////////////////////////////////////////////////////////////////////	1
    	
    	List<Cuenta> cuentasCliente = new ArrayList<Cuenta>();
    	List<Movimiento> movimientosCuentaOrigen = new ArrayList<Movimiento>();
    	List<Movimiento> movimientosCuentaDestino = new ArrayList<Movimiento>();
    	
    	Movimiento movAltaCuenta = new Movimiento();
    	movAltaCuenta.setDetalle("Alta de Cuenta");
    	movAltaCuenta.setEstado(true);
    	movAltaCuenta.setFecha(new Date());
    	movAltaCuenta.setFechaUltimaModificacion(new Date());
    	movAltaCuenta.setTipoMovimiento(tipoTransferenciaDeb);
    	movAltaCuenta.setImporte(10000);
    	movimientosCuentaOrigen.add(movAltaCuenta);
    	
    	Movimiento movOrigen = new Movimiento();
    	movOrigen.setDetalle("Transferencia débito");
    	movOrigen.setEstado(true);
    	movOrigen.setFecha(new Date());
    	movOrigen.setFechaUltimaModificacion(new Date());
    	movOrigen.setTipoMovimiento(tipoTransferenciaDeb);
    	movOrigen.setImporte(-5000);
    	movimientosCuentaOrigen.add(movOrigen);

    	Movimiento movDestino = new Movimiento();
    	movDestino.setDetalle("Transferencia crédito");
    	movDestino.setEstado(true);
    	movDestino.setFecha(new Date());
    	movDestino.setFechaUltimaModificacion(new Date());
    	movDestino.setTipoMovimiento(tipoTransferenciaCred);
    	movDestino.setImporte(5000);
    	movimientosCuentaDestino.add(movDestino);
    	
    	Cuenta cuentaOrigen = new Cuenta();
    	cuentaOrigen.setCbu(54754562);
    	cuentaOrigen.setNroCuenta(1432);
    	cuentaOrigen.setNombre("Cuenta CA");
    	cuentaOrigen.setSaldo(10000);
    	cuentaOrigen.setEstado(true);
    	cuentaOrigen.setTipoCuenta(tipoCuentaCA);
    	cuentaOrigen.setFechaAlta(formattedDate);
    	cuentaOrigen.setFechaUltimaModificacion(formattedDate);    	
    	cuentaOrigen.setMovimientos(movimientosCuentaOrigen);
    	cuentasCliente.add(cuentaOrigen);
    	
    	Cuenta cuentaDestino = new Cuenta();
    	cuentaDestino.setCbu(23452346);
    	cuentaDestino.setNroCuenta(5346);
    	cuentaDestino.setNombre("Cuenta CA");
    	cuentaDestino.setSaldo(10000);
    	cuentaDestino.setEstado(true);
    	cuentaDestino.setTipoCuenta(tipoCuentaCA);
    	cuentaDestino.setFechaAlta(formattedDate);
    	cuentaDestino.setFechaUltimaModificacion(formattedDate);
    	cuentaDestino.setMovimientos(movimientosCuentaDestino);
    	cuentasCliente.add(cuentaDestino);    	
    	

    	Usuario usuario = new Usuario();
    	usuario.setEstado(true);
    	usuario.setFechaAlta(new Date());
    	usuario.setFechaUltimaModificacion(new Date());
    	usuario.setTipoUsuario("cliente");
    	usuario.setPass("1234");
    	usuario.setUserName("21412359");
    	
    	Domicilio domicilio = new Domicilio();
    	domicilio.setDireccion("AV Cordoba");
    	domicilio.setLocalidad("Talar");
    	
    	Cliente cli = new Cliente();
    	cli.setApellido("Arias");
    	cli.setNombre("Franco");
    	cli.setDni(21412359);
    	cli.setSexo("M");
    	cli.setEstado(true);
    	cli.setNacionalidad(nacionalidad);
    	cli.setProvincia(provincia);
    	cli.setFechaNacimiento("1980-02-14");
    	cli.setDomicilio(domicilio);  
    	cli.setUsuario(usuario);
    	cli.setCuentas(cuentasCliente);
    	session.save(cli);
    	
    	Transferencia trans = new Transferencia();
    	trans.setMovimientoOrigen(movOrigen);
    	trans.setMovimientoDestino(movDestino);
    	trans.setCuentaOrigen(cuentaOrigen);
    	trans.setCuentaDestino(cuentaDestino);
    	session.save(trans);
    	
////////////////////////////////////////////////////////////////////////	2
    	
		List<Cuenta> cuentasClienteDos = new ArrayList<Cuenta>();
    	List<Movimiento> movimientosCuentaOrigenDos = new ArrayList<Movimiento>();
    	List<Movimiento> movimientosCuentaDestinoDos = new ArrayList<Movimiento>();

    	Movimiento movAltaCuentaDos = new Movimiento();
    	movAltaCuentaDos.setDetalle("Alta de Cuenta");
    	movAltaCuentaDos.setEstado(true);
    	movAltaCuentaDos.setFecha(new Date());
    	movAltaCuentaDos.setFechaUltimaModificacion(new Date());
    	movAltaCuentaDos.setTipoMovimiento(tipoTransferenciaDeb);
    	movAltaCuentaDos.setImporte(10000);
    	movimientosCuentaOrigenDos.add(movAltaCuenta);
    	
		Movimiento movOrigenDos = new Movimiento();
    	movOrigenDos.setDetalle("Transferencia débito");
    	movOrigenDos.setEstado(true);
    	movOrigenDos.setFecha(new Date());
    	movOrigenDos.setFechaUltimaModificacion(new Date());
    	movOrigenDos.setTipoMovimiento(tipoTransferenciaDeb);
    	movOrigenDos.setImporte(-3000);
    	movimientosCuentaOrigenDos.add(movOrigenDos);

    	Movimiento movDestinoDos = new Movimiento();
    	movDestinoDos.setDetalle("Transferencia crédito");
    	movDestinoDos.setEstado(true);
    	movDestinoDos.setFecha(new Date());
    	movDestinoDos.setFechaUltimaModificacion(new Date());
    	movDestinoDos.setTipoMovimiento(tipoTransferenciaCred);
    	movDestinoDos.setImporte(3000);
    	movimientosCuentaDestinoDos.add(movDestinoDos);
    	
    	Cuenta cuentaOrigenDos = new Cuenta();
    	cuentaOrigenDos.setCbu(72812462);
    	cuentaOrigenDos.setNroCuenta(6781);
    	cuentaOrigenDos.setNombre("Cuenta CA");
    	cuentaOrigenDos.setSaldo(10000);
    	cuentaOrigenDos.setEstado(true);
    	cuentaOrigenDos.setTipoCuenta(tipoCuentaCA);
    	cuentaOrigenDos.setFechaAlta(formattedDate);
    	cuentaOrigenDos.setFechaUltimaModificacion(formattedDate);    	
    	cuentaOrigenDos.setMovimientos(movimientosCuentaOrigenDos);
    	cuentasClienteDos.add(cuentaOrigenDos);    	
    	
    	Cuenta cuentaDestinoDos = new Cuenta();
    	cuentaDestinoDos.setCbu(12737271);
    	cuentaDestinoDos.setNroCuenta(3627);
    	cuentaDestinoDos.setNombre("Cuenta CA");
    	cuentaDestinoDos.setSaldo(10000);
    	cuentaDestinoDos.setEstado(true);
    	cuentaDestinoDos.setTipoCuenta(tipoCuentaCA);
    	cuentaDestinoDos.setFechaAlta(formattedDate);
    	cuentaDestinoDos.setFechaUltimaModificacion(formattedDate);
    	cuentaDestinoDos.setMovimientos(movimientosCuentaDestinoDos);
    	cuentasClienteDos.add(cuentaDestinoDos);    	
    	
    	Transferencia transDos = new Transferencia();
    	transDos.setMovimientoOrigen(movOrigenDos);
    	transDos.setMovimientoDestino(movDestinoDos);
    	transDos.setCuentaOrigen(cuentaOrigenDos);
    	transDos.setCuentaDestino(cuentaDestinoDos);
    	session.save(transDos);
    	
    	Usuario usuarioDos = new Usuario();
    	usuarioDos.setEstado(true);
    	usuarioDos.setFechaAlta(new Date());
    	usuarioDos.setFechaUltimaModificacion(new Date());
    	usuarioDos.setTipoUsuario("cliente");
    	usuarioDos.setPass("1234");
    	usuarioDos.setUserName("23546373");
    	
    	Domicilio domicilioDos = new Domicilio();
    	domicilioDos.setDireccion("Buenos Aires");
    	domicilioDos.setLocalidad("Tigre");
    	
    	Cliente cliDos = new Cliente();
    	cliDos.setApellido("Rata");
    	cliDos.setNombre("Pedro");
    	cliDos.setDni(23546373);
    	cliDos.setSexo("M");
    	cliDos.setNacionalidad(nacionalidad);
    	cliDos.setProvincia(provincia);
    	cliDos.setFechaNacimiento("1980-02-14");
		cliDos.setEstado(true);
    	cliDos.setDomicilio(domicilioDos);  
    	cliDos.setUsuario(usuarioDos);
    	cliDos.setCuentas(cuentasClienteDos);
    	session.save(cliDos);
   	
//////////////////////////////////////////////////////////////////////////	3
    	
		List<Cuenta> cuentasClienteTres = new ArrayList<Cuenta>();
    	List<Movimiento> movimientosCuentaOrigenTres = new ArrayList<Movimiento>();
    	List<Movimiento> movimientosCuentaDestinoTres = new ArrayList<Movimiento>();
	
    	Movimiento movAltaCuentaTres = new Movimiento();
    	movAltaCuentaTres.setDetalle("Alta de Cuenta");
    	movAltaCuentaTres.setEstado(true);
    	movAltaCuentaTres.setFecha(new Date());
    	movAltaCuentaTres.setFechaUltimaModificacion(new Date());
    	movAltaCuentaTres.setTipoMovimiento(tipoTransferenciaDeb);
    	movAltaCuentaTres.setImporte(10000);
    	movimientosCuentaOrigenTres.add(movAltaCuentaTres);
    	
    	Movimiento movOrigenTres = new Movimiento();
    	movOrigenTres.setDetalle("Transferencia débito");
    	movOrigenTres.setEstado(true);
    	movOrigenTres.setFecha(new Date());
    	movOrigenTres.setFechaUltimaModificacion(new Date());
    	movOrigenTres.setTipoMovimiento(tipoTransferenciaDeb);
    	movOrigenTres.setImporte(-2000);
    	movimientosCuentaOrigenTres.add(movOrigenTres);

    	Movimiento movDestinoTres = new Movimiento();
    	movDestinoTres.setDetalle("Transferencia crédito");
    	movDestinoTres.setEstado(true);
    	movDestinoTres.setFecha(new Date());
    	movDestinoTres.setFechaUltimaModificacion(new Date());
    	movDestinoTres.setTipoMovimiento(tipoTransferenciaCred);
    	movDestinoTres.setImporte(2000);
    	movimientosCuentaDestinoTres.add(movDestinoTres);
    	
    	Cuenta cuentaOrigenTres = new Cuenta();
    	cuentaOrigenTres.setCbu(23546735);
    	cuentaOrigenTres.setNroCuenta(4427);
    	cuentaOrigenTres.setNombre("Cuenta CD");
    	cuentaOrigenTres.setSaldo(10000);
    	cuentaOrigenTres.setEstado(true);
    	cuentaOrigenTres.setTipoCuenta(tipoCuentaCD);
    	cuentaOrigenTres.setFechaAlta(formattedDate);
    	cuentaOrigenTres.setFechaUltimaModificacion(formattedDate);    	
    	cuentaOrigenTres.setMovimientos(movimientosCuentaOrigenTres);
    	cuentasClienteTres.add(cuentaOrigenTres);    	
    	
    	Cuenta cuentaDestinoTres = new Cuenta();
    	cuentaDestinoTres.setCbu(32785467);
    	cuentaDestinoTres.setNroCuenta(4792);
    	cuentaDestinoTres.setNombre("Cuenta CD");
    	cuentaDestinoTres.setSaldo(10000);
    	cuentaDestinoTres.setEstado(true);
    	cuentaDestinoTres.setTipoCuenta(tipoCuentaCD);
    	cuentaDestinoTres.setFechaAlta(formattedDate);
    	cuentaDestinoTres.setFechaUltimaModificacion(formattedDate);
    	cuentaDestinoTres.setMovimientos(movimientosCuentaDestinoTres);
    	cuentasClienteTres.add(cuentaDestinoTres);    	
    	
    	Transferencia transTres = new Transferencia();
    	transTres.setMovimientoOrigen(movOrigenTres);
    	transTres.setMovimientoDestino(movDestinoTres);
    	transTres.setCuentaOrigen(cuentaOrigenTres);
    	transTres.setCuentaDestino(cuentaDestinoTres);
    	session.save(transTres);
    	
    	Usuario usuarioTres = new Usuario();
    	usuarioTres.setEstado(true);
    	usuarioTres.setFechaAlta(new Date());
    	usuarioTres.setFechaUltimaModificacion(new Date());
    	usuarioTres.setTipoUsuario("cliente");
    	usuarioTres.setPass("1234");
    	usuarioTres.setUserName("25863173");
    	
    	Domicilio domicilioTres = new Domicilio();
    	domicilioTres.setDireccion("Francia");
    	domicilioTres.setLocalidad("Tigre");
    	
    	Cliente cliTres = new Cliente();
    	cliTres.setApellido("Lopez");
    	cliTres.setNombre("Juana");
    	cliTres.setDni(25863173);
    	cliTres.setSexo("F");
    	cliTres.setNacionalidad(nacionalidad);
    	cliTres.setProvincia(provincia);
    	cliTres.setFechaNacimiento("1985-02-15");
		cliTres.setEstado(false);
    	cliTres.setDomicilio(domicilioTres);  
    	cliTres.setUsuario(usuarioTres);
    	cliTres.setCuentas(cuentasClienteTres);
    	session.save(cliTres);
    	
//////////////////////////////////////////////////////////////////////////////	4
    	
		List<Cuenta> cuentasClienteCuatro = new ArrayList<Cuenta>();
    	List<Movimiento> movimientosCuentaOrigenCuatro = new ArrayList<Movimiento>();
    	List<Movimiento> movimientosCuentaDestinoCuatro = new ArrayList<Movimiento>();
		
    	Movimiento movAltaCuentaCuatro = new Movimiento();
    	movAltaCuentaCuatro.setDetalle("Alta de Cuenta");
    	movAltaCuentaCuatro.setEstado(true);
    	movAltaCuentaCuatro.setFecha(new Date());
    	movAltaCuentaCuatro.setFechaUltimaModificacion(new Date());
    	movAltaCuentaCuatro.setTipoMovimiento(tipoTransferenciaDeb);
    	movAltaCuentaCuatro.setImporte(10000);
    	movimientosCuentaOrigenCuatro.add(movAltaCuentaCuatro);
    	
    	Movimiento movOrigenCuatro = new Movimiento();
    	movOrigenCuatro.setDetalle("Transferencia débito");
    	movOrigenCuatro.setEstado(true);
    	movOrigenCuatro.setFecha(new Date());
    	movOrigenCuatro.setFechaUltimaModificacion(new Date());
    	movOrigenCuatro.setTipoMovimiento(tipoTransferenciaDeb);
    	movOrigenCuatro.setImporte(-1000);
    	movimientosCuentaOrigenCuatro.add(movOrigenCuatro);

    	Movimiento movDestinoCuatro = new Movimiento();
    	movDestinoCuatro.setDetalle("Transferencia crédito");
    	movDestinoCuatro.setEstado(true);
    	movDestinoCuatro.setFecha(new Date());
    	movDestinoCuatro.setFechaUltimaModificacion(new Date());
    	movDestinoCuatro.setTipoMovimiento(tipoTransferenciaCred);
    	movDestinoCuatro.setImporte(1000);
    	movimientosCuentaDestinoCuatro.add(movDestinoCuatro);
    	
    	Cuenta cuentaOrigenCuatro = new Cuenta();
    	cuentaOrigenCuatro.setCbu(94828428);
    	cuentaOrigenCuatro.setNroCuenta(1233);
    	cuentaOrigenCuatro.setNombre("Cuenta CA");
    	cuentaOrigenCuatro.setSaldo(10000);
    	cuentaOrigenCuatro.setEstado(true);
    	cuentaOrigenCuatro.setTipoCuenta(tipoCuentaCA);
    	cuentaOrigenCuatro.setFechaAlta(formattedDate);
    	cuentaOrigenCuatro.setFechaUltimaModificacion(formattedDate);    	
    	cuentaOrigenCuatro.setMovimientos(movimientosCuentaOrigenCuatro);
    	cuentasClienteCuatro.add(cuentaOrigenCuatro);    	
    	
    	Cuenta cuentaDestinoCuatro = new Cuenta();
    	cuentaDestinoCuatro.setCbu(23547623);
    	cuentaDestinoCuatro.setNroCuenta(202);
    	cuentaDestinoCuatro.setNombre("Cuenta CA");
    	cuentaDestinoCuatro.setSaldo(10000);
    	cuentaDestinoCuatro.setEstado(true);
    	cuentaDestinoCuatro.setTipoCuenta(tipoCuentaCA);
    	cuentaDestinoCuatro.setFechaAlta(formattedDate);
    	cuentaDestinoCuatro.setFechaUltimaModificacion(formattedDate);
    	cuentaDestinoCuatro.setMovimientos(movimientosCuentaDestinoCuatro);
    	cuentasClienteCuatro.add(cuentaDestinoCuatro);    	
    	
    	Transferencia transCuatro = new Transferencia();
    	transCuatro.setMovimientoOrigen(movOrigenCuatro);
    	transCuatro.setMovimientoDestino(movDestinoCuatro);
    	transCuatro.setCuentaOrigen(cuentaOrigenCuatro);
    	transCuatro.setCuentaDestino(cuentaDestinoCuatro);
    	session.save(transCuatro);
    	
    	Usuario usuarioCuatro = new Usuario();
    	usuarioCuatro.setEstado(true);
    	usuarioCuatro.setFechaAlta(new Date());
    	usuarioCuatro.setFechaUltimaModificacion(new Date());
    	usuarioCuatro.setTipoUsuario("cliente");
    	usuarioCuatro.setPass("1234");
    	usuarioCuatro.setUserName("30452120");
    	
    	Domicilio domicilioCuatro = new Domicilio();
    	domicilioCuatro.setDireccion("9 Julio");
    	domicilioCuatro.setLocalidad("Escobar");
    	
    	Cliente cliCuatro = new Cliente();
    	cliCuatro.setApellido("Corzo");
    	cliCuatro.setNombre("Gonzalo");
    	cliCuatro.setDni(30452120);
    	cliCuatro.setSexo("M");
    	cliCuatro.setNacionalidad(nacionalidad);
    	cliCuatro.setProvincia(provincia);
    	cliCuatro.setFechaNacimiento("1990-02-14");
		cliCuatro.setEstado(true);
    	cliCuatro.setDomicilio(domicilioCuatro);
    	cliCuatro.setUsuario(usuarioCuatro);
    	cliCuatro.setCuentas(cuentasClienteCuatro);
    	session.save(cliCuatro);
    	
////////////////////////////////////////////////////////////////////////	5

    	cuentasCliente = new ArrayList<Cuenta>();
    	movimientosCuentaDestino= new ArrayList<Movimiento>();
    	movimientosCuentaOrigen= new ArrayList<Movimiento>();
    	
    	movAltaCuenta = new Movimiento();
    	movAltaCuenta.setDetalle("Alta de Cuenta");
    	movAltaCuenta.setEstado(true);
    	movAltaCuenta.setFecha(new Date());
    	movAltaCuenta.setFechaUltimaModificacion(new Date());
    	movAltaCuenta.setTipoMovimiento(tipoTransferenciaDeb);
    	movAltaCuenta.setImporte(10000);
    	movimientosCuentaOrigen.add(movAltaCuenta);
    	
    	movOrigen = new Movimiento();
    	movOrigen.setDetalle("Transferencia débito");
    	movOrigen.setEstado(true);
    	movOrigen.setFecha(new Date());
    	movOrigen.setFechaUltimaModificacion(new Date());
    	movOrigen.setTipoMovimiento(tipoTransferenciaDeb);
    	movOrigen.setImporte(-7000);
    	movimientosCuentaOrigen.add(movOrigen);

    	movDestino = new Movimiento();
    	movDestino.setDetalle("Transferencia crédito");
    	movDestino.setEstado(true);
    	movDestino.setFecha(new Date());
    	movDestino.setFechaUltimaModificacion(new Date());
    	movDestino.setTipoMovimiento(tipoTransferenciaCred);
    	movDestino.setImporte(7000);
    	movimientosCuentaDestino.add(movDestino);
    	
    	cuentaOrigen = new Cuenta();
    	cuentaOrigen.setCbu(32164897);
    	cuentaOrigen.setNroCuenta(1652);
    	cuentaOrigen.setNombre("Cuenta CA");
    	cuentaOrigen.setSaldo(10000);
    	cuentaOrigen.setEstado(true);
    	cuentaOrigen.setTipoCuenta(tipoCuentaCA);
    	cuentaOrigen.setFechaAlta(formattedDate);
    	cuentaOrigen.setFechaUltimaModificacion(formattedDate);    	
    	cuentaOrigen.setMovimientos(movimientosCuentaOrigen);
    	cuentasCliente.add(cuentaOrigen);    	
    	
    	cuentaDestino = new Cuenta();
    	cuentaDestino.setCbu(354637);
    	cuentaDestino.setNroCuenta(534756);
    	cuentaDestino.setNombre("Cuenta CA");
    	cuentaDestino.setSaldo(10000);
    	cuentaDestino.setEstado(true);
    	cuentaDestino.setTipoCuenta(tipoCuentaCA);
    	cuentaDestino.setFechaAlta(formattedDate);
    	cuentaDestino.setFechaUltimaModificacion(formattedDate);
    	cuentaDestino.setMovimientos(movimientosCuentaDestino);
    	cuentasCliente.add(cuentaDestino);    	
    	
    	trans = new Transferencia();
    	trans.setMovimientoOrigen(movOrigen);
    	trans.setMovimientoDestino(movDestino);
    	trans.setCuentaOrigen(cuentaOrigen);
    	trans.setCuentaDestino(cuentaDestino);
    	session.save(trans);
    	
    	usuario = new Usuario();
    	usuario.setEstado(true);
    	usuario.setFechaAlta(new Date());
    	usuario.setFechaUltimaModificacion(new Date());
    	usuario.setTipoUsuario("cliente");
    	usuario.setPass("1234");
    	usuario.setUserName("40365129");
    	
    	domicilio = new Domicilio();
    	domicilio.setDireccion("Fagnano");
    	domicilio.setLocalidad("Pacheco");
    	
    	cli = new Cliente();
    	cli.setApellido("Contento");
    	cli.setNombre("Juan");
    	cli.setDni(40365129);
    	cli.setSexo("M");
    	cli.setEstado(true);
    	cli.setNacionalidad(nacionalidad);
    	cli.setProvincia(provincia);
    	cli.setFechaNacimiento("1999-05-22");
    	cli.setDomicilio(domicilio);  
    	cli.setUsuario(usuario);
    	cli.setCuentas(cuentasCliente);
    	session.save(cli);
    	
////////////////////////////////////////////////////////////////////////	6
    	
    	cuentasCliente = new ArrayList<Cuenta>();
    	movimientosCuentaDestino= new ArrayList<Movimiento>();
    	movimientosCuentaOrigen= new ArrayList<Movimiento>();
    	
    	movAltaCuenta = new Movimiento();
    	movAltaCuenta.setDetalle("Alta de Cuenta");
    	movAltaCuenta.setEstado(true);
    	movAltaCuenta.setFecha(new Date());
    	movAltaCuenta.setFechaUltimaModificacion(new Date());
    	movAltaCuenta.setTipoMovimiento(tipoTransferenciaDeb);
    	movAltaCuenta.setImporte(10000);
    	movimientosCuentaOrigen.add(movAltaCuenta);
    	
    	movOrigen = new Movimiento();
    	movOrigen.setDetalle("Transferencia débito");
    	movOrigen.setEstado(true);
    	movOrigen.setFecha(new Date());
    	movOrigen.setFechaUltimaModificacion(new Date());
    	movOrigen.setTipoMovimiento(tipoTransferenciaDeb);
    	movOrigen.setImporte(-3500);
    	movimientosCuentaOrigen.add(movOrigen);

    	movDestino = new Movimiento();
    	movDestino.setDetalle("Transferencia crédito");
    	movDestino.setEstado(true);
    	movDestino.setFecha(new Date());
    	movDestino.setFechaUltimaModificacion(new Date());
    	movDestino.setTipoMovimiento(tipoTransferenciaCred);
    	movDestino.setImporte(3500);
    	movimientosCuentaDestino.add(movDestino);
    	
    	cuentaOrigen = new Cuenta();
    	cuentaOrigen.setCbu(321464897);
    	cuentaOrigen.setNroCuenta(16552);
    	cuentaOrigen.setNombre("Cuenta CA");
    	cuentaOrigen.setSaldo(10000);
    	cuentaOrigen.setEstado(true);
    	cuentaOrigen.setTipoCuenta(tipoCuentaCA);
    	cuentaOrigen.setFechaAlta(formattedDate);
    	cuentaOrigen.setFechaUltimaModificacion(formattedDate);    	
    	cuentaOrigen.setMovimientos(movimientosCuentaOrigen);
    	cuentasCliente.add(cuentaOrigen);    	
    	
    	cuentaDestino = new Cuenta();
    	cuentaDestino.setCbu(35445637);
    	cuentaDestino.setNroCuenta(53656);
    	cuentaDestino.setNombre("Cuenta CA");
    	cuentaDestino.setSaldo(10000);
    	cuentaDestino.setEstado(true);
    	cuentaDestino.setTipoCuenta(tipoCuentaCA);
    	cuentaDestino.setFechaAlta(formattedDate);
    	cuentaDestino.setFechaUltimaModificacion(formattedDate);
    	cuentaDestino.setMovimientos(movimientosCuentaDestino);
    	cuentasCliente.add(cuentaDestino);    	
    	
    	trans = new Transferencia();
    	trans.setMovimientoOrigen(movOrigen);
    	trans.setMovimientoDestino(movDestino);
    	trans.setCuentaOrigen(cuentaOrigen);
    	trans.setCuentaDestino(cuentaDestino);
    	session.save(trans);
    	
    	usuario = new Usuario();
    	usuario.setEstado(true);
    	usuario.setFechaAlta(new Date());
    	usuario.setFechaUltimaModificacion(new Date());
    	usuario.setTipoUsuario("cliente");
    	usuario.setPass("1234");
    	usuario.setUserName("46541129");
    	
    	domicilio = new Domicilio();
    	domicilio.setDireccion("Elizalde");
    	domicilio.setLocalidad("Tigre");
    	
    	cli = new Cliente();
    	cli.setApellido("Valverde");
    	cli.setNombre("Roman");
    	cli.setDni(46541129);
    	cli.setSexo("M");
    	cli.setEstado(true);
    	cli.setNacionalidad(nacionalidad);
    	cli.setProvincia(provincia);
    	cli.setFechaNacimiento("1965-02-24");
    	cli.setDomicilio(domicilio);  
    	cli.setUsuario(usuario);
    	cli.setCuentas(cuentasCliente);
    	session.save(cli);
    	
////////////////////////////////////////////////////////////////////////	7

    	cuentasCliente = new ArrayList<Cuenta>();
    	movimientosCuentaDestino= new ArrayList<Movimiento>();
    	movimientosCuentaOrigen= new ArrayList<Movimiento>();
    	
    	movAltaCuenta = new Movimiento();
    	movAltaCuenta.setDetalle("Alta de Cuenta");
    	movAltaCuenta.setEstado(true);
    	movAltaCuenta.setFecha(new Date());
    	movAltaCuenta.setFechaUltimaModificacion(new Date());
    	movAltaCuenta.setTipoMovimiento(tipoTransferenciaDeb);
    	movAltaCuenta.setImporte(10000);
    	movimientosCuentaOrigen.add(movAltaCuenta);
    	
    	movOrigen = new Movimiento();
    	movOrigen.setDetalle("Transferencia débito");
    	movOrigen.setEstado(true);
    	movOrigen.setFecha(new Date());
    	movOrigen.setFechaUltimaModificacion(new Date());
    	movOrigen.setTipoMovimiento(tipoTransferenciaDeb);
    	movOrigen.setImporte(-6500);
    	movimientosCuentaOrigen.add(movOrigen);

    	movDestino = new Movimiento();
    	movDestino.setDetalle("Transferencia crédito");
    	movDestino.setEstado(true);
    	movDestino.setFecha(new Date());
    	movDestino.setFechaUltimaModificacion(new Date());
    	movDestino.setTipoMovimiento(tipoTransferenciaCred);
    	movDestino.setImporte(6500);
    	movimientosCuentaDestino.add(movDestino);
    	
    	cuentaOrigen = new Cuenta();
    	cuentaOrigen.setCbu(653264897);
    	cuentaOrigen.setNroCuenta(11122);
    	cuentaOrigen.setNombre("Cuenta CA");
    	cuentaOrigen.setSaldo(10000);
    	cuentaOrigen.setEstado(true);
    	cuentaOrigen.setTipoCuenta(tipoCuentaCA);
    	cuentaOrigen.setFechaAlta(formattedDate);
    	cuentaOrigen.setFechaUltimaModificacion(formattedDate);    	
    	cuentaOrigen.setMovimientos(movimientosCuentaOrigen);
    	cuentasCliente.add(cuentaOrigen);    	
    	
    	cuentaDestino = new Cuenta();
    	cuentaDestino.setCbu(35446478);
    	cuentaDestino.setNroCuenta(3456);
    	cuentaDestino.setNombre("Cuenta CA");
    	cuentaDestino.setSaldo(10000);
    	cuentaDestino.setEstado(true);
    	cuentaDestino.setTipoCuenta(tipoCuentaCA);
    	cuentaDestino.setFechaAlta(formattedDate);
    	cuentaDestino.setFechaUltimaModificacion(formattedDate);
    	cuentaDestino.setMovimientos(movimientosCuentaDestino);
    	cuentasCliente.add(cuentaDestino);
    	
    	trans = new Transferencia();
    	trans.setMovimientoOrigen(movOrigen);
    	trans.setMovimientoDestino(movDestino);
    	trans.setCuentaOrigen(cuentaOrigen);
    	trans.setCuentaDestino(cuentaDestino);
    	session.save(trans);
    	
    	usuario = new Usuario();
    	usuario.setEstado(true);
    	usuario.setFechaAlta(new Date());
    	usuario.setFechaUltimaModificacion(new Date());
    	usuario.setTipoUsuario("cliente");
    	usuario.setPass("1234");
    	usuario.setUserName("40635698");
    	
    	domicilio = new Domicilio();
    	domicilio.setDireccion("Av libertador");
    	domicilio.setLocalidad("Nuñez");
    	
    	cli = new Cliente();
    	cli.setApellido("Suarez");
    	cli.setNombre("Agustin");
    	cli.setDni(40635698);
    	cli.setSexo("M");
    	cli.setEstado(true);
    	cli.setNacionalidad(nacionalidad);
    	cli.setProvincia(provincia);
    	cli.setFechaNacimiento("1997-09-15");
    	cli.setDomicilio(domicilio);  
    	cli.setUsuario(usuario);
    	cli.setCuentas(cuentasCliente);
    	session.save(cli);
    	
////////////////////////////////////////////////////////////////////////	8
    	
    	cuentasCliente = new ArrayList<Cuenta>();
    	movimientosCuentaDestino= new ArrayList<Movimiento>();
    	movimientosCuentaOrigen= new ArrayList<Movimiento>();
    	
    	movAltaCuenta = new Movimiento();
    	movAltaCuenta.setDetalle("Alta de Cuenta");
    	movAltaCuenta.setEstado(true);
    	movAltaCuenta.setFecha(new Date());
    	movAltaCuenta.setFechaUltimaModificacion(new Date());
    	movAltaCuenta.setTipoMovimiento(tipoTransferenciaDeb);
    	movAltaCuenta.setImporte(10000);
    	movimientosCuentaOrigen.add(movAltaCuenta);
    	
    	movOrigen = new Movimiento();
    	movOrigen.setDetalle("Transferencia débito");
    	movOrigen.setEstado(true);
    	movOrigen.setFecha(new Date());
    	movOrigen.setFechaUltimaModificacion(new Date());
    	movOrigen.setTipoMovimiento(tipoTransferenciaDeb);
    	movOrigen.setImporte(-8400);
    	movimientosCuentaOrigen.add(movOrigen);

    	movDestino = new Movimiento();
    	movDestino.setDetalle("Transferencia crédito");
    	movDestino.setEstado(true);
    	movDestino.setFecha(new Date());
    	movDestino.setFechaUltimaModificacion(new Date());
    	movDestino.setTipoMovimiento(tipoTransferenciaCred);
    	movDestino.setImporte(8400);
    	movimientosCuentaDestino.add(movDestino);
    	
    	cuentaOrigen = new Cuenta();
    	cuentaOrigen.setCbu(12344897);
    	cuentaOrigen.setNroCuenta(99922);
    	cuentaOrigen.setNombre("Cuenta CA");
    	cuentaOrigen.setSaldo(10000);
    	cuentaOrigen.setEstado(true);
    	cuentaOrigen.setTipoCuenta(tipoCuentaCA);
    	cuentaOrigen.setFechaAlta(formattedDate);
    	cuentaOrigen.setFechaUltimaModificacion(formattedDate);    	
    	cuentaOrigen.setMovimientos(movimientosCuentaOrigen);
    	cuentasCliente.add(cuentaOrigen);    	
    	
    	cuentaDestino = new Cuenta();
    	cuentaDestino.setCbu(778478);
    	cuentaDestino.setNroCuenta(5316);
    	cuentaDestino.setNombre("Cuenta CA");
    	cuentaDestino.setSaldo(10000);
    	cuentaDestino.setEstado(true);
    	cuentaDestino.setTipoCuenta(tipoCuentaCA);
    	cuentaDestino.setFechaAlta(formattedDate);
    	cuentaDestino.setFechaUltimaModificacion(formattedDate);
    	cuentaDestino.setMovimientos(movimientosCuentaDestino);
    	cuentasCliente.add(cuentaDestino);
    	
    	trans = new Transferencia();
    	trans.setMovimientoOrigen(movOrigen);
    	trans.setMovimientoDestino(movDestino);
    	trans.setCuentaOrigen(cuentaOrigen);
    	trans.setCuentaDestino(cuentaDestino);
    	session.save(trans);
    	
    	usuario = new Usuario();
    	usuario.setEstado(true);
    	usuario.setFechaAlta(new Date());
    	usuario.setFechaUltimaModificacion(new Date());
    	usuario.setTipoUsuario("cliente");
    	usuario.setPass("1234");
    	usuario.setUserName("40123698");
    	
    	domicilio = new Domicilio();
    	domicilio.setDireccion("Rawson");
    	domicilio.setLocalidad("Ricardo Rojas");
    	
    	cli = new Cliente();
    	cli.setApellido("Suarez");
    	cli.setNombre("Edgardo");
    	cli.setDni(40123698);
    	cli.setSexo("M");
    	cli.setEstado(true);
    	cli.setNacionalidad(nacionalidad);
    	cli.setProvincia(provincia);
    	cli.setFechaNacimiento("1997-04-22");
    	cli.setDomicilio(domicilio);  
    	cli.setUsuario(usuario);
    	cli.setCuentas(cuentasCliente);
    	session.save(cli);
    	
////////////////////////////////////////////////////////////////////////	9

    	cuentasCliente = new ArrayList<Cuenta>();
    	movimientosCuentaDestino= new ArrayList<Movimiento>();
    	movimientosCuentaOrigen= new ArrayList<Movimiento>();
    	
    	movAltaCuenta = new Movimiento();
    	movAltaCuenta.setDetalle("Alta de Cuenta");
    	movAltaCuenta.setEstado(true);
    	movAltaCuenta.setFecha(new Date());
    	movAltaCuenta.setFechaUltimaModificacion(new Date());
    	movAltaCuenta.setTipoMovimiento(tipoTransferenciaDeb);
    	movAltaCuenta.setImporte(10000);
    	movimientosCuentaOrigen.add(movAltaCuenta);
    	
    	movOrigen = new Movimiento();
    	movOrigen.setDetalle("Transferencia débito");
    	movOrigen.setEstado(true);
    	movOrigen.setFecha(new Date());
    	movOrigen.setFechaUltimaModificacion(new Date());
    	movOrigen.setTipoMovimiento(tipoTransferenciaDeb);
    	movOrigen.setImporte(-1200);
    	movimientosCuentaOrigen.add(movOrigen);

    	movDestino = new Movimiento();
    	movDestino.setDetalle("Transferencia crédito");
    	movDestino.setEstado(true);
    	movDestino.setFecha(new Date());
    	movDestino.setFechaUltimaModificacion(new Date());
    	movDestino.setTipoMovimiento(tipoTransferenciaCred);
    	movDestino.setImporte(1200);
    	movimientosCuentaDestino.add(movDestino);
    	
    	cuentaOrigen = new Cuenta();
    	cuentaOrigen.setCbu(55544897);
    	cuentaOrigen.setNroCuenta(55522);
    	cuentaOrigen.setNombre("Cuenta CA");
    	cuentaOrigen.setSaldo(10000);
    	cuentaOrigen.setEstado(true);
    	cuentaOrigen.setTipoCuenta(tipoCuentaCA);
    	cuentaOrigen.setFechaAlta(formattedDate);
    	cuentaOrigen.setFechaUltimaModificacion(formattedDate);    	
    	cuentaOrigen.setMovimientos(movimientosCuentaOrigen);
    	cuentasCliente.add(cuentaOrigen);    	
    	
    	cuentaDestino = new Cuenta();
    	cuentaDestino.setCbu(770478);
    	cuentaDestino.setNroCuenta(99916);
    	cuentaDestino.setNombre("Cuenta CA");
    	cuentaDestino.setSaldo(10000);
    	cuentaDestino.setEstado(true);
    	cuentaDestino.setTipoCuenta(tipoCuentaCA);
    	cuentaDestino.setFechaAlta(formattedDate);
    	cuentaDestino.setFechaUltimaModificacion(formattedDate);
    	cuentaDestino.setMovimientos(movimientosCuentaDestino);
    	cuentasCliente.add(cuentaDestino);
    	
    	trans = new Transferencia();
    	trans.setMovimientoOrigen(movOrigen);
    	trans.setMovimientoDestino(movDestino);
    	trans.setCuentaOrigen(cuentaOrigen);
    	trans.setCuentaDestino(cuentaDestino);
    	session.save(trans);
    	
    	usuario = new Usuario();
    	usuario.setEstado(true);
    	usuario.setFechaAlta(new Date());
    	usuario.setFechaUltimaModificacion(new Date());
    	usuario.setTipoUsuario("cliente");
    	usuario.setPass("1234");
    	usuario.setUserName("12564987");
    	
    	domicilio = new Domicilio();
    	domicilio.setDireccion("Cardenal Fagnano");
    	domicilio.setLocalidad("Ricardo Rojas");
    	
    	cli = new Cliente();
    	cli.setApellido("Palacios");
    	cli.setNombre("Maria");
    	cli.setDni(12564987);
    	cli.setSexo("F");
    	cli.setEstado(true);
    	cli.setNacionalidad(nacionalidad);
    	cli.setProvincia(provincia);
    	cli.setFechaNacimiento("1975-01-25");
    	cli.setDomicilio(domicilio);  
    	cli.setUsuario(usuario);
    	cli.setCuentas(cuentasCliente);
    	session.save(cli);
    	
////////////////////////////////////////////////////////////////////////	10

    	cuentasCliente = new ArrayList<Cuenta>();
    	movimientosCuentaDestino= new ArrayList<Movimiento>();
    	movimientosCuentaOrigen= new ArrayList<Movimiento>();
    	
    	movAltaCuenta = new Movimiento();
    	movAltaCuenta.setDetalle("Alta de Cuenta");
    	movAltaCuenta.setEstado(true);
    	movAltaCuenta.setFecha(new Date());
    	movAltaCuenta.setFechaUltimaModificacion(new Date());
    	movAltaCuenta.setTipoMovimiento(tipoTransferenciaDeb);
    	movAltaCuenta.setImporte(10000);
    	movimientosCuentaOrigen.add(movAltaCuenta);
    	
    	movOrigen = new Movimiento();
    	movOrigen.setDetalle("Transferencia débito");
    	movOrigen.setEstado(true);
    	movOrigen.setFecha(new Date());
    	movOrigen.setFechaUltimaModificacion(new Date());
    	movOrigen.setTipoMovimiento(tipoTransferenciaDeb);
    	movOrigen.setImporte(-1550);
    	movimientosCuentaOrigen.add(movOrigen);

    	movDestino = new Movimiento();
    	movDestino.setDetalle("Transferencia crédito");
    	movDestino.setEstado(true);
    	movDestino.setFecha(new Date());
    	movDestino.setFechaUltimaModificacion(new Date());
    	movDestino.setTipoMovimiento(tipoTransferenciaCred);
    	movDestino.setImporte(1550);
    	movimientosCuentaDestino.add(movDestino);
    	
    	cuentaOrigen = new Cuenta();
    	cuentaOrigen.setCbu(33544897);
    	cuentaOrigen.setNroCuenta(33522);
    	cuentaOrigen.setNombre("Cuenta CA");
    	cuentaOrigen.setSaldo(10000);
    	cuentaOrigen.setEstado(true);
    	cuentaOrigen.setTipoCuenta(tipoCuentaCA);
    	cuentaOrigen.setFechaAlta(formattedDate);
    	cuentaOrigen.setFechaUltimaModificacion(formattedDate);    	
    	cuentaOrigen.setMovimientos(movimientosCuentaOrigen);
    	cuentasCliente.add(cuentaOrigen);    	
    	
    	cuentaDestino = new Cuenta();
    	cuentaDestino.setCbu(112478);
    	cuentaDestino.setNroCuenta(11216);
    	cuentaDestino.setNombre("Cuenta CA");
    	cuentaDestino.setSaldo(10000);
    	cuentaDestino.setEstado(true);
    	cuentaDestino.setTipoCuenta(tipoCuentaCA);
    	cuentaDestino.setFechaAlta(formattedDate);
    	cuentaDestino.setFechaUltimaModificacion(formattedDate);
    	cuentaDestino.setMovimientos(movimientosCuentaDestino);
    	cuentasCliente.add(cuentaDestino);
    	
    	trans = new Transferencia();
    	trans.setMovimientoOrigen(movOrigen);
    	trans.setMovimientoDestino(movDestino);
    	trans.setCuentaOrigen(cuentaOrigen);
    	trans.setCuentaDestino(cuentaDestino);
    	session.save(trans);
    	
    	usuario = new Usuario();
    	usuario.setEstado(true);
    	usuario.setFechaAlta(new Date());
    	usuario.setFechaUltimaModificacion(new Date());
    	usuario.setTipoUsuario("cliente");
    	usuario.setPass("1234");
    	usuario.setUserName("12564327");
    	
    	domicilio = new Domicilio();
    	domicilio.setDireccion("Uriburu");
    	domicilio.setLocalidad("Ricardo Rojas");
    	
    	cli = new Cliente();
    	cli.setApellido("Brandan");
    	cli.setNombre("Yanina");
    	cli.setDni(12564327);
    	cli.setSexo("F");
    	cli.setEstado(true);
    	cli.setNacionalidad(nacionalidad);
    	cli.setProvincia(provincia);
    	cli.setFechaNacimiento("1972-01-21");
    	cli.setDomicilio(domicilio);  
    	cli.setUsuario(usuario);
    	cli.setCuentas(cuentasCliente);
    	session.save(cli);
    	
    	
    	//Empleados
    	usuario = new Usuario();
    	usuario.setEstado(true);
    	usuario.setFechaAlta(new Date());
    	usuario.setFechaUltimaModificacion(new Date());
    	usuario.setTipoUsuario("empleado");
    	usuario.setPass("1234");
    	usuario.setUserName("40379338");    	

    	Empleado em = new Empleado();
    	em.setApellido("Valenzuela");
    	em.setNombre("Elias");
    	em.setDni(40379338);
    	em.setSexo("M");
    	em.setEstado(true);
    	em.setNacionalidad(nacionalidad);
    	em.setProvincia(provincia);
    	em.setFechaNacimiento("1997-04-22");
    	em.setDomicilio(domicilio);  
    	em.setUsuario(usuario);
    	session.save(em);
    	
    	usuario = new Usuario();
    	usuario.setEstado(true);
    	usuario.setFechaAlta(new Date());
    	usuario.setFechaUltimaModificacion(new Date());
    	usuario.setTipoUsuario("empleado");
    	usuario.setPass("1234");
    	usuario.setUserName("40651874");    	

    	em = new Empleado();
    	em.setApellido("Ramirez");
    	em.setNombre("Nicolas");
    	em.setDni(40651874);
    	em.setSexo("M");
    	em.setEstado(true);
    	em.setNacionalidad(nacionalidad);
    	em.setProvincia(provincia);
    	em.setFechaNacimiento("1993-01-22");
    	em.setDomicilio(domicilio);  
    	em.setUsuario(usuario);
    	session.save(em);
    	
    	usuario = new Usuario();
    	usuario.setEstado(true);
    	usuario.setFechaAlta(new Date());
    	usuario.setFechaUltimaModificacion(new Date());
    	usuario.setTipoUsuario("empleado");
    	usuario.setPass("1234");
    	usuario.setUserName("12546987");    	

    	em = new Empleado();
    	em.setApellido("Cordoba");
    	em.setNombre("Ezequiel");
    	em.setDni(12546987);
    	em.setSexo("M");
    	em.setEstado(true);
    	em.setNacionalidad(nacionalidad);
    	em.setProvincia(provincia);
    	em.setFechaNacimiento("1972-02-12");
    	em.setDomicilio(domicilio);  
    	em.setUsuario(usuario);
    	session.save(em);
    	
    	usuario = new Usuario();
    	usuario.setEstado(true);
    	usuario.setFechaAlta(new Date());
    	usuario.setFechaUltimaModificacion(new Date());
    	usuario.setTipoUsuario("empleado");
    	usuario.setPass("1234");
    	usuario.setUserName("40326518");    	

    	em = new Empleado();
    	em.setApellido("Esquivel");
    	em.setNombre("Giselle");
    	em.setDni(40326518);
    	em.setSexo("F");
    	em.setEstado(true);
    	em.setNacionalidad(nacionalidad);
    	em.setProvincia(provincia);
    	em.setFechaNacimiento("1990-01-23");
    	em.setDomicilio(domicilio);  
    	em.setUsuario(usuario);
    	session.save(em);    	

    	session.getTransaction().commit();
    	session.close();
    	sessionFactory.close();

	}
}
