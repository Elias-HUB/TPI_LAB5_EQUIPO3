package frgp.tusi.lab5.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.MovimientoDaoImpl;

@Service
public class MovimientoServiceImpl {

//	@Autowired(required = true)
	private MovimientoDaoImpl movimientoDaoImpl;
}
