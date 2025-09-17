package com.curso.modelo.negocio;

import java.util.List;

import com.curso.modelo.entidad.Cliente;

public interface ServicioClientes {

	Cliente insertar(Cliente cliente);
	Cliente buscar(Long idCliente);
	List<Cliente> listar();

}