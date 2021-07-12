package frgp.tusi.lab5.service;

import frgp.tusi.lab5.model.TipoMovimiento;

public interface TipoMovimientoService {
	public TipoMovimiento buscar(int id) throws Exception;
	public TipoMovimiento buscar(String descripcion) throws Exception;
}
