package frgp.tusi.lab5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.dao.MovimientoDao;

@Service
public class MovimientoService {

//	@Autowired(required = true)
	private MovimientoDao movimientoDao;
}
