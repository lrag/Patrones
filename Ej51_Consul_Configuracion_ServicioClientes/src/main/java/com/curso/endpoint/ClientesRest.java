package com.curso.endpoint;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.endpoint.dto.ClienteDTO;
import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.GestorClientes;
import com.curso.modelo.persistencia.ClienteRepositorio;

@RestController
public class ClientesRest {

	private GestorClientes gestorClientes;
	private ClienteRepositorio clienteRepo;
	
	public ClientesRest(GestorClientes gestorClientes, ClienteRepositorio clienteRepo) {
		super();
		this.gestorClientes = gestorClientes;
		this.clienteRepo = clienteRepo;
	}

	@GetMapping(path="/clientes/{login}")
	public ResponseEntity<ClienteDTO> buscar(@PathVariable("login") String login){
		return clienteRepo
				.findByLogin(login)
				.map(c -> new ResponseEntity<ClienteDTO>(new ClienteDTO(c), HttpStatus.OK))
				.orElse(new ResponseEntity<ClienteDTO>(HttpStatus.NOT_FOUND));
	}

	@GetMapping(path="/clientes")
	public List<ClienteDTO> listar(){
		return clienteRepo.findAll().stream().map(c -> new ClienteDTO(c)).collect(Collectors.toList());
	}	
	
	@PostMapping(path="/clientes")
	public ResponseEntity<ClienteDTO> insertar(@RequestBody() ClienteDTO clienteDto){
		Cliente clienteInsertado = gestorClientes.insertar(clienteDto.asCliente());
		return new ResponseEntity<ClienteDTO>(new ClienteDTO(clienteInsertado), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path="/clientes/{login}")
	public ResponseEntity<Object> borrar(@PathVariable() String login){
		gestorClientes.borrar(login);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
