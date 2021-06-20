package frgp.tusi.lab5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.dao.CuentaDao;

@Service
public class CuentaService {

//	@Autowired(required = true)
	private CuentaDao cuentaDao;
}
