package frgp.tusi.lab5.daoImpl;

import org.hibernate.Session;
import frgp.tusi.lab5.config.HibernateConfiguration;
import frgp.tusi.lab5.dao.TipoMovimientoDao;
import frgp.tusi.lab5.model.TipoMovimiento;

public class TipoMovimientoDaoImpl implements TipoMovimientoDao{

	@Override
	public TipoMovimiento buscar(int id) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM TipoMovimiento as c WHERE c.id = " + id;
		TipoMovimiento movimiento = (TipoMovimiento) session.createQuery(query).uniqueResult();
		ch.cerrarSession();
		if(movimiento == null)
			throw new Exception("TipoMovimiento inexistente");
		return movimiento;
	}
	
	@Override
	public TipoMovimiento buscar(String descripcion) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM TipoMovimiento as c WHERE c.descripcion = '" + descripcion+"'";
		TipoMovimiento tipoMovimiento = (TipoMovimiento) session.createQuery(query).uniqueResult();
		ch.cerrarSession();
		if(tipoMovimiento == null)
			throw new Exception("TipoMovimiento inexistente");
		return tipoMovimiento;
	}
}
