package com.curso.modelo.negocio;

import java.time.Instant;
import java.util.List;

import com.curso.modelo.entidad.Cliente;
import com.curso.persistencia.RepositorioClientes;

public class ServicioClientesImplementation implements ServicioClientes {

	private RepositorioClientes clienteDao;
	
	public ServicioClientesImplementation(RepositorioClientes clienteDao) {
		super();
		this.clienteDao = clienteDao;
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		//Lógica de negocio para insertar el cliente
		//...
		clienteDao.insertar(cliente);
		return cliente;
	}
	
	//modificar...
	//borrar...
	
}
