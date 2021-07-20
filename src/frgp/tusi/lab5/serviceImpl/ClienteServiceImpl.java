package frgp.tusi.lab5.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.dao.ClienteDao;
import frgp.tusi.lab5.daoImpl.ClienteDaoImpl;
import frgp.tusi.lab5.model.Cliente;
import frgp.tusi.lab5.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	
	private ClienteDaoImpl clienteDaoImpl;
	//@Autowired
	public ClienteServiceImpl() {
		clienteDaoImpl = new ClienteDaoImpl();
	}

	@Override
	public List<Cliente> listar() throws Exception {		
		return clienteDaoImpl.listar();
	}

	@Override
	public Cliente eliminar(Cliente cliente) throws Exception {
		return clienteDaoImpl.eliminar(cliente);		
	}

	@Override
	public Cliente actualizar(Cliente cliente) throws Exception {
		return clienteDaoImpl.actualizar(cliente);
	}

	@Override
	public Cliente crear(Cliente cliente) throws Exception {
		return clienteDaoImpl.crear(cliente);
	}

	@Override
	public Cliente buscarPorDni(Integer dni) throws Exception {
		return clienteDaoImpl.buscarPorDni(dni);		
	}
}
