package com.curso.modelo.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.curso.modelo.entidad.Cliente;

@Component
public class ClientesRestProxy {

	@Autowired
	private RestTemplate restTemplate;
	
	public Cliente buscar(String login){
		//return restTemplate.getForEntity("http://localhost:9000/clientes/"+login, Cliente.class).getBody();
		return restTemplate.getForEntity("http://ServicioClientes/clientes/"+login, Cliente.class).getBody();
	}
	
}
