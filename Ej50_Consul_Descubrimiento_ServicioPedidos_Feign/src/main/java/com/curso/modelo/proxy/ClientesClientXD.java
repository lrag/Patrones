package com.curso.modelo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.curso.modelo.entidad.Cliente;

@FeignClient(name="ServicioClientes")
public interface ClientesClientXD {
	
	@GetMapping( path="/clientes/{codigo}", produces = "application/json")
	Cliente buscar(@PathVariable("codigo") String login);
	
}


