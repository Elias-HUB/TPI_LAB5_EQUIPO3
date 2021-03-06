package frgp.tusi.lab5.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import frgp.tusi.lab5.config.HibernateConfiguration;
import frgp.tusi.lab5.dao.TransferenciaDao;
import frgp.tusi.lab5.model.Transferencia;

@Repository
public class TransferenciaDaoImpl implements TransferenciaDao {

//	@Autowired
//	@Qualifier("HibernateConfigurationBean")
//	private HibernateConfiguration ch;
	
	@Override
	public List<Transferencia> listar() throws Exception {
		return null;
	}

	@Override
	public Transferencia eliminar(Transferencia transferencia) throws Exception {
		return null;
	}

	@Override
	public Transferencia actualizar(Transferencia transferencia) throws Exception {
		return null;
	}

	@Override
	public Transferencia crear(Transferencia transferencia) throws Exception {
		HibernateConfiguration ch = new HibernateConfiguration();
		Session session= ch.abrirConexion();
    	session.save(transferencia);
    	session.getTransaction().commit();
		ch.cerrarSession();
		return transferencia;
	}
}