package frgp.tusi.lab5.service;

import java.util.List;

import frgp.tusi.lab5.modelImpl.Cliente;

public interface ClienteService {
	public List<Cliente> listar() throws Exception;
	public Cliente eliminar(Cliente cliente) throws Exception;
	public Cliente actualizar(Cliente cliente) throws Exception;
	public Cliente crear(Cliente cliente) throws Exception;
	public Cliente buscarPorDni(Integer Dni) throws Exception;
}
