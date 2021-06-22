package frgp.tusi.lab5.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

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
    	
//    	Cliente cli = new Cliente();
//    	cli.setApellido("Arias");
//    	cli.setNombre("Franco");
//    	cli.setDni(1);
//    	cli.setSexo("M");
//    	cli.setNacionalidad("Argentina");
//    	cli.setFechaNacimiento("");
//    	cli.setDomicilio("");
//    	cli.setFechaAlta(formattedDate);
//    	cli.setFechaUltimaModificaion(formattedDate);
//    	session.save(cli);
//    	
//    	cli = new Cliente();
//    	cli.setApellido("");
//    	cli.setNombre("Franco");
//    	cli.setDni(1);
//    	cli.setSexo("M");
//    	cli.setNacionalidad("Argentina");
//    	cli.setFechaNacimiento("");
//    	cli.setDomicilio("");
//    	cli.setFechaAlta(formattedDate);
//    	cli.setFechaUltimaModificaion(formattedDate);
//    	session.save(cli);
//    	
//    	cli = new Cliente();
//    	cli.setApellido("");
//    	cli.setNombre("Franco");
//    	cli.setDni(1);
//    	cli.setSexo("M");
//    	cli.setNacionalidad("Argentina");
//    	cli.setFechaNacimiento("");
//    	cli.setDomicilio("");
//    	cli.setFechaAlta(formattedDate);
//    	cli.setFechaUltimaModificaion(formattedDate);
//    	session.save(cli);
//    	
//    	cli = new Cliente();
//    	cli.setApellido("");
//    	cli.setNombre("Franco");
//    	cli.setDni(1);
//    	cli.setSexo("M");
//    	cli.setNacionalidad("Argentina");
//    	cli.setFechaNacimiento("");
//    	cli.setDomicilio("");
//    	cli.setFechaAlta(formattedDate);
//    	cli.setFechaUltimaModificaion(formattedDate);
//    	session.save(cli);
//    	
//    	cli = new Cliente();
//    	cli.setApellido("");
//    	cli.setNombre("Franco");
//    	cli.setDni(1);
//    	cli.setSexo("M");
//    	cli.setNacionalidad("Argentina");
//    	cli.setFechaNacimiento("");
//    	cli.setDomicilio("");
//    	cli.setFechaAlta(formattedDate);
//    	cli.setFechaUltimaModificaion(formattedDate);
//    	session.save(cli);
//    	
//    	cli = new Cliente();
//    	cli.setApellido("");
//    	cli.setNombre("Franco");
//    	cli.setDni(1);
//    	cli.setSexo("M");
//    	cli.setNacionalidad("Argentina");
//    	cli.setFechaNacimiento("");
//    	cli.setDomicilio("");
//    	cli.setFechaAlta(formattedDate);
//    	cli.setFechaUltimaModificaion(formattedDate);
//    	session.save(cli);
//    	
//    	cli = new Cliente();
//    	cli.setApellido("");
//    	cli.setNombre("Franco");
//    	cli.setDni(1);
//    	cli.setSexo("M");
//    	cli.setNacionalidad("Argentina");
//    	cli.setFechaNacimiento("");
//    	cli.setDomicilio("");
//    	cli.setFechaAlta(formattedDate);
//    	cli.setFechaUltimaModificaion(formattedDate);
//    	session.save(cli);
//    	
//    	cli = new Cliente();
//    	cli.setApellido("");
//    	cli.setNombre("Franco");
//    	cli.setDni(1);
//    	cli.setSexo("M");
//    	cli.setNacionalidad("Argentina");
//    	cli.setFechaNacimiento("");
//    	cli.setDomicilio("");
//    	cli.setFechaAlta(formattedDate);
//    	cli.setFechaUltimaModificaion(formattedDate);
//    	session.save(cli);
//    	
//    	cli = new Cliente();
//    	cli.setApellido("");
//    	cli.setNombre("Franco");
//    	cli.setDni(1);
//    	cli.setSexo("M");
//    	cli.setNacionalidad("Argentina");
//    	cli.setFechaNacimiento("");
//    	cli.setDomicilio("");
//    	cli.setFechaAlta(formattedDate);
//    	cli.setFechaUltimaModificaion(formattedDate);
//    	session.save(cli);
//    	
//    	cli = new Cliente();
//    	cli.setApellido("");
//    	cli.setNombre("Franco");
//    	cli.setDni(1);
//    	cli.setSexo("M");
//    	cli.setNacionalidad("Argentina");
//    	cli.setFechaNacimiento("");
//    	cli.setDomicilio("");
//    	cli.setFechaAlta(formattedDate);
//    	cli.setFechaUltimaModificaion(formattedDate);
//    	session.save(cli);
    	
    	//////////////////////////////////////////////////
    	
    	Cuenta cu = new Cuenta();
    	cu.setCbu(000);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(10000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	session.save(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(000);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(10000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	session.save(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(000);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(10000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	session.save(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(000);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(10000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	session.save(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(000);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(10000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	session.save(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(000);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(10000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	session.save(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(000);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(10000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	session.save(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(000);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(10000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	session.save(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(000);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(10000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	session.save(cu);
    	
    	cu = new Cuenta();
    	cu.setCbu(000);
    	cu.setNroCuenta(0);
    	cu.setNombre("Caja de ahorro en pesos");
    	cu.setId(1);
    	cu.setSaldo(10000);
    	cu.setEstado(true);
    	cu.setFechaAlta(formattedDate);
    	cu.setFechaUltimaModificacion(formattedDate);
    	session.save(cu);
    	//////////////////////////////////////////////////
    	
    	
    	
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
