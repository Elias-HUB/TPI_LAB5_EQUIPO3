package frgp.tusi.lab5.service;

import java.util.List;

import frgp.tusi.lab5.model.Movimiento;

public interface MovimientoService {
	public List<Movimiento> listar() throws Exception;
	public List<Movimiento> listarPorIdCuenta(int idCuenta) throws Exception;
	public Movimiento eliminar(Movimiento movimiento) throws Exception;
	public Movimiento actualizar(Movimiento movimiento) throws Exception;
	public Movimiento crear(Movimiento movimiento) throws Exception;
	public Movimiento buscar(int id) throws Exception;
}
