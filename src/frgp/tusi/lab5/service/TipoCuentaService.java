package frgp.tusi.lab5.service;

import frgp.tusi.lab5.model.TipoCuenta;

public interface TipoCuentaService {
	public TipoCuenta buscar(String descripcion) throws Exception;
}
