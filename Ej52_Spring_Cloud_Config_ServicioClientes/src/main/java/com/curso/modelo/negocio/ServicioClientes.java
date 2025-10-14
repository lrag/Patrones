package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Cliente;

public interface ServicioClientes {

	Cliente insertar(Cliente cliente);

	void borrar(String login);

}