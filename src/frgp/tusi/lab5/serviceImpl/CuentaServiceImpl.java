package frgp.tusi.lab5.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.CuentaDaoImpl;
import frgp.tusi.lab5.daoImpl.TipoMovimientoDaoImpl;
import frgp.tusi.lab5.model.Cuenta;
import frgp.tusi.lab5.model.Movimiento;
import frgp.tusi.lab5.model.TipoMovimiento;
import frgp.tusi.lab5.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService{

//	@Autowired(required = true)
private CuentaDaoImpl cuentaDaoImpl;
private TipoMovimientoDaoImpl tipoMovimientoDaoImpl;

public CuentaServiceImpl() {
	cuentaDaoImpl = new CuentaDaoImpl();
	tipoMovimientoDaoImpl = new TipoMovimientoDaoImpl();
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
	Movimiento mov = new Movimiento();
	TipoMovimiento tipoMov = tipoMovimientoDaoImpl.buscar(1);
	mov.setTipoMovimiento(tipoMov);
	mov.setImporte(10000);
	mov.setDetalle("Alta");
	mov.setEstado(true);
	mov.setFecha(new Date());
	mov.setFechaUltimaModificacion(new Date());
	
	return cuentaDaoImpl.crear(cuenta);	
}

@Override
public Cuenta buscar(String cbu) throws Exception {
	return cuentaDaoImpl.buscar(cbu);	
}
}
