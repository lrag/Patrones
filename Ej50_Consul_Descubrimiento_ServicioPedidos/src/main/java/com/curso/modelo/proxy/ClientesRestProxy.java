package com.curso.modelo.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.ClienteRepositorio;

@Component
public class ClientesRestProxy {

	@Autowired private RestTemplate restTemplate;
	@Autowired private ClienteRepositorio clienteRepo;
	
	public Cliente buscar(String login){
		return clienteRepo
				.findByLogin(login)
				.orElseGet( () -> {
					System.out.println("Invocando al microservicio de clientes");
					//No estamos controlando los posibles errores al enviar la petición!!!
					
					//Cliente cliAux = restTemplate.getForEntity("http://localhost:9000/clientes/"+login, Cliente.class).getBody();
					Cliente cliAux = restTemplate.getForEntity("http://ServicioClientes/clientes/"+login, Cliente.class).getBody();
					
					System.out.println("Cliente obtenido:"+cliAux);
					clienteRepo.save(cliAux);
					return cliAux;
				});		
	}

}
