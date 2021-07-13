package frgp.tusi.lab5.dao;

import java.util.List;

import frgp.tusi.lab5.model.Nacionalidad;

public interface NacionalidadDao {
	public List<Nacionalidad> listar() throws Exception;
	public Nacionalidad BuscarPorID(Integer id) throws Exception;
}
