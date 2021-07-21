package frgp.tusi.lab5.daoImpl;

import java.util.List;

import org.hibernate.Session;

import frgp.tusi.lab5.config.HibernateConfiguration;
import frgp.tusi.lab5.dao.EmpleadoDao;
import frgp.tusi.lab5.model.Empleado;

public class EmpleadoDaoImpl implements EmpleadoDao {
	
//	@Autowired
//	@Qualifier("HibernateConfigurationBean")
//	private HibernateConfiguration ch;
	
	@Override
	public List<Empleado> listar() throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Empleado";
		List<Empleado> empleados = (List<Empleado>) session.createQuery(query).list();
		ch.cerrarSession();
		if(empleados == null)
			throw new Exception("Usuario o Contraseña invalido.");
		return empleados;
	}

	@Override
	public Empleado eliminar(Empleado empleado) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		empleado.setEstado(false);
    	session.saveOrUpdate(empleado);
    	session.getTransaction().commit();
		ch.cerrarSession();
		return empleado;
	}

	@Override
	public Empleado actualizar(Empleado empleado) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
    	session.saveOrUpdate(empleado);
    	session.getTransaction().commit();
		ch.cerrarSession();
		return empleado;
	}

	@Override
	public Empleado crear(Empleado empleado) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
    	session.saveOrUpdate(empleado);
    	session.getTransaction().commit();
		ch.cerrarSession();
		return empleado;
	}

	@Override
	public Empleado buscarPorDni(Integer dni) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Empleado as emp WHERE emp.dni = " + dni + "";
		Empleado empleado = (Empleado) session.createQuery(query).uniqueResult();
		ch.cerrarSession();
		if(empleado == null)
			throw new Exception("Cliente inexistente.");
		return empleado;
	}
}