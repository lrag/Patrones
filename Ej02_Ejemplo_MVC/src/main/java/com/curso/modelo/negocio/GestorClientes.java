package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.RepositorioClientes;

@Service
public class GestorClientes {

	@Autowired
	private RepositorioClientes repositorioClientes;
	
	public GestorClientes() {
		super();
		System.out.println("Creando una istancia de GestorClientes");
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void insertar(Cliente cliente) {
		//comprobar la direccion del cliente
		//asociarle una sucursal
		//asociarle un comercial que tenga pocos clientes
		//enviar un correo electrónico de bievenida
		//insertar el cliente
		repositorioClientes.save(cliente);
	}
	
	@Transactional
	public void modificar(Cliente cliente) {
		//LN...
		repositorioClientes.save(cliente);
	}
	
	@Transactional
	public void borrar(Cliente cliente) {
		//LN...
		repositorioClientes.delete(cliente);
	}		
	
}








