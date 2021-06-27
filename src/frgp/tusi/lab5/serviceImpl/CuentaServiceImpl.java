package frgp.tusi.lab5.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.CuentaDaoImpl;

@Service
public class CuentaServiceImpl {

//	@Autowired(required = true)
	private CuentaDaoImpl cuentaDaoImpl;
}
