package frgp.tusi.lab5.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.daoImpl.TransferenciaDaoImpl;
import frgp.tusi.lab5.model.Transferencia;
import frgp.tusi.lab5.service.TransferenciaService;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

//	@Autowired(required = true)
	private TransferenciaDaoImpl transferenciaDaoImpl;

	@Override
	public Transferencia crear(Transferencia transferencia) throws Exception {

		return null;
	}
}
