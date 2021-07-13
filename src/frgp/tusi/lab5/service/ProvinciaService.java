package frgp.tusi.lab5.service;

import java.util.List;

import frgp.tusi.lab5.model.Provincia;

public interface ProvinciaService {
	public List<Provincia> listar() throws Exception;
	public Provincia BuscarPorID(Integer id) throws Exception;
}
