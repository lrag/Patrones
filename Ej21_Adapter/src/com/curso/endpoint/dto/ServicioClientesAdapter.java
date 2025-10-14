package com.curso.endpoint.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.ServicioClientes;

public class ServicioClientesAdapter {

	private ServicioClientes servicioClientes;
	
	public ServicioClientesAdapter(ServicioClientes servicioClientes) {
		super();
		this.servicioClientes = servicioClientes;
	}

	public ClienteDTO insertar(ClienteDTO clienteDTO) {
		return getClienteDTOFrom(servicioClientes.insertar(getClienteFrom(clienteDTO)));
	}
	
	public ClienteDTO buscar(Long idCliente) {
		return getClienteDTOFrom(servicioClientes.buscar(idCliente));
	}
	
	public List<ClienteDTO> listar() {
		return servicioClientes.listar().stream()
				.map(c -> getClienteDTOFrom(c))
				.collect(Collectors.toList());
	}
	
	private Cliente getClienteFrom(ClienteDTO clienteDTO) {
		
		Cliente cAux = servicioClientes.buscar(clienteDTO.getId());
		String datosBancarios = null;
		if(cAux!=null) {
			datosBancarios = cAux.getDatosBancarios();
		}
		
		return new Cliente(
				clienteDTO.getId(),
				clienteDTO.getLogin(),
				clienteDTO.getNombre(),
				clienteDTO.getDireccion(),
				clienteDTO.getTelefono(),
				clienteDTO.getCorreoE(),
				datosBancarios
			);
	}
	
	private ClienteDTO getClienteDTOFrom(Cliente cliente) {
		return new ClienteDTO(
				cliente.getId(),
				cliente.getLogin(),
				cliente.getNombre(),
				cliente.getDireccion(),
				cliente.getTelefono(),
				cliente.getCorreoE()
			);		
	}
	
}

/*

clientes
facturas
detalles
productos

GET /clientes
{
	id:
	nombre:
	direccion:
	telefono:
}

GET /clientes/{id}
{
	id:
	nombre:
	direccion:
	telefono:
	facturas : [ {}, {}, {}]
	incidencias : [ {}, {}, {} ]
}

POST /clientes
{
	nombre:
	direccion:
	telefono:
}

PUT /clientes/{id}
{
	id:
	nombre:
	direccion:
	telefono:
}

DELETE /clientes/{id}







*/




