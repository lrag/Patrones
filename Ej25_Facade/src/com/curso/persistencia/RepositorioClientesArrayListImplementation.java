package com.curso.persistencia;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.entidad.Cliente;

public class RepositorioClientesArrayListImplementation implements RepositorioClientes {
	
	private List<Cliente> clientes = new ArrayList<>();
	private Long contador = 1l;

	@Override
	public void insertar(Cliente cliente) {
		cliente.setId(contador);
		contador++;
		clientes.add(cliente);		
	}

	@Override
	public void modificar(Cliente cliente) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void borrar(Long idCliente) {
		// TODO Auto-generated method stub		
	}

	@Override
	public Cliente buscar(Long idCliente) {
		return clientes.stream()
			.filter(c -> c.getId() == idCliente)
			.findFirst()
			.orElse(null);
	}

	@Override
	public List<Cliente> listar() {		
		return clientes;
	}

}
