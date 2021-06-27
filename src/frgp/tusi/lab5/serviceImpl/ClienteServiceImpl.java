package frgp.tusi.lab5.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.ClienteDaoImpl;

@Service
public class ClienteServiceImpl {
	
//	@Autowired(required = true)
	private ClienteDaoImpl clienteDaoImpl;

}
