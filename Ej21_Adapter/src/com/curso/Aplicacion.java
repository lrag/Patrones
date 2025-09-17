package com.curso;

import com.curso.endpoint.ClientesEndpoint;
import com.curso.endpoint.dto.ClienteDTO;
import com.curso.endpoint.dto.ServicioClientesAdapter;
import com.curso.modelo.negocio.ServicioClientes;
import com.curso.modelo.negocio.ServicioClientesImplementation;
import com.curso.persistencia.ClienteDao;
import com.curso.persistencia.ClienteDaoArrayListImplementation;

public class Aplicacion {

	public static void main(String[] args) {

		ClienteDao clienteDao = new ClienteDaoArrayListImplementation();
		ServicioClientes servicioClientes = new ServicioClientesImplementation(clienteDao);
		ServicioClientesAdapter servicioClientesAdapter = new ServicioClientesAdapter(servicioClientes);
		ClientesEndpoint clientesRest = new ClientesEndpoint(servicioClientesAdapter);
		
		ClienteDTO cliente1 = new ClienteDTO(null, "login1", "Cliente 1", "Direccion 1", "123", "a@b.c");
		ClienteDTO cliente2 = new ClienteDTO(null, "login2", "Cliente 2", "Direccion 2", "123", "a@b.c");
		ClienteDTO cliente3 = new ClienteDTO(null, "login3", "Cliente 3", "Direccion 3", "123", "a@b.c");
		
		clientesRest.insertar(cliente1);
		clientesRest.insertar(cliente2);
		clientesRest.insertar(cliente3);
		
		System.out.println("===============================================");
		System.out.println(clientesRest.buscar(2l));
		
		System.out.println("===============================================");
		clientesRest.listar().forEach(System.out::println);
		
	}
	
}
