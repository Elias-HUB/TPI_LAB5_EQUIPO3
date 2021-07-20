package frgp.tusi.lab5.daoImpl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import frgp.tusi.lab5.config.HibernateConfiguration;
import frgp.tusi.lab5.dao.TipoCuentaDao;
import frgp.tusi.lab5.model.TipoCuenta;

@Repository
public class TipoCuentaDaoImpl implements TipoCuentaDao{

	
	@Override
	public TipoCuenta buscar(String descripcion) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM TipoCuenta as c WHERE c.descripcion = '" + descripcion+"'";
		TipoCuenta tipoCuenta = (TipoCuenta) session.createQuery(query).uniqueResult();
		ch.cerrarSession();
		if(tipoCuenta == null)
			throw new Exception("Tipo Cuenta inexistente");
		return tipoCuenta;
	}
}
