package frgp.tusi.lab5.daoImpl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import frgp.tusi.lab5.config.HibernateConfiguration;
import frgp.tusi.lab5.dao.UsuarioDao;
import frgp.tusi.lab5.model.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	
//	@Autowired
//	@Qualifier("HibernateConfigurationBean")
//	private HibernateConfiguration ch;
	
	public Usuario buscar(String username, String password) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Usuario as u WHERE u.userName = '" + username + "' and u.pass = '" + password + "'";
		Usuario usuario = (Usuario) session.createQuery(query).uniqueResult();
		ch.cerrarSession();
		if(usuario == null)
			throw new Exception("Usuario o Contraseņa invalido.");		
		return usuario;
	}

	@Override
	public Usuario eliminar(Usuario usuario) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
        usuario.setEstado(false);
    	session.saveOrUpdate(usuario);
    	session.getTransaction().commit();
		ch.cerrarSession();
		return usuario;
	}

	@Override
	public Usuario buscarPorUsuario(String username) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
		String query = "FROM Usuario as u WHERE u.userName = '" + username + "'";
		Usuario usuario = (Usuario) session.createQuery(query).uniqueResult();
		ch.cerrarSession();
		if(usuario == null)
			throw new Exception("");
		return usuario;
	}
}