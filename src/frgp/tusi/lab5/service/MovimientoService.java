package frgp.tusi.lab5.service;

import java.util.List;

import frgp.tusi.lab5.modelImpl.Movimiento;

public interface MovimientoService {
	public List<Movimiento> listar() throws Exception;
	public Movimiento eliminar(Movimiento movimiento) throws Exception;
	public Movimiento actualizar(Movimiento movimiento) throws Exception;
	public Movimiento crear(Movimiento movimiento) throws Exception;
	public Movimiento buscar(int id) throws Exception;
}
