package frgp.tusi.lab5.dao;

import java.util.List;

import frgp.tusi.lab5.modelImpl.Cliente;
import frgp.tusi.lab5.modelImpl.Usuario;

public interface ClienteDao {
	public List<Cliente> listar() throws Exception;
	public Cliente eliminar(Cliente cliente) throws Exception;
	public Cliente actualizar(Cliente cliente) throws Exception;
	public Cliente crear(Cliente cliente) throws Exception;
	public Cliente buscarPorDni(Integer dni) throws Exception;
}