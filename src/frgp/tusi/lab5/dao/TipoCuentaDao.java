package frgp.tusi.lab5.dao;

import frgp.tusi.lab5.model.TipoCuenta;

public interface TipoCuentaDao {
	public TipoCuenta buscar(String descripcion) throws Exception;
}
