package com.curso.modelo.negocio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.ClienteRepositorio;

@Service
//@Scope("singleton")
@Transactional
public class GestorClientesImpl implements GestorClientes {
	
	private ClienteRepositorio clienteRepo;

	public GestorClientesImpl(ClienteRepositorio clienteRepo) {
		super();
		this.clienteRepo = clienteRepo;
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		//Lógica de negocio...
		//...
		return clienteRepo.save(cliente);
	}
	
	//public void modificar()
	
	@Override
	public void borrar(String login) {
		//LN...
		//...
		clienteRepo.deleteByLogin(login);		
	}
	
}
