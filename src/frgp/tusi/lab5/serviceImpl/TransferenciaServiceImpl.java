package frgp.tusi.lab5.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.TransferenciaDaoImpl;

@Service
public class TransferenciaServiceImpl {

//	@Autowired(required = true)
	private TransferenciaDaoImpl transferenciaDaoImpl;
}
