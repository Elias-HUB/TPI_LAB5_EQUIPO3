package frgp.tusi.lab5.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.ProvinciaDaoImpl;
import frgp.tusi.lab5.model.Provincia;
import frgp.tusi.lab5.service.ProvinciaService;

@Service
public class ProvinciaServicesImpl implements ProvinciaService{

	@Autowired
	private ProvinciaDaoImpl provinciaDaoImpl;
	
	public ProvinciaServicesImpl() {}

	@Override
	public List<Provincia> listar() throws Exception {		
		return provinciaDaoImpl.listar();
	}

	@Override
	public Provincia BuscarPorID(Integer id) throws Exception {
		return provinciaDaoImpl.BuscarPorID(id);
	}
}