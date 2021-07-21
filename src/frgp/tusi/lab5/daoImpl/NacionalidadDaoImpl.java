package frgp.tusi.lab5.daoImpl;

import java.util.List;

import org.hibernate.Session;

import frgp.tusi.lab5.config.HibernateConfiguration;
import frgp.tusi.lab5.dao.NacionalidadDao;
import frgp.tusi.lab5.model.Nacionalidad;

public class NacionalidadDaoImpl implements NacionalidadDao {

//	@Autowired
//	@Qualifier("HibernateConfigurationBean")
//	private HibernateConfiguration ch;
	
	public NacionalidadDaoImpl() {}

	@SuppressWarnings("unchecked")
	@Override
	public List<Nacionalidad> listar() throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Nacionalidad order by nombre asc";
		List<Nacionalidad> Nacionalidades = (List<Nacionalidad>) session.createQuery(query).list();
		ch.cerrarSession();
		if(Nacionalidades == null)
			throw new Exception("Problemas al buscar nacionalidades.");
		return Nacionalidades;
	}

	@Override
	public Nacionalidad BuscarPorID(Integer id) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Nacionalidad WHERE id = " + id + "";
		Nacionalidad nacionalidad = (Nacionalidad) session.createQuery(query).uniqueResult();
		ch.cerrarSession();
		if(nacionalidad == null)
			throw new Exception("Nacionalidad inexistente.");
		return nacionalidad;
	}
}