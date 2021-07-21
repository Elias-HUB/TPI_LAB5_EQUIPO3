package frgp.tusi.lab5.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.TipoCuentaDaoImpl;
import frgp.tusi.lab5.model.TipoCuenta;
import frgp.tusi.lab5.service.TipoCuentaService;

@Service
public class TipoCuentaServiceImpl implements TipoCuentaService{

	@Autowired
	private TipoCuentaDaoImpl tipoCuentaDaoImpl;
	public TipoCuentaServiceImpl() {}

	@Override
	public TipoCuenta buscar(String descripcion) throws Exception {
		return tipoCuentaDaoImpl.buscar(descripcion);
	}
}