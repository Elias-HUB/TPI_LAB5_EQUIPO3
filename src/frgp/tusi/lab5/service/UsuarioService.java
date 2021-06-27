package frgp.tusi.lab5.service;

import java.util.List;

import frgp.tusi.lab5.modelImpl.Usuario;

public interface UsuarioService {
	
	public Usuario buscarUsuario(String username, String password);
	public Usuario crearUsuario(String username, String tipoUsuario, Integer idCliente);
	public Usuario eliminarUsuario(String username);
	public List<Usuario> listarUsuarios();
}
