package com.curso.filtros;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class FiltroHeaders extends AbstractGatewayFilterFactory{

	@Override
	public GatewayFilter apply(Object config) {
		return (exchange, chain) -> {
			System.out.println("FiltroHeaders Petición recibida:"+exchange.getRequest().getURI());
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				exchange.getResponse().getHeaders().add("HEADER", "Max Headroom");
			}));
		};
	}

}
