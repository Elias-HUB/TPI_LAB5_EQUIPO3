package frgp.tusi.lab5.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.EmpleadoDaoImpl;
import frgp.tusi.lab5.model.Empleado;
import frgp.tusi.lab5.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoDaoImpl empleadoDaoImpl;
	
	public EmpleadoServiceImpl() {
		
	}

	@Override
	public List<Empleado> listar() throws Exception {
		return empleadoDaoImpl.listar();
	}
	
	@Override
	public Empleado eliminar(Empleado empleado) throws Exception {
		return empleadoDaoImpl.eliminar(empleado);
	}
	
	@Override
	public Empleado actualizar(Empleado empleado) throws Exception {
		return empleadoDaoImpl.actualizar(empleado);
	}
	
	@Override
	public Empleado crear(Empleado empleado) throws Exception {
		return empleadoDaoImpl.crear(empleado);
	}

	@Override
	public Empleado buscarPorDni(Integer dni) throws Exception {
		return empleadoDaoImpl.buscarPorDni(dni);
	}
}
