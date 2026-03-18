package com.curso.filtros;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class FiltroCronometro extends AbstractGatewayFilterFactory {

	@Override
	public GatewayFilter apply(Object config) {
		return (exchange, chain) -> {
			long inicio = System.currentTimeMillis();
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				long fin = System.currentTimeMillis();
				System.out.println("Petición " + exchange.getRequest().getURI() + " procesada en " + (fin - inicio)
						+ " milisegundos.");
			}));
		};
	}
	
	/*
	public static void main(String[] args) {
		
		List<String> palabras = List.of("uno","dos","tres","cuatro","cinco");
		
		
		List<String> palabras2 = palabras.stream()	
			.filter( s -> s.length()>3 )
			.map( s -> s.toUpperCase() )
			.collect(Collectors.toList());
		
		palabras2.forEach(p -> System.out.println(p));
		
		
		Optional<String> strOp = Optional.of("hola");
		
		
		strOp.filter( s -> s.length()>3).map( s -> s.toUpperCase()).orElse("NO HAY VALOR");
		
		
		
		
		
		
	}
	*/
	

}

class GF implements GatewayFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		//ANTES DE TIRAR PA'LANTE (Th1)
		long inicio = System.currentTimeMillis();
		
		//IF
		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
			//DESPUES (Ejecutado por otro thread)
			long fin = System.currentTimeMillis();
			System.out.println("Petición " + exchange.getRequest().getURI() + " procesada en " + (fin - inicio)
					+ " milisegundos.");
		}));
	}
	
}







