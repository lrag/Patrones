package com.curso.cfg;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracion {
	
	/*Otra manera de registrar el consumer
	@Bean
	Consumer<Pedido> oyenteOrdenesCompra(GestorFacturas gestorFacturas){
		return pedido -> gestorFacturas.facturarPedido(pedido);
	}
	*/	
	
}
