package com.curso.filtros;

import java.util.function.Function;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
//Esta bean NO es el filtro: su responsabilidad es crearlo y devolverlo
public class FiltroLog extends AbstractGatewayFilterFactory{

	@Override
	public GatewayFilter apply(Object config) {
		return (exchange, chain) -> {
			System.out.println("Petición recibida:"+exchange.getRequest().getMethod()+" "+exchange.getRequest().getURI());
			return chain.filter(exchange);
		};
	}

}

/*
@Component
class FiltroLog_ implements GatewayFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("Petición recibida:"+exchange.getRequest().getURI());
		return chain.filter(exchange);
	}
	
}
*/


