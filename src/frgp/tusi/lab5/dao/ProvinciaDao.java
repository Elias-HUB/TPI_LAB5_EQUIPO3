package frgp.tusi.lab5.dao;

import java.util.List;

import frgp.tusi.lab5.model.Provincia;

public interface ProvinciaDao {
	public List<Provincia> listar() throws Exception;
	public Provincia BuscarPorID(Integer id) throws Exception;
}
