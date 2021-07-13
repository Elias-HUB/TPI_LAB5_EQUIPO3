package frgp.tusi.lab5.serviceImpl;

import java.util.List;

import frgp.tusi.lab5.daoImpl.NacionalidadDaoImpl;
import frgp.tusi.lab5.model.Nacionalidad;
import frgp.tusi.lab5.service.NacionalidadService;

public class NacionalidadServicesImpl implements NacionalidadService{

	private NacionalidadDaoImpl NacionalidadDaoImpl;
	public NacionalidadServicesImpl() {
		NacionalidadDaoImpl = new NacionalidadDaoImpl();
	}

	@Override
	public List<Nacionalidad> listar() throws Exception {		
		return NacionalidadDaoImpl.listar();
	}

	@Override
	public Nacionalidad BuscarPorID(Integer id) throws Exception {
		return NacionalidadDaoImpl.BuscarPorID(id);
	}

}
