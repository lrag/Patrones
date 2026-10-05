package com.curso.aplicacion.puerto.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.dominio.Cliente;

@Transactional
public interface ServicioClientes {

	@Transactional(readOnly = true)
	Optional<Cliente> buscar(String login);
	@Transactional(readOnly = true)
	List<Cliente> listar();
	Cliente insertar(Cliente cliente);
	void borrar(String login);

}
