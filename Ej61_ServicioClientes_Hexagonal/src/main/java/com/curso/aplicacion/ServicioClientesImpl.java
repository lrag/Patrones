package com.curso.aplicacion;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.aplicacion.puerto.persistencia.ClienteRepositorio;
import com.curso.aplicacion.puerto.servicios.ServicioClientes;
import com.curso.dominio.Cliente;
import com.curso.dominio.ClienteYaExisteException;

//@Service
//@Transactional
//Esto está dentro del hexágono
public class ServicioClientesImpl implements ServicioClientes {

	//ClienteRepositorio es un puerto
	private ClienteRepositorio clienteRepo;

	public ServicioClientesImpl(ClienteRepositorio clienteRepo) {
		super();
		this.clienteRepo = clienteRepo;
	}

	@Override
	//@Transactional(readOnly = true)
	public Optional<Cliente> buscar(String login) {
		return clienteRepo.buscarPorLogin(login);
	}

	@Override
	//@Transactional(readOnly = true)
	public List<Cliente> listar() {
		return clienteRepo.listar();
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		if (clienteRepo.buscarPorLogin(cliente.getLogin()).isPresent()) {
			throw new ClienteYaExisteException(cliente.getLogin());
		}
		//Lógica de negocio...
		//...
		return clienteRepo.guardar(cliente);
	}

	//public void modificar()

	@Override
	public void borrar(String login) {
		//LN...
		//...
		clienteRepo.borrarPorLogin(login);
	}

}
