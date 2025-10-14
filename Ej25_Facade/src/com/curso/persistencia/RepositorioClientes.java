package com.curso.persistencia;

import java.util.List;

import com.curso.modelo.entidad.Cliente;

public interface RepositorioClientes {

	void insertar(Cliente cliente);
	void modificar(Cliente cliente);
	void borrar(Long idCliente);
	Cliente buscar(Long idCliente);
	List<Cliente> listar();
	
}
