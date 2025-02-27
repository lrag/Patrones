package com.curso.filtros;

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

}

/*
class GF implements GatewayFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		long inicio = System.currentTimeMillis();
		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
			long fin = System.currentTimeMillis();
			System.out.println("Petición " + exchange.getRequest().getURI() + " procesada en " + (fin - inicio)
					+ " milisegundos.");
		}));
	}
	
}
*/