package frgp.tusi.lab5.daoImpl;

import java.util.List;

import org.hibernate.Session;

import frgp.tusi.lab5.config.HibernateConfiguration;
import frgp.tusi.lab5.dao.CuentaDao;
import frgp.tusi.lab5.model.Cuenta;

public class CuentaDaoImpl implements CuentaDao {

	@Override
	public List<Cuenta> listar() throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Cuenta";
		List<Cuenta> cuentas = (List<Cuenta>) session.createQuery(query).list();
		ch.cerrarSession();
		if(cuentas == null)
			throw new Exception("No se encontraron cuentas");
		return cuentas;
	}

	@Override
	public Cuenta eliminar(Cuenta cuenta) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		cuenta.setEstado(false);
    	session.saveOrUpdate(cuenta);
    	session.getTransaction().commit();
		ch.cerrarSession();
		return cuenta;
	}

	@Override
	public Cuenta actualizar(Cuenta cuenta) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
    	session.saveOrUpdate(cuenta);
    	session.getTransaction().commit();
		ch.cerrarSession();
		return cuenta;
	}

	@Override
	public Cuenta crear(Cuenta cuenta) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
    	session.saveOrUpdate(cuenta);
    	session.getTransaction().commit();
		ch.cerrarSession();
		return cuenta;
	}

	@Override
	public Cuenta buscar(int id) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Cuenta as c WHERE c.id = " + id;
		Cuenta cuenta = (Cuenta) session.createQuery(query).uniqueResult();
		ch.cerrarSession();
		if(cuenta == null)
			throw new Exception("Cuenta inexistente");
		return cuenta;
	}

}
