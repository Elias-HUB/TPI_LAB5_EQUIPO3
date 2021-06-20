package frgp.tusi.lab5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.dao.EmpleadoDao;

@Service
public class EmpleadoService {

//	@Autowired(required = true)
	private EmpleadoDao empleadoDao;
}
