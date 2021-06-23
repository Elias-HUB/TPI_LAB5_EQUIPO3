package frgp.tusi.lab5.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;
import frgp.tusi.lab5.model.Cliente;
import frgp.tusi.lab5.model.Cuenta;
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
    	
    	List<Cuenta> cuentasCliente1 = new ArrayList<Cuenta>();
    	List<Cuenta> cuentasCliente2 = new ArrayList<Cuenta>();
    	List<Cuenta> cuentasCliente3 = new ArrayList<Cuenta>();
    	List<Cuenta> cuentasCliente4 = new ArrayList<Cuenta>();
    	List<Cuenta> cuentasCliente5 = new ArrayList<Cuenta>();
    	    	
        Cuenta cu = new Cuenta();
    	cu.setCbu(5335235);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en dólares");
    	cu.setId(1);
    	cu.setSaldo(10000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	cuentasCliente1.add(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(45728643);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(20000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);   	
    	cuentasCliente1.add(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(75427542);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(30000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	cuentasCliente2.add(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(6436343);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(10000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	cuentasCliente3.add(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(6436434);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(50000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	cuentasCliente4.add(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(2362363);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(15000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	cuentasCliente4.add(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(54754562);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(10000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	cuentasCliente4.add(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(23452346);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(10000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	cuentasCliente4.add(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(6345434);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(10000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	cuentasCliente5.add(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(2323541);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(10000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	cuentasCliente5.add(cu);
    	
    	Cliente cli = new Cliente();
    	cli.setApellido("Arias");
    	cli.setNombre("Franco");
    	cli.setDni(21412359);
    	cli.setSexo("M");
    	cli.setNacionalidad("Argentina");
    	cli.setFechaNacimiento("14/02/1980");
    	cli.setDomicilio("Java 949");    	
    	cli.setCuentas(cuentasCliente1);
    	session.save(cli);
    	
    	cli = new Cliente();
    	cli.setApellido("López");
    	cli.setNombre("Roberto");
    	cli.setDni(39359231);
    	cli.setSexo("M");
    	cli.setNacionalidad("Argentina");
    	cli.setFechaNacimiento("10/09/1998");
    	cli.setDomicilio("Netcore 330");
    	cli.setCuentas(cuentasCliente2);
    	session.save(cli);
    	
    	cli = new Cliente();
    	cli.setApellido("Suárez");
    	cli.setNombre("Jacinta");
    	cli.setDni(1325464);
    	cli.setSexo("F");
    	cli.setNacionalidad("Argentina");
    	cli.setFechaNacimiento("02/11/1944");
    	cli.setDomicilio("Javascript 99");
    	cli.setCuentas(cuentasCliente3);
    	session.save(cli);
    	
    	cli = new Cliente();
    	cli.setApellido("Rodríguez Montoya");
    	cli.setNombre("Juliana");
    	cli.setDni(95434252);
    	cli.setSexo("F");
    	cli.setNacionalidad("Paraguaya");
    	cli.setFechaNacimiento("11/08/1990");
    	cli.setDomicilio("Python");
    	cli.setCuentas(cuentasCliente4);
    	session.save(cli);
    	
    	cli = new Cliente();
    	cli.setApellido("Pérez Núñez");
    	cli.setNombre("Marcelo");
    	cli.setDni(28416423);
    	cli.setSexo("M");
    	cli.setNacionalidad("Argentina");
    	cli.setFechaNacimiento("01/01/1980");
    	cli.setDomicilio("Javascript 533");
    	cli.setCuentas(cuentasCliente5);
    	session.save(cli);
    	
    	cli = new Cliente();
    	cli.setApellido("López");
    	cli.setNombre("Samantha");
    	cli.setDni(95454877);
    	cli.setSexo("F");
    	cli.setNacionalidad("Venezolana");
    	cli.setFechaNacimiento("25/09/1988");
    	cli.setDomicilio("React 3304");
    	session.save(cli);
    	
    	cli = new Cliente();
    	cli.setApellido("García");
    	cli.setNombre("Francisco");
    	cli.setDni(25465442);
    	cli.setSexo("M");
    	cli.setNacionalidad("Argentina");
    	cli.setFechaNacimiento("08/01/1980");
    	cli.setDomicilio("Angular 4664");
    	session.save(cli);
    	
    	cli = new Cliente();
    	cli.setApellido("Correa");
    	cli.setNombre("Pepe");
    	cli.setDni(21634868);
    	cli.setSexo("M");
    	cli.setNacionalidad("Argentina");
    	cli.setFechaNacimiento("27/03/1978");
    	cli.setDomicilio("VueJs 953");
    	session.save(cli);
    	
    	cli = new Cliente();
    	cli.setApellido("Gómez Bolaños");
    	cli.setNombre("Roberto");
    	cli.setDni(95345678);
    	cli.setSexo("M");
    	cli.setNacionalidad("Mexicana");
    	cli.setFechaNacimiento("21/02/1929");
    	cli.setDomicilio("La vecindad 933");
    	session.save(cli);
    	
    	cli = new Cliente();
    	cli.setApellido("Robertson");
    	cli.setNombre("Ashley");
    	cli.setDni(95064213);
    	cli.setSexo("F");
    	cli.setNacionalidad("Estadounidense");
    	cli.setFechaNacimiento("01/02/1990");
    	cli.setDomicilio("");
    	session.save(cli);
    	
    	//////////////////////////////////////////////////
    	Usuario usuario = new Usuario();
    	usuario.setEstado(true);
//        String formattedDate = dtf.format(dateObj);
    	usuario.setFechaAlta(dateObj);
    	usuario.setIdTipoUsuario(1);
    	usuario.setPass("1234");
    	
    	session.save(usuario);
    	
    	//Se hace un new por cada nuevo usuario que se quiere agregar
    	usuario = new Usuario();
    	usuario.setEstado(true);
    	usuario.setFechaAlta(dateObj);
    	usuario.setIdTipoUsuario(1);
    	usuario.setPass("1234");
    	
    	session.save(usuario);    	
    	
    	session.getTransaction().commit();
    	session.close();
    	sessionFactory.close();

	}
}
