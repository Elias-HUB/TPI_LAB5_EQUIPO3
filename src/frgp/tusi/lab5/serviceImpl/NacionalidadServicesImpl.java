package frgp.tusi.lab5.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.NacionalidadDaoImpl;
import frgp.tusi.lab5.model.Nacionalidad;
import frgp.tusi.lab5.service.NacionalidadService;

@Service
public class NacionalidadServicesImpl implements NacionalidadService{

	@Autowired
	private NacionalidadDaoImpl NacionalidadDaoImpl;
	
	public NacionalidadServicesImpl() {}

	@Override
	public List<Nacionalidad> listar() throws Exception {		
		return NacionalidadDaoImpl.listar();
	}

	@Override
	public Nacionalidad BuscarPorID(Integer id) throws Exception {
		return NacionalidadDaoImpl.BuscarPorID(id);
	}
}
