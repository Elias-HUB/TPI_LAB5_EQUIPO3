package frgp.tusi.lab5.daoImpl;

import java.util.List;

import org.hibernate.Session;

import frgp.tusi.lab5.config.HibernateConfiguration;
import frgp.tusi.lab5.dao.MovimientoDao;
import frgp.tusi.lab5.model.Cuenta;
import frgp.tusi.lab5.model.Movimiento;

public class MovimientoDaoImpl implements MovimientoDao{

	@Override
	public List<Movimiento> listar() throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Movimiento";
		List<Movimiento> movimientos = (List<Movimiento>) session.createQuery(query).list();
		ch.cerrarSession();
		if(movimientos == null)
			throw new Exception("No se encontraron cuentas");
		return movimientos;
	}
	
	@Override
	public List<Movimiento> listarPorIdCuenta(int idCuenta) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Movimiento WHERE id_cuenta = " + idCuenta;
		List<Movimiento> movimientos = (List<Movimiento>) session.createQuery(query).list();
		ch.cerrarSession();
		if(movimientos == null)
			throw new Exception("No se encontraron cuentas");
		return movimientos;
	}

	@Override
	public Movimiento eliminar(Movimiento movimiento) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		movimiento.setEstado(false);
    	session.saveOrUpdate(movimiento);
    	session.getTransaction().commit();
		ch.cerrarSession();
		return movimiento;
	}

	@Override
	public Movimiento actualizar(Movimiento movimiento) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
    	session.saveOrUpdate(movimiento);
    	session.getTransaction().commit();
		ch.cerrarSession();
		return movimiento;
	}

	@Override
	public Movimiento crear(Movimiento movimiento) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
    	session.saveOrUpdate(movimiento);
    	session.getTransaction().commit();
		ch.cerrarSession();
		return movimiento;
	}

	@Override
	public Movimiento buscar(int id) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Movimiento as c WHERE c.id = " + id;
		Movimiento movimiento = (Movimiento) session.createQuery(query).uniqueResult();
		ch.cerrarSession();
		if(movimiento == null)
			throw new Exception("Movimiento inexistente");
		return movimiento;
	}

}
