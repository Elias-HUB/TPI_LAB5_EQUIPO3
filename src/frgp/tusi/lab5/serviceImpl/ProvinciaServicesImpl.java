package frgp.tusi.lab5.serviceImpl;

import java.util.List;

import frgp.tusi.lab5.daoImpl.ProvinciaDaoImpl;
import frgp.tusi.lab5.model.Provincia;
import frgp.tusi.lab5.service.ProvinciaService;

public class ProvinciaServicesImpl implements ProvinciaService{

	private ProvinciaDaoImpl provinciaDaoImpl;
	public ProvinciaServicesImpl() {
		provinciaDaoImpl = new ProvinciaDaoImpl();
	}

	@Override
	public List<Provincia> listar() throws Exception {		
		return provinciaDaoImpl.listar();
	}

	@Override
	public Provincia BuscarPorID(Integer id) throws Exception {
		return provinciaDaoImpl.BuscarPorID(id);
	}

}
