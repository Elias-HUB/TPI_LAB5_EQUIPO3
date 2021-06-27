package frgp.tusi.lab5.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.EmpleadoDaoImpl;

@Service
public class EmpleadoServiceImpl {

//	@Autowired(required = true)
	private EmpleadoDaoImpl empleadoDaoImpl;
}
