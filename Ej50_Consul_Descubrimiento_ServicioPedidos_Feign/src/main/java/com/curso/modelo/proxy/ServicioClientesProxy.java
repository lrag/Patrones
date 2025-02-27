package com.curso.modelo.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.ClienteRepositorio;

@Component
public class ServicioClientesProxy {

	@Autowired private ClientesClientXD clientesClientXD;
	@Autowired private ClienteRepositorio clienteRepo;
	
	public Cliente buscar(String login){
		return clienteRepo
			.findByLogin(login)
			.orElseGet( () -> {
				System.out.println("Invocando al microservicio de clientes");
				Cliente cliAux = clientesClientXD.buscar(login);
				System.out.println("Cliente obtenido:"+cliAux);
				clienteRepo.save(cliAux);
				return cliAux;
			});		
	}

}
