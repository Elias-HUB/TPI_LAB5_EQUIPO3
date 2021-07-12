package frgp.tusi.lab5.dao;

import java.util.List;

import frgp.tusi.lab5.model.Cuenta;

public interface CuentaDao {
	public List<Cuenta> listar() throws Exception;
	public Cuenta eliminar(Cuenta cuenta) throws Exception;
	public Cuenta actualizar(Cuenta cuenta) throws Exception;
	public Cuenta crear(Cuenta cuenta) throws Exception;
	public Cuenta buscar(String cbu) throws Exception;
}
