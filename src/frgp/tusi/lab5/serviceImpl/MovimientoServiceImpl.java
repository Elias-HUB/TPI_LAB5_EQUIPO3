package frgp.tusi.lab5.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.MovimientoDaoImpl;
import frgp.tusi.lab5.modelImpl.Movimiento;
import frgp.tusi.lab5.service.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService{

//	@Autowired(required = true)
	private MovimientoDaoImpl movimientoDaoImpl;
	
	public MovimientoServiceImpl() {
		movimientoDaoImpl = new MovimientoDaoImpl();
	}
	@Override
	public List<Movimiento> listar() throws Exception {
		return movimientoDaoImpl.listar();
	}

	@Override
	public Movimiento eliminar(Movimiento movimiento) throws Exception {
		return movimientoDaoImpl.eliminar(movimiento);
	}

	@Override
	public Movimiento actualizar(Movimiento movimiento) throws Exception {
		return movimientoDaoImpl.actualizar(movimiento);
	}

	@Override
	public Movimiento crear(Movimiento movimiento) throws Exception {
		return movimientoDaoImpl.crear(movimiento);
	}

	@Override
	public Movimiento buscar(int id) throws Exception {
		return movimientoDaoImpl.buscar(id);
	}
}
