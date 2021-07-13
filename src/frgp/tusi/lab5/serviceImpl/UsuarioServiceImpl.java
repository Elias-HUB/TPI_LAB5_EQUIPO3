package frgp.tusi.lab5.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.UsuarioDaoImpl;
import frgp.tusi.lab5.model.Usuario;
import frgp.tusi.lab5.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService{

//	@Autowired(required = true)
	private UsuarioDaoImpl usuarioDaoImpl;
	
	public UsuarioServiceImpl() {
		usuarioDaoImpl = new UsuarioDaoImpl();
	}

	@Override
	public Usuario buscarUsuario(String username, String password) throws Exception {
		return usuarioDaoImpl.buscar(username, password);
	}

	@Override
	public Usuario crearUsuario(String username, String tipoUsuario, Integer idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario eliminarUsuario(Usuario usuario) throws Exception {
		usuarioDaoImpl.eliminar(usuario);
		return null;
	}

	@Override
	public Usuario buscarPorUsuario(String username) throws Exception {
		return usuarioDaoImpl.buscarPorUsuario(username);
	}

}
