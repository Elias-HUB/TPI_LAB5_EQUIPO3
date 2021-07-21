package frgp.tusi.lab5.daoImpl;

import java.util.List;

import org.hibernate.Session;

import frgp.tusi.lab5.config.HibernateConfiguration;
import frgp.tusi.lab5.dao.CuentaDao;
import frgp.tusi.lab5.model.Cuenta;

public class CuentaDaoImpl implements CuentaDao {
	
//	@Autowired
//	@Qualifier("HibernateConfigurationBean")
//	private HibernateConfiguration ch;

	@Override
	public List<Cuenta> listar() throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Cuenta where estado = 1 order by id asc";
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
	public Cuenta buscar(String cbu) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Cuenta as c WHERE c.cbu = " + cbu;
		Cuenta cuenta = (Cuenta) session.createQuery(query).uniqueResult();
		ch.cerrarSession();
		if(cuenta == null)
			throw new Exception("Cuenta inexistente");
		return cuenta;
	}

	public Cuenta buscaPorId(Integer idCli) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Cuenta as c WHERE c.id = " + idCli;
		Cuenta cuenta = (Cuenta) session.createQuery(query).uniqueResult();
		ch.cerrarSession();
		if(cuenta == null)
			throw new Exception("Cuenta inexistente");
		return cuenta;
	}
	
	public List<Cuenta> buscarCantidadCuentas(Integer idCli) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Cuenta where estado = 1 and id_cliente = " + idCli;
		List<Cuenta> cuentas = (List<Cuenta>) session.createQuery(query).list();
		ch.cerrarSession();
		if(cuentas == null)
			throw new Exception("Cuenta inexistente.");
		return cuentas;
	}
}