package frgp.tusi.lab5.daoImpl;

import java.util.List;

import org.hibernate.Session;

import frgp.tusi.lab5.config.HibernateConfiguration;
import frgp.tusi.lab5.dao.ProvinciaDao;
import frgp.tusi.lab5.model.Cliente;
import frgp.tusi.lab5.model.Nacionalidad;
import frgp.tusi.lab5.model.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao {

	public ProvinciaDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> listar() throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Provincia";
		List<Provincia> Provincias = (List<Provincia>) session.createQuery(query).list();
		ch.cerrarSession();
		if(Provincias == null)
			throw new Exception("Problemas al buscar Provincias.");
		return Provincias;
	}

	@Override
	public Provincia BuscarPorID(Integer id) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Provincia WHERE id = " + id + "";
		Provincia provincia = (Provincia) session.createQuery(query).uniqueResult();
		ch.cerrarSession();
		if(provincia == null)
			throw new Exception("Provincia inexistente.");
		return provincia;
	}

}
