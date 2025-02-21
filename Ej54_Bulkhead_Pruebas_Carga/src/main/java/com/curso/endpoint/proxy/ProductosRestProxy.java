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
	private WebClient webClientProductos;
	
	//Este va como un tiro
	public Flux<Producto> listar() {		
		return webClientProductos
				.get()
				.uri("/productos")
				.retrieve()
				.bodyToFlux(Producto.class);
		
	}

	//Este tardará 4 segundos
	public Mono<Producto> buscarConCalificaciones(String codigo) {		
		return webClientProductos
				.get()
				.uri("/productos/"+codigo+"/calificaciones")
				.retrieve()
				.bodyToMono(Producto.class);
		
	}

	public Mono<Producto> insertar(Producto cliente) {
	    return webClientProductos
	    	.post()
	        .uri("/productos")
	        .body(Mono.just(cliente), Producto.class)
	        .retrieve()
	        .bodyToMono(Producto.class);
	}	
	
}
