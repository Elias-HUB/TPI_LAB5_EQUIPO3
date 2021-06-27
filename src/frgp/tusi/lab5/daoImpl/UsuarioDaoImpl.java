package frgp.tusi.lab5.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import frgp.tusi.lab5.modelImpl.Usuario;

public class UsuarioDaoImpl {
	
	private Session session;
	private SessionFactory sessionFactory;
	public void init() {
		
		Configuration configuration = new Configuration();
		configuration.configure();	
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		this.session = sessionFactory.openSession();
		
	}
	
	
	public Usuario buscar(String username, String password) {
		String query = "SELECT u from USUARIO u WHERE u.userName = '" + username + "' and u.password = '" + password + "'";
		session.beginTransaction(); 
		Usuario usuario = (Usuario)session.createQuery(query).uniqueResult();
    	session.getTransaction().commit();
    	session.close();
    	sessionFactory.close();		
		return usuario;
	}

}
