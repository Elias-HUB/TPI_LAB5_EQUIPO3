package frgp.tusi.lab5.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.CuentaDaoImpl;
import frgp.tusi.lab5.model.Cuenta;
import frgp.tusi.lab5.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService{

//	@Autowired(required = true)
private CuentaDaoImpl cuentaDaoImpl;

public CuentaServiceImpl() {
	cuentaDaoImpl = new CuentaDaoImpl();
}

@Override
public List<Cuenta> listar() throws Exception {
	// TODO Auto-generated method stub
	return cuentaDaoImpl.listar();
}

@Override
public Cuenta eliminar(Cuenta cuenta) throws Exception {
	// TODO Auto-generated method stub
	return cuentaDaoImpl.eliminar(cuenta);		
}

@Override
public Cuenta actualizar(Cuenta cuenta) throws Exception {
	return cuentaDaoImpl.actualizar(cuenta);	
}

@Override
public Cuenta crear(Cuenta cuenta) throws Exception {
	return cuentaDaoImpl.crear(cuenta);	
}

@Override
public Cuenta buscar(int id) throws Exception {
	return cuentaDaoImpl.buscar(id);	
}
}
