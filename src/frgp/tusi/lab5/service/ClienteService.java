package frgp.tusi.lab5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.dao.ClienteDao;

@Service
public class ClienteService {
	
//	@Autowired(required = true)
	private ClienteDao clienteDao;

}
