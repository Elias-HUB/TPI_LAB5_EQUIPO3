package frgp.tusi.lab5.dao;

import java.util.List;

import frgp.tusi.lab5.model.Transferencia;

public interface TransferenciaDao {
	public List<Transferencia> listar() throws Exception;
	public Transferencia eliminar(Transferencia transferencia) throws Exception;
	public Transferencia actualizar(Transferencia transferencia) throws Exception;
	public Transferencia crear(Transferencia transferencia) throws Exception;
}
