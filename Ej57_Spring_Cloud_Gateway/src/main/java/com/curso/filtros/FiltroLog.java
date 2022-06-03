package com.curso.filtros;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class FiltroLog extends AbstractGatewayFilterFactory{

	@Override
	public GatewayFilter apply(Object config) {
		return (exchange, chain) -> {
			System.out.println("Petición recibida:"+exchange.getRequest().getURI());
			return chain.filter(exchange);
		};
	}

}




