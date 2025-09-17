package com.curso.modelo.negocio;

import java.time.Instant;
import java.util.List;

import com.curso.modelo.entidad.Cliente;
import com.curso.persistencia.ClienteDao;

public class ServicioClientesImplementation implements ServicioClientes {

	private ClienteDao clienteDao;
	
	public ServicioClientesImplementation(ClienteDao clienteDao) {
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
	
	@Override
	public Cliente buscar(Long idCliente) {
		return clienteDao.buscar(idCliente);
	}
	
	@Override
	public List<Cliente> listar() {
		return clienteDao.listar();
	}
	
}
