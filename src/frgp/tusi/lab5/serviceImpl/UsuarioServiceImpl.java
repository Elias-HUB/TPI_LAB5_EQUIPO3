package frgp.tusi.lab5.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.UsuarioDaoImpl;
import frgp.tusi.lab5.modelImpl.Usuario;
import frgp.tusi.lab5.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService{

//	@Autowired(required = true)
	private UsuarioDaoImpl usuarioDaoImpl;

	@Override
	public Usuario buscarUsuario(String username, String password) throws Exception {
		usuarioDaoImpl = new UsuarioDaoImpl();
		return usuarioDaoImpl.buscar(username, password);
	}

	@Override
	public Usuario crearUsuario(String username, String tipoUsuario, Integer idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario eliminarUsuario(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
