package com.curso.endpoint.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.curso.modelo.entidad.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductosRestProxy {

	//Mejor que nos inyecten la historia esta...
	//private WebClient webClient = WebClient.create("http://localhost:8080");

	@Autowired
	private WebClient webClientClientes;
	
	
	public Flux<Producto> listar() {		
		return webClientClientes
				.get()
				.uri("/productos")
				.retrieve()
				.bodyToFlux(Producto.class);
		
	}

	public Mono<Producto> buscarConCalificaciones(String codigo) {		
		return webClientClientes
				.get()
				.uri("/productos/"+codigo+"/calificaciones")
				.retrieve()
				.bodyToMono(Producto.class);
		
	}

	public Mono<Producto> insertar(Producto cliente) {
	    return webClientClientes
	    	.post()
	        .uri("/productos")
	        .body(Mono.just(cliente), Producto.class)
	        .retrieve()
	        .bodyToMono(Producto.class);
	}	
	
}
