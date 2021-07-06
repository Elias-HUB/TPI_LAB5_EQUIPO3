package frgp.tusi.lab5.service;

import java.util.List;

import frgp.tusi.lab5.model.Usuario;

public interface UsuarioService {	
	public Usuario buscarUsuario(String username, String password) throws Exception;
	public Usuario crearUsuario(String username, String tipoUsuario, Integer idCliente) throws Exception;
	public Usuario eliminarUsuario(Usuario usuario) throws Exception;
	public List<Usuario> listarUsuarios();
}
