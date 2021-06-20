package frgp.tusi.lab5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.tusi.lab5.dao.UsuarioDao;

@Service
public class UsuarioService {

//	@Autowired(required = true)
	private UsuarioDao usuarioDao;
}
