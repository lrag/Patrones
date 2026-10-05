package com.curso.infraestructura.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.aplicacion.puerto.servicios.ServicioClientes;
import com.curso.dominio.Cliente;

/*
GET    /clientes/{id}
GET    /clientes
POST   /clientes
PUT    /clientes/{id}
DELETE /clientes/{id}
*/

@RestController
public class ClientesRest {

	private ServicioClientes servicioClientes;

	public ClientesRest(ServicioClientes servicioClientes) {
		super();
		this.servicioClientes = servicioClientes;
	}

	@GetMapping(path="/clientes/{login}", produces="application/json")
	public ResponseEntity<ClienteDTO> buscar(@PathVariable() String login){
		return servicioClientes
				.buscar(login)
				.map(c -> new ResponseEntity<ClienteDTO>(new ClienteDTO(c), HttpStatus.OK))
				.orElse(new ResponseEntity<ClienteDTO>(HttpStatus.NOT_FOUND));
	}

	@GetMapping(path="/clientes")
	public List<ClienteDTO> listar(){
		return servicioClientes
			.listar()
			.stream()
			.map(c -> new ClienteDTO(c))
			.toList();
	}

	@PostMapping(path="/clientes")
	public ResponseEntity<ClienteDTO> insertar(@RequestBody() ClienteDTO clienteDto){

		System.out.println("INSERTAR");
		Cliente clienteInsertado = servicioClientes.insertar(clienteDto.asCliente());
		return new ResponseEntity<ClienteDTO>(new ClienteDTO(clienteInsertado), HttpStatus.CREATED);
	}

	//@PutMapping(path="/clientes/{login}

	@DeleteMapping(path="/clientes/{login}")
	public ResponseEntity<Object> borrar(@PathVariable() String login){
		servicioClientes.borrar(login);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
