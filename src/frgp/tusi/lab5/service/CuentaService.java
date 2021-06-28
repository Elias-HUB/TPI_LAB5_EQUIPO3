package frgp.tusi.lab5.service;

import java.util.List;

import frgp.tusi.lab5.model.Cuenta;

public interface CuentaService {
	public List<Cuenta> listar() throws Exception;
	public Cuenta eliminar(Cuenta cuenta) throws Exception;
	public Cuenta actualizar(Cuenta cuenta) throws Exception;
	public Cuenta crear(Cuenta cuenta) throws Exception;
	public Cuenta buscar(int id) throws Exception;
}
