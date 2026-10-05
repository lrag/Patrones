package com.curso.aplicacion.puerto.persistencia;

import java.util.List;
import java.util.Optional;

import com.curso.dominio.Cliente;

//Este es el puerto de persistencia para clientes
public interface ClienteRepositorio {

	Optional<Cliente> buscarPorLogin(String login);
	List<Cliente> listar();
	Cliente guardar(Cliente cliente);
	void borrarPorLogin(String login);
	long contar();

}
