package com.curso.endpoint;

import java.util.List;

import com.curso.endpoint.dto.ClienteDTO;
import com.curso.endpoint.dto.ServicioClientesAdapterFacade;

//@RestController
public class ClientesEndpoint {
	
	private ServicioClientesAdapterFacade servicioClientesAdapterFacade;
	
	public ClientesEndpoint(ServicioClientesAdapterFacade servicioClientes) {
		super();
		this.servicioClientesAdapterFacade = servicioClientes;
	}

	//GET /clientes/{id}
	public ClienteDTO buscar(Long idCliente){
		System.out.println("BUSCAR");
		return servicioClientesAdapterFacade.buscar(idCliente);
	}
	
	//GET /clientes
	public List<ClienteDTO> listar(){
		return servicioClientesAdapterFacade.listar();
	}	
	
	//POST /clientes
	public ClienteDTO insertar(ClienteDTO clienteDto){
		System.out.println("INSERTAR");
		return servicioClientesAdapterFacade.insertar(clienteDto);
	}
		
}

