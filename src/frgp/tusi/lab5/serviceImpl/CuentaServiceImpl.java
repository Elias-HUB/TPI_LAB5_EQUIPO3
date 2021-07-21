package frgp.tusi.lab5.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.CuentaDaoImpl;
import frgp.tusi.lab5.model.Cuenta;
import frgp.tusi.lab5.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	private CuentaDaoImpl cuentaDaoImpl;
	
	public CuentaServiceImpl() {}

	@Override
	public List<Cuenta> listar() throws Exception {
		return cuentaDaoImpl.listar();
	}

	@Override
	public Cuenta eliminar(Cuenta cuenta) throws Exception {
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
	public Cuenta buscar(String cbu) throws Exception {
		return cuentaDaoImpl.buscar(cbu);
	}

	@Override
	public Cuenta buscaPorId(Integer idCli) throws Exception {
		return cuentaDaoImpl.buscaPorId(idCli);
	}

	public List<Cuenta> buscarCantidadCuentas(Integer idCli) throws Exception {
		return cuentaDaoImpl.buscarCantidadCuentas(idCli);
	}
}