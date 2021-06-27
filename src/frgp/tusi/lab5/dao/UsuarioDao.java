package frgp.tusi.lab5.dao;

import frgp.tusi.lab5.modelImpl.Usuario;

public interface UsuarioDao {
	public Usuario buscar(String username, String password) throws Exception;
}
