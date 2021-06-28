package frgp.tusi.lab5.dao;

import java.util.List;

import frgp.tusi.lab5.model.Empleado;

public interface EmpleadoDao {
	public List<Empleado> listar() throws Exception;

	public Empleado eliminar(Empleado empleado) throws Exception;

	public Empleado actualizar(Empleado empleado) throws Exception;

	public Empleado crear(Empleado empleado) throws Exception;

	public Empleado buscarPorDni(Integer dni) throws Exception;
}
