package frgp.tusi.lab5.serviceImpl;

import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.TipoCuentaDaoImpl;
import frgp.tusi.lab5.model.TipoCuenta;
import frgp.tusi.lab5.service.TipoCuentaService;

@Service
public class TipoCuentaServiceImpl implements TipoCuentaService{

	private TipoCuentaDaoImpl tipoCuentaDaoImpl;
	public TipoCuentaServiceImpl() {
		tipoCuentaDaoImpl = new TipoCuentaDaoImpl();
	}

	@Override
	public TipoCuenta buscar(String descripcion) throws Exception {
		return tipoCuentaDaoImpl.buscar(descripcion);
	}


}