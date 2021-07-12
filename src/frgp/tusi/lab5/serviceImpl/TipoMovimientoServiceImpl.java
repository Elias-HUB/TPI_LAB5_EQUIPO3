package frgp.tusi.lab5.serviceImpl;

import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.TipoMovimientoDaoImpl;
import frgp.tusi.lab5.model.TipoMovimiento;
import frgp.tusi.lab5.service.TipoMovimientoService;

@Service
public class TipoMovimientoServiceImpl implements TipoMovimientoService{

	private TipoMovimientoDaoImpl tipoMovimientoDaoImpl;
	
	@Override
	public TipoMovimiento buscar(int id) throws Exception {
		return tipoMovimientoDaoImpl.buscar(id);
	}

	@Override
	public TipoMovimiento buscar(String descripcion) throws Exception {
		return tipoMovimientoDaoImpl.buscar(descripcion);
	}


}