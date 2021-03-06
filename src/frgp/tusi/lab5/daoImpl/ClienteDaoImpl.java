package frgp.tusi.lab5.daoImpl;

import java.util.List;

import org.hibernate.Session;

import frgp.tusi.lab5.config.HibernateConfiguration;
import frgp.tusi.lab5.dao.ClienteDao;
import frgp.tusi.lab5.model.Cliente;

public class ClienteDaoImpl implements ClienteDao {
	
//	@Autowired
//	@Qualifier("HibernateConfigurationBean")
//	private HibernateConfiguration ch;

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listar() throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Cliente where estado = 1 order by id asc";
		List<Cliente> clientes = (List<Cliente>) session.createQuery(query).list();
		ch.cerrarSession();
		if(clientes == null)
			throw new Exception("Usuario o Contraseņa invalido.");
		return clientes;
	}

	@Override
	public Cliente eliminar(Cliente cliente) throws Exception {		
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
        cliente.setEstado(false);
    	session.saveOrUpdate(cliente);
    	session.getTransaction().commit();
		ch.cerrarSession();
		return cliente;
	}

	@Override
	public Cliente actualizar(Cliente cliente) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
    	session.saveOrUpdate(cliente);
    	session.getTransaction().commit();
		ch.cerrarSession();
		return cliente;
	}

	@Override
	public Cliente crear(Cliente cliente) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
    	session.save(cliente);
    	session.getTransaction().commit();
		ch.cerrarSession();
		return cliente;
	}

	@Override
	public Cliente buscarPorDni(Integer dni) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Cliente as cli WHERE cli.dni = " + dni + "";
		Cliente cliente = (Cliente) session.createQuery(query).uniqueResult();
		ch.cerrarSession();
		if(cliente == null)
			throw new Exception("Cliente inexistente.");
		return cliente;
	}
}