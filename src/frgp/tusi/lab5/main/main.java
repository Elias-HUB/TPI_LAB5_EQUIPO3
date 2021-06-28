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
import frgp.tusi.lab5.model.Movimiento;
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
        
        //////////////////////////////////////////////
    	
//    	List<Cuenta> cuentasCliente1 = new ArrayList<Cuenta>();
//    	List<Cuenta> cuentasCliente2 = new ArrayList<Cuenta>();
//    	List<Cuenta> cuentasCliente3 = new ArrayList<Cuenta>();
//    	List<Cuenta> cuentasCliente4 = new ArrayList<Cuenta>();
//    	List<Cuenta> cuentasCliente5 = new ArrayList<Cuenta>();
    	    	
        Cuenta cu = new Cuenta();
//    	cu.setCbu(5335235);
//    	cu.setNroCuenta(0);
//    	cu.setNombre("Caja de ahorro en dólares");
//    	cu.setId(1);
//    	cu.setSaldo(10000);
//    	cu.setEstado(true);
//    	cu.setFechaAlta(formattedDate);
//    	cu.setFechaUltimaModificacion(formattedDate);
////    	cuentasCliente1.add(cu);
//    	session.save(cu);
//    	
//    	cu = new Cuenta();
//    	cu.setCbu(45728643);
//    	cu.setNroCuenta(0);
//    	cu.setNombre("Caja de ahorro en pesos");
//    	cu.setId(1);
//    	cu.setSaldo(20000);
//    	cu.setEstado(true);
//    	cu.setFechaAlta(formattedDate);
//    	cu.setFechaUltimaModificacion(formattedDate);   	
////    	cuentasCliente1.add(cu);
//    	session.save(cu);
//    	
//    	cu = new Cuenta();
//    	cu.setCbu(75427542);
//    	cu.setNroCuenta(0);
//    	cu.setNombre("Caja de ahorro en pesos");
//    	cu.setId(1);
//    	cu.setSaldo(30000);
//    	cu.setEstado(true);
//    	cu.setFechaAlta(formattedDate);
//    	cu.setFechaUltimaModificacion(formattedDate);
////    	cuentasCliente2.add(cu);
//    	session.save(cu);
//    	
//    	cu = new Cuenta();
//    	cu.setCbu(6436343);
//    	cu.setNroCuenta(0);
//    	cu.setNombre("Caja de ahorro en pesos");
//    	cu.setId(1);
//    	cu.setSaldo(10000);
//    	cu.setEstado(true);
//    	cu.setFechaAlta(formattedDate);
//    	cu.setFechaUltimaModificacion(formattedDate);
////    	cuentasCliente3.add(cu);
//    	session.save(cu);
//    	
//    	cu = new Cuenta();
//    	cu.setCbu(6436434);
//    	cu.setNroCuenta(0);
//    	cu.setNombre("Caja de ahorro en pesos");
//    	cu.setId(1);
//    	cu.setSaldo(50000);
//    	cu.setEstado(true);
//    	cu.setFechaAlta(formattedDate);
//    	cu.setFechaUltimaModificacion(formattedDate);
////    	cuentasCliente4.add(cu);
//    	session.save(cu);
//    	
//    	cu = new Cuenta();
//    	cu.setCbu(2362363);
//    	cu.setNroCuenta(0);
//    	cu.setNombre("Caja de ahorro en pesos");
//    	cu.setId(1);
//    	cu.setSaldo(15000);
//    	cu.setEstado(true);
//    	cu.setFechaAlta(formattedDate);
//    	cu.setFechaUltimaModificacion(formattedDate);
////    	cuentasCliente4.add(cu);
//    	session.save(cu);
//    	
    	
    	
    	//INICIO ELIAS
    	List<Cuenta> cuentasCliente = new ArrayList<Cuenta>();
    	List<Movimiento> movimientos = new ArrayList<Movimiento>();
    	List<Movimiento> movimientosCuentaOrigen = new ArrayList<Movimiento>();
    	List<Movimiento> movimientosCuentaDestino = new ArrayList<Movimiento>();
    	

//		Movimiento mov = new Movimiento();
//    	mov.setDetalle("Pago tarjeta");
//    	mov.setEstado(true);
//    	mov.setFecha(new Date());
//    	mov.setFechaUltimaModificacion(new Date());
//    	mov.setIdTipoMovimiento(4);
//    	mov.setImporte(12000);
//    	movimientos.add(mov);
    	
    	TipoMovimiento tipoTransferenciaDeb = new TipoMovimiento();
    	TipoMovimiento tipoTransferenciaCred = new TipoMovimiento();
    	TipoMovimiento tipoAltaCuenta = new TipoMovimiento();
    	tipoTransferenciaDeb.setDescripcion("Transferencia Débito");
    	tipoTransferenciaCred.setDescripcion("Transferencia Crédito");
    	tipoAltaCuenta.setDescripcion("Alta de Cuenta");
    	session.save(tipoAltaCuenta);
    	
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
    	cuentaOrigen.setNombre("Caja de ahorro en pesos");
    	cuentaOrigen.setSaldo(10000);
    	cuentaOrigen.setEstado(true);
    	cuentaOrigen.setFechaAlta(formattedDate);
    	cuentaOrigen.setFechaUltimaModificacion(formattedDate);    	
    	cuentaOrigen.setMovimientos(movimientosCuentaOrigen);
    	cuentasCliente.add(cuentaOrigen);    	
    	
    	Cuenta cuentaDestino = new Cuenta();
    	cuentaDestino.setCbu(23452346);
    	cuentaDestino.setNroCuenta(5346);
    	cuentaDestino.setNombre("Caja de ahorro en pesos");
    	cuentaDestino.setSaldo(10000);
    	cuentaDestino.setEstado(true);
    	cuentaDestino.setFechaAlta(formattedDate);
    	cuentaDestino.setFechaUltimaModificacion(formattedDate);
    	cuentaDestino.setMovimientos(movimientosCuentaDestino);
    	cuentasCliente.add(cuentaDestino);    	
    	
    	Transferencia trans = new Transferencia();
    	trans.setMovimientoOrigen(movOrigen);
    	trans.setMovimientoDestino(movDestino);
    	trans.setCuentaOrigen(cuentaOrigen);
    	trans.setCuentaDestino(cuentaDestino);
    	session.save(trans);
    	
    	Usuario usuario = new Usuario();
    	usuario.setEstado(true);
    	usuario.setFechaAlta(new Date());
    	usuario.setTipoUsuario("empleado");
    	usuario.setPass("1234");
    	usuario.setUserName("Arias");
    	
    	Domicilio domicilio = new Domicilio();
    	domicilio.setDireccion("AV Cordoba");
    	domicilio.setLocalidad("Talar");
    	domicilio.setProvincia("Buenos aires");
    	
    	Cliente cli = new Cliente();
    	cli.setApellido("Arias");
    	cli.setNombre("Franco");
    	cli.setDni(21412359);
    	cli.setSexo("M");
    	cli.setNacionalidad("Argentina");
    	cli.setFechaNacimiento("14/02/1980");
    	cli.setDomicilio(domicilio);  
    	cli.setUsuario(usuario);
    	cli.setCuentas(cuentasCliente);
    	session.save(cli);
    	
    	//FIN ELIAS
    	
		List<Cuenta> cuentasClienteDos = new ArrayList<Cuenta>();
    	List<Movimiento> movimientosCuentaOrigenDos = new ArrayList<Movimiento>();
    	List<Movimiento> movimientosCuentaDestinoDos = new ArrayList<Movimiento>();
		
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
    	cuentaOrigenDos.setNombre("Caja de ahorro en pesos");
    	cuentaOrigenDos.setSaldo(10000);
    	cuentaOrigenDos.setEstado(true);
    	cuentaOrigenDos.setFechaAlta(formattedDate);
    	cuentaOrigenDos.setFechaUltimaModificacion(formattedDate);    	
    	cuentaOrigenDos.setMovimientos(movimientosCuentaOrigenDos);
    	cuentasClienteDos.add(cuentaOrigenDos);    	
    	
    	Cuenta cuentaDestinoDos = new Cuenta();
    	cuentaDestinoDos.setCbu(12737271);
    	cuentaDestinoDos.setNroCuenta(3627);
    	cuentaDestinoDos.setNombre("Caja de ahorro en pesos");
    	cuentaDestinoDos.setSaldo(10000);
    	cuentaDestinoDos.setEstado(true);
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
    	usuarioDos.setTipoUsuario("cliente");
    	usuarioDos.setPass("1234");
    	usuarioDos.setUserName("ratape");
    	
    	Domicilio domicilioDos = new Domicilio();
    	domicilioDos.setDireccion("Buenos Aires");
    	domicilioDos.setLocalidad("Tigre");
    	domicilioDos.setProvincia("Buenos Aires");
    	
    	Cliente cliDos = new Cliente();
    	cliDos.setApellido("Rata");
    	cliDos.setNombre("Pedro");
    	cliDos.setDni(23546373);
    	cliDos.setSexo("M");
    	cliDos.setNacionalidad("Argentina");
    	cliDos.setFechaNacimiento("14/02/1980");
		cliDos.setEstado(true);
    	cliDos.setDomicilio(domicilioDos);  
    	cliDos.setUsuario(usuarioDos);
    	cliDos.setCuentas(cuentasClienteDos);
    	session.save(cliDos);
////////////////////////////////////////////////////////////////////////
		List<Cuenta> cuentasClienteTres = new ArrayList<Cuenta>();
    	List<Movimiento> movimientosCuentaOrigenTres = new ArrayList<Movimiento>();
    	List<Movimiento> movimientosCuentaDestinoTres = new ArrayList<Movimiento>();
	
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
    	cuentaOrigenTres.setNombre("Caja de ahorro en pesos");
    	cuentaOrigenTres.setSaldo(10000);
    	cuentaOrigenTres.setEstado(true);
    	cuentaOrigenTres.setFechaAlta(formattedDate);
    	cuentaOrigenTres.setFechaUltimaModificacion(formattedDate);    	
    	cuentaOrigenTres.setMovimientos(movimientosCuentaOrigenTres);
    	cuentasClienteTres.add(cuentaOrigenTres);    	
    	
    	Cuenta cuentaDestinoTres = new Cuenta();
    	cuentaDestinoTres.setCbu(32785467);
    	cuentaDestinoTres.setNroCuenta(4792);
    	cuentaDestinoTres.setNombre("Caja de ahorro en pesos");
    	cuentaDestinoTres.setSaldo(10000);
    	cuentaDestinoTres.setEstado(true);
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
    	usuarioTres.setTipoUsuario("cliente");
    	usuarioTres.setPass("1234");
    	usuarioTres.setUserName("JuanaLo");
    	
    	Domicilio domicilioTres = new Domicilio();
    	domicilioTres.setDireccion("Francia");
    	domicilioTres.setLocalidad("Tigre");
    	domicilioTres.setProvincia("Buenos aires");
    	
    	Cliente cliTres = new Cliente();
    	cliTres.setApellido("Lopez");
    	cliTres.setNombre("Juana");
    	cliTres.setDni(25863173);
    	cliTres.setSexo("F");
    	cliTres.setNacionalidad("Argentina");
    	cliTres.setFechaNacimiento("14/02/1985");
		cliTres.setEstado(false);
    	cliTres.setDomicilio(domicilioTres);  
    	cliTres.setUsuario(usuarioTres);
    	cliTres.setCuentas(cuentasClienteTres);
    	session.save(cliTres);
////////////////////////////////////////////////////////////////////////////
		List<Cuenta> cuentasClienteCuatro = new ArrayList<Cuenta>();
    	List<Movimiento> movimientosCuentaOrigenCuatro = new ArrayList<Movimiento>();
    	List<Movimiento> movimientosCuentaDestinoCuatro = new ArrayList<Movimiento>();
		
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
    	cuentaOrigenCuatro.setNombre("Caja de ahorro en pesos");
    	cuentaOrigenCuatro.setSaldo(10000);
    	cuentaOrigenCuatro.setEstado(true);
    	cuentaOrigenCuatro.setFechaAlta(formattedDate);
    	cuentaOrigenCuatro.setFechaUltimaModificacion(formattedDate);    	
    	cuentaOrigenCuatro.setMovimientos(movimientosCuentaOrigenCuatro);
    	cuentasClienteCuatro.add(cuentaOrigenCuatro);    	
    	
    	Cuenta cuentaDestinoCuatro = new Cuenta();
    	cuentaDestinoCuatro.setCbu(23547623);
    	cuentaDestinoCuatro.setNroCuenta(202);
    	cuentaDestinoCuatro.setNombre("Caja de ahorro en pesos");
    	cuentaDestinoCuatro.setSaldo(10000);
    	cuentaDestinoCuatro.setEstado(true);
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
    	usuarioCuatro.setTipoUsuario("empleado");
    	usuarioCuatro.setPass("1234");
    	usuarioCuatro.setUserName("Corzo");
    	
    	Domicilio domicilioCuatro = new Domicilio();
    	domicilioCuatro.setDireccion("9 Julio");
    	domicilioCuatro.setLocalidad("Escobar");
    	domicilioCuatro.setProvincia("Buenos aires");
    	
    	Cliente cliCuatro = new Cliente();
    	cliCuatro.setApellido("Corzo");
    	cliCuatro.setNombre("Gonzalo");
    	cliCuatro.setDni(30452120);
    	cliCuatro.setSexo("M");
    	cliCuatro.setNacionalidad("Argentina");
    	cliCuatro.setFechaNacimiento("14/02/1990");
		cliCuatro.setEstado(true);
    	cliCuatro.setDomicilio(domicilioCuatro);
    	cliCuatro.setUsuario(usuarioCuatro);
    	cliCuatro.setCuentas(cuentasClienteCuatro);
    	session.save(cliCuatro);
    	
//    	cli = new Cliente();
//    	cli.setApellido("López");
//    	cli.setNombre("Roberto");
//    	cli.setDni(39359231);
//    	cli.setSexo("M");
//    	cli.setNacionalidad("Argentina");
//    	cli.setFechaNacimiento("10/09/1998");
//    	cli.setDomicilio("Netcore 330");
////    	cli.setCuentas(cuentasCliente2);
//    	session.save(cli);
//    	
//    	cli = new Cliente();
//    	cli.setApellido("Suárez");
//    	cli.setNombre("Jacinta");
//    	cli.setDni(1325464);
//    	cli.setSexo("F");
//    	cli.setNacionalidad("Argentina");
//    	cli.setFechaNacimiento("02/11/1944");
//    	cli.setDomicilio("Javascript 99");
////    	cli.setCuentas(cuentasCliente3);
//    	session.save(cli);
//    	
//    	cli = new Cliente();
//    	cli.setApellido("Rodríguez Montoya");
//    	cli.setNombre("Juliana");
//    	cli.setDni(95434252);
//    	cli.setSexo("F");
//    	cli.setNacionalidad("Paraguaya");
//    	cli.setFechaNacimiento("11/08/1990");
//    	cli.setDomicilio("Python");
////    	cli.setCuentas(cuentasCliente4);
//    	session.save(cli);
//    	
//    	cli = new Cliente();
//    	cli.setApellido("Pérez Núñez");
//    	cli.setNombre("Marcelo");
//    	cli.setDni(28416423);
//    	cli.setSexo("M");
//    	cli.setNacionalidad("Argentina");
//    	cli.setFechaNacimiento("01/01/1980");
//    	cli.setDomicilio("Javascript 533");
////    	cli.setCuentas(cuentasCliente5);
//    	session.save(cli);
//    	
//    	cli = new Cliente();
//    	cli.setApellido("López");
//    	cli.setNombre("Samantha");
//    	cli.setDni(95454877);
//    	cli.setSexo("F");
//    	cli.setNacionalidad("Venezolana");
//    	cli.setFechaNacimiento("25/09/1988");
//    	cli.setDomicilio("React 3304");
//    	session.save(cli);
//    	
//    	cli = new Cliente();
//    	cli.setApellido("García");
//    	cli.setNombre("Francisco");
//    	cli.setDni(25465442);
//    	cli.setSexo("M");
//    	cli.setNacionalidad("Argentina");
//    	cli.setFechaNacimiento("08/01/1980");
//    	cli.setDomicilio("Angular 4664");
//    	session.save(cli);
//    	
//    	cli = new Cliente();
//    	cli.setApellido("Correa");
//    	cli.setNombre("Pepe");
//    	cli.setDni(21634868);
//    	cli.setSexo("M");
//    	cli.setNacionalidad("Argentina");
//    	cli.setFechaNacimiento("27/03/1978");
//    	cli.setDomicilio("VueJs 953");
//    	session.save(cli);
//    	
//    	cli = new Cliente();
//    	cli.setApellido("Gómez Bolaños");
//    	cli.setNombre("Roberto");
//    	cli.setDni(95345678);
//    	cli.setSexo("M");
//    	cli.setNacionalidad("Mexicana");
//    	cli.setFechaNacimiento("21/02/1929");
//    	cli.setDomicilio("La vecindad 933");
//    	session.save(cli);
//    	
//    	cli = new Cliente();
//    	cli.setApellido("Robertson");
//    	cli.setNombre("Ashley");
//    	cli.setDni(95064213);
//    	cli.setSexo("F");
//    	cli.setNacionalidad("Estadounidense");
//    	cli.setFechaNacimiento("01/02/1990");
//    	cli.setDomicilio("");
//    	session.save(cli);
//    	
//    	//////////////////////////////////////////////////    	
//    	Usuario usu = new Usuario();
//    	Empleado em = new Empleado();
//    	em.setLegajo(1);
//    	em.setApellido("Valenzuela");
//    	em.setNombre("Elias");
//    	em.setDni(40379338);
//    	em.setDomicilio("Fagnano 2784");
//    	em.setEstado(true);
//    	em.setFechaNacimiento(formattedDate);
//    	em.setNacionalidad("Ar");
//    	em.setSexo("M");
//////    	usu.setEstado(true);
////    	usu.setUserName("EliasValenzuela");
//////    	usu.setPass("ab1234");
//////    	usu.setIdTipoUsuario(1);
////    	em.setUsuario(usu);
//    	session.save(em);
//    	
//    	usu = new Usuario();
//    	em = new Empleado();
//    	em.setLegajo(2);
//    	em.setApellido("Suarez");
//    	em.setNombre("Yamil");
//    	em.setDni(14315648);
//    	em.setDomicilio("Marco sastre");
//    	em.setEstado(true);
//    	em.setFechaNacimiento(formattedDate);
//    	em.setNacionalidad("Argentina");
//    	em.setSexo("M");
//////    	usu.setEstado(true);
////    	usu.setUserName("YamilSuarez");
//////    	usu.setPass("");
//////    	usu.setIdTipoUsuario(1);
////    	em.setUsuario(usu);
//    	session.save(em);
//    	
//    	usu = new Usuario();
//    	em = new Empleado();
//    	em.setLegajo(3);
//    	em.setApellido("Oriana");
//    	em.setNombre("Garcia");
//    	em.setDni(40379564);
//    	em.setDomicilio("Colombia 1550");
//    	em.setEstado(true);
//    	em.setFechaNacimiento(formattedDate);
//    	em.setNacionalidad("Argentina");
//    	em.setSexo("F");
//////    	usu.setEstado(true);
////    	usu.setUserName("OrianaGarcia");
//////    	usu.setPass("");
//////    	usu.setIdTipoUsuario(1);
////    	em.setUsuario(usu);
//    	session.save(em);
//    	
//    	usu = new Usuario();
//    	em = new Empleado();
//    	em.setLegajo(4);
//    	em.setApellido("Oscar");
//    	em.setNombre("Ditolbi");
//    	em.setDni(12546514);
//    	em.setDomicilio("Fagnano 2784");
//    	em.setEstado(true);
//    	em.setFechaNacimiento(formattedDate);
//    	em.setNacionalidad("Argentina");
//    	em.setSexo("M");
//////    	usu.setEstado(true);
////    	usu.setUserName("OscarDitolbi");
//////    	usu.setPass("");
//////    	usu.setIdTipoUsuario(1);
////    	em.setUsuario(usu);
//    	session.save(em);
//    	
//    	usu = new Usuario();
//    	em = new Empleado();
//    	em.setLegajo(5);
//    	em.setApellido("Maria");
//    	em.setNombre("Palacios");
//    	em.setDni(1654879);
//    	em.setDomicilio("Elizade 2936");
//    	em.setEstado(true);
//    	em.setFechaNacimiento(formattedDate);
//    	em.setNacionalidad("Argentina");
//    	em.setSexo("F");
//////    	usu.setEstado(true);
////    	usu.setUserName("MariaPalacios");
//////    	usu.setPass("");
//////    	usu.setIdTipoUsuario(1);
////    	em.setUsuario(usu);
//    	session.save(em);
//    	
//    	usu = new Usuario();
//    	em = new Empleado();
//    	em.setLegajo(6);
//    	em.setApellido("Sonia");
//    	em.setNombre("Palacios");
//    	em.setDni(12345678);
//    	em.setDomicilio("Elizalde 1564");
//    	em.setEstado(true);
//    	em.setFechaNacimiento(formattedDate);
//    	em.setNacionalidad("Argentina");
//    	em.setSexo("F");
//////    	usu.setEstado(true);
////    	usu.setUserName("SoniaPalacios");
//////    	usu.setPass("");
//////    	usu.setIdTipoUsuario(1);
////    	em.setUsuario(usu);
//    	session.save(em);
//    	
//    	usu = new Usuario();
//    	em = new Empleado();
//    	em.setLegajo(7);
//    	em.setApellido("Rodriguez");
//    	em.setNombre("Pablo");
//    	em.setDni(16549134);
//    	em.setDomicilio("Talar 4678");
//    	em.setEstado(true);
//    	em.setFechaNacimiento(formattedDate);
//    	em.setNacionalidad("Argentina");
//    	em.setSexo("");
//////    	usu.setEstado(true);
////    	usu.setUserName("RodriguezPablo");
//////    	usu.setPass("");
//////    	usu.setIdTipoUsuario(1);
////    	em.setUsuario(usu);
//    	session.save(em);
//    	
//    	usu = new Usuario();
//    	em = new Empleado();
//    	em.setLegajo(8);
//    	em.setApellido("Contento");
//    	em.setNombre("Juan");
//    	em.setDni(39546514);
//    	em.setDomicilio("Riobamba 1234");
//    	em.setEstado(true);
//    	em.setFechaNacimiento(formattedDate);
//    	em.setNacionalidad("Argentina");
//    	em.setSexo("M");
//////    	usu.setEstado(true);
////    	usu.setUserName("ContentoJuan");
//////    	usu.setPass("");
//////    	usu.setIdTipoUsuario(1);
////    	em.setUsuario(usu);
//    	session.save(em);
//    	
//    	usu = new Usuario();
//    	em = new Empleado();
//    	em.setLegajo(9);
//    	em.setApellido("Valverde");
//    	em.setNombre("Roman");
//    	em.setDni(12456879);
//    	em.setDomicilio("Talar 154");
//    	em.setEstado(true);
//    	em.setFechaNacimiento(formattedDate);
//    	em.setNacionalidad("Argentina");
//    	em.setSexo("M");
//////    	usu.setEstado(true);
////    	usu.setUserName("ValverdeRoman");
//////    	usu.setPass("");
//////    	usu.setIdTipoUsuario(1);
////    	em.setUsuario(usu);
//    	session.save(em);
//    	
//    	usu = new Usuario();
//    	em = new Empleado();
//    	em.setLegajo(10);
//    	em.setApellido("Camporo");
//    	em.setNombre("Luciano");
//    	em.setDni(45613598);
//    	em.setDomicilio("Fagnano 65798");
//    	em.setEstado(true);
//    	em.setFechaNacimiento(formattedDate);
//    	em.setNacionalidad("Argentina");
//    	em.setSexo("M");
//////    	usu.setEstado(true);
////    	usu.setUserName("CamporoLuciano");
//////    	usu.setPass("");
//////    	usu.setIdTipoUsuario(1);
////    	em.setUsuario(usu);
//    	session.save(em);
//    	    	
//    	//////////////////////////////////////////////////
//    	Movimiento mov = new Movimiento();
//    	mov.setDetalle("Transferencia");
//    	mov.setEstado(true);
//    	mov.setFecha(new Date());
//    	mov.setFechaUltimaModificacion(new Date());
//    	mov.setIdCuenta(1);
//    	mov.setIdTipoMovimiento(1);
//    	mov.setImporte(1000);
//    	session.save(mov);
//    	
//    	mov = new Movimiento();
//    	mov.setDetalle("Transferencia");
//    	mov.setEstado(true);
//    	mov.setFecha(new Date());
//    	mov.setFechaUltimaModificacion(new Date());
//    	mov.setIdCuenta(1);
//    	mov.setIdTipoMovimiento(1);
//    	mov.setImporte(1000);
//    	session.save(mov);
//		
//		mov = new Movimiento();
//    	mov.setDetalle("Crédito");
//    	mov.setEstado(true);
//    	mov.setFecha(new Date());
//    	mov.setFechaUltimaModificacion(new Date());
//    	mov.setIdCuenta(3);
//    	mov.setIdTipoMovimiento(2);
//    	mov.setImporte(2000);
//    	session.save(mov);
//		
//		mov = new Movimiento();
//    	mov.setDetalle("Débito");
//    	mov.setEstado(true);
//    	mov.setFecha(new Date());
//    	mov.setFechaUltimaModificacion(new Date());
//    	mov.setIdCuenta(4);
//    	mov.setIdTipoMovimiento(3);
//    	mov.setImporte(3000);
//    	session.save(mov);
//		
//		mov = new Movimiento();
//    	mov.setDetalle("Transferencia");
//    	mov.setEstado(true);
//    	mov.setFecha(new Date());
//    	mov.setFechaUltimaModificacion(new Date());
//    	mov.setIdCuenta(5);
//    	mov.setIdTipoMovimiento(1);
//    	mov.setImporte(20000);
//    	session.save(mov);
//		
//		mov = new Movimiento();
//    	mov.setDetalle("Pago tarjeta");
//    	mov.setEstado(true);
//    	mov.setFecha(new Date());
//    	mov.setFechaUltimaModificacion(new Date());
//    	mov.setIdCuenta(1);
//    	mov.setIdTipoMovimiento(4);
//    	mov.setImporte(12000);
//    	session.save(mov);
//		
//		mov = new Movimiento();
//    	mov.setDetalle("Débito");
//    	mov.setEstado(true);
//    	mov.setFecha(new Date());
//    	mov.setFechaUltimaModificacion(new Date());
//    	mov.setIdCuenta(2);
//    	mov.setIdTipoMovimiento(3);
//    	mov.setImporte(24000);
//    	session.save(mov);
//		
//		mov = new Movimiento();
//    	mov.setDetalle("Transferencia");
//    	mov.setEstado(true);
//    	mov.setFecha(new Date());
//    	mov.setFechaUltimaModificacion(new Date());
//    	mov.setIdCuenta(1);
//    	mov.setIdTipoMovimiento(1);
//    	mov.setImporte(21000);
//    	session.save(mov);
//    	
//
//    	//////////////////////////////////////////////////
//    	Transferencia tra = new Transferencia();
//    	tra.setIdCuentaOrigen(1);
//    	tra.setIdCuentaDestino(2);
//    	tra.setIdMovOrigen(1);
//    	tra.setIdMovDestino(2);
//    	session.save(tra);
//
//    	tra = new Transferencia();
//    	tra.setIdCuentaOrigen(1);
//    	tra.setIdCuentaDestino(9);
//    	tra.setIdMovOrigen(1);
//    	tra.setIdMovDestino(2);
//    	session.save(tra);
//		
//		tra = new Transferencia();
//    	tra.setIdCuentaOrigen(2);
//    	tra.setIdCuentaDestino(8);
//    	tra.setIdMovOrigen(12);
//    	tra.setIdMovDestino(23);
//    	session.save(tra);
//		
//		tra = new Transferencia();
//    	tra.setIdCuentaOrigen(3);
//    	tra.setIdCuentaDestino(7);
//    	tra.setIdMovOrigen(14);
//    	tra.setIdMovDestino(52);
//    	session.save(tra);
//		
//		tra = new Transferencia();
//    	tra.setIdCuentaOrigen(4);
//    	tra.setIdCuentaDestino(6);
//    	tra.setIdMovOrigen(31);
//    	tra.setIdMovDestino(42);
//    	session.save(tra);
//		
//		tra = new Transferencia();
//    	tra.setIdCuentaOrigen(5);
//    	tra.setIdCuentaDestino(5);
//    	tra.setIdMovOrigen(51);
//    	tra.setIdMovDestino(22);
//    	session.save(tra);
//		
//		tra = new Transferencia();
//    	tra.setIdCuentaOrigen(6);
//    	tra.setIdCuentaDestino(4);
//    	tra.setIdMovOrigen(31);
//    	tra.setIdMovDestino(42);
//    	session.save(tra);
//		
//		tra = new Transferencia();
//    	tra.setIdCuentaOrigen(7);
//    	tra.setIdCuentaDestino(3);
//    	tra.setIdMovOrigen(14);
//    	tra.setIdMovDestino(42);
//    	session.save(tra);
//		
//		tra = new Transferencia();
//    	tra.setIdCuentaOrigen(8);
//    	tra.setIdCuentaDestino(2);
//    	tra.setIdMovOrigen(21);
//    	tra.setIdMovDestino(52);
//    	session.save(tra);
//		
//		tra = new Transferencia();
//    	tra.setIdCuentaOrigen(9);
//    	tra.setIdCuentaDestino(1);
//    	tra.setIdMovOrigen(21);
//    	tra.setIdMovDestino(52);
//    	session.save(tra);
//		
//		tra = new Transferencia();
//    	tra.setIdCuentaOrigen(1);
//    	tra.setIdCuentaDestino(2);
//    	tra.setIdMovOrigen(11);
//    	tra.setIdMovDestino(12);
//    	session.save(tra);
//    	//////////////////////////////////////////////////
//    	
//    	Usuario usuario = new Usuario();
//    	usuario.setEstado(true);
//    	usuario.setFechaAlta(new Date());
//    	usuario.setTipoUsuario("cliente");
//    	usuario.setPass("1234");
//    	usuario.setUserName("juancho");
//    	session.save(usuario);
//
//    	usuario = new Usuario();
//    	usuario.setEstado(true);
//    	usuario.setFechaAlta(new Date());
//    	usuario.setTipoUsuario("cliente");
//    	usuario.setPass("cliente");
//    	usuario.setUserName("cliente");
//    	session.save(usuario);
//
//    	usuario = new Usuario();
//    	usuario.setEstado(true);
//    	usuario.setFechaAlta(new Date());
//    	usuario.setTipoUsuario("cliente");
//    	usuario.setPass("54321");
//    	usuario.setUserName("roque");
//    	session.save(usuario);
//
//    	usuario = new Usuario();
//    	usuario.setEstado(true);
//    	usuario.setFechaAlta(new Date());
//    	usuario.setTipoUsuario("cliente");
//    	usuario.setPass("54321");
//    	usuario.setUserName("robertogomezbolanios");
//    	session.save(usuario);
//
//    	usuario = new Usuario();
//    	usuario.setEstado(true);
//    	usuario.setFechaAlta(new Date());
//    	usuario.setTipoUsuario("cliente");
//    	usuario.setPass("987654321");
//    	usuario.setUserName("elchavo");
//    	session.save(usuario);
//
//    	usuario = new Usuario();
//    	usuario.setEstado(true);
//    	usuario.setFechaAlta(new Date());
//    	usuario.setTipoUsuario("admin");
//    	usuario.setPass("admin");
//    	usuario.setUserName("admin");
//    	session.save(usuario);
//
//    	usuario = new Usuario();
//    	usuario.setEstado(true);
//    	usuario.setFechaAlta(new Date());
//    	usuario.setTipoUsuario("cliente");
//    	usuario.setPass("nocontaban");
//    	usuario.setUserName("elchapulin");
//    	session.save(usuario);
//
//    	usuario = new Usuario();
//    	usuario.setEstado(true);
//    	usuario.setFechaAlta(new Date());
//    	usuario.setTipoUsuario("cliente");
//    	usuario.setPass("654321");
//    	usuario.setUserName("doctorchapatin");
//    	session.save(usuario);
//
//    	usuario = new Usuario();
//    	usuario.setEstado(true);
//    	usuario.setFechaAlta(new Date());
//    	usuario.setTipoUsuario("cliente");
//    	usuario.setPass("123456");
//    	usuario.setUserName("chespirito");
//    	session.save(usuario);
//
//    	usuario = new Usuario();
//    	usuario.setEstado(true);
//    	usuario.setFechaAlta(new Date());
//    	usuario.setTipoUsuario("cliente");
//    	usuario.setPass("123456");
//    	usuario.setUserName("chompiras");
//    	session.save(usuario);
//    	////////////////////////////////////////
    	
    	session.getTransaction().commit();
    	session.close();
    	sessionFactory.close();

	}
}
