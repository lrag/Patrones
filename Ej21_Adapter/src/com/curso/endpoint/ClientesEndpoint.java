package com.curso.endpoint;

import java.util.List;

import com.curso.endpoint.dto.ClienteDTO;
import com.curso.endpoint.dto.ServicioClientesAdapter;

//@RestController
public class ClientesEndpoint {
	
	private ServicioClientesAdapter servicioClientesAdapter;
	
	public ClientesEndpoint(ServicioClientesAdapter servicioClientes) {
		super();
		this.servicioClientesAdapter = servicioClientes;
	}

	//GET /clientes/{id}
	public ClienteDTO buscar(Long idCliente){
		System.out.println("BUSCAR");
		return servicioClientesAdapter.buscar(idCliente);
	}
	
	//GET /clientes
	public List<ClienteDTO> listar(){
		return servicioClientesAdapter.listar();
	}	
	
	//POST /clientes
	public ClienteDTO insertar(ClienteDTO clienteDto){
		System.out.println("INSERTAR");
		return servicioClientesAdapter.insertar(clienteDto);
	}
		
}

