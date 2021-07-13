package frgp.tusi.lab5.service;

import java.util.List;

import frgp.tusi.lab5.model.Nacionalidad;
import frgp.tusi.lab5.model.Provincia;

public interface NacionalidadService {
	public List<Nacionalidad> listar() throws Exception;
	public Nacionalidad BuscarPorID(Integer id) throws Exception;
}
