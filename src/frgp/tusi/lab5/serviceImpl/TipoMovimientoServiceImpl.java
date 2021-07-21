package frgp.tusi.lab5.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.TipoMovimientoDaoImpl;
import frgp.tusi.lab5.model.TipoMovimiento;
import frgp.tusi.lab5.service.TipoMovimientoService;

@Service
public class TipoMovimientoServiceImpl implements TipoMovimientoService{

	@Autowired
	private TipoMovimientoDaoImpl tipoMovimientoDaoImpl;
	
	public TipoMovimientoServiceImpl() {}
	
	@Override
	public TipoMovimiento buscar(int id) throws Exception {
		return tipoMovimientoDaoImpl.buscar(id);
	}

	@Override
	public TipoMovimiento buscar(String descripcion) throws Exception {
		return tipoMovimientoDaoImpl.buscar(descripcion);
	}
}