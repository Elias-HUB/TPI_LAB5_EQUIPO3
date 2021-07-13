package frgp.tusi.lab5.dao;

import frgp.tusi.lab5.model.Usuario;

public interface UsuarioDao {
	public Usuario buscar(String username, String password) throws Exception;
	public Usuario buscarPorUsuario(String username) throws Exception;
	public Usuario eliminar(Usuario usuario) throws Exception;
}
