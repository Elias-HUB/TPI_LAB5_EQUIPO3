package frgp.tusi.lab5.serviceImpl;

import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.TransferenciaDaoImpl;
import frgp.tusi.lab5.model.Movimiento;
import frgp.tusi.lab5.model.Transferencia;
import frgp.tusi.lab5.service.TransferenciaService;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

//	@Autowired(required = true)
	private TransferenciaDaoImpl transferenciaDaoImpl;

	@Override
	public Transferencia crear(Transferencia transferencia) throws Exception {
		Movimiento mov = new Movimiento();
		
		return null;
	}
}