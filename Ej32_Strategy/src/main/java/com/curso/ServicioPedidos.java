package com.curso;

import java.util.stream.Collectors;

import com.curso.modelo.entidad.Pedido;

public class ServicioPedidos {

	public void aceptarPedido(Pedido pedido, EstrategiaOferta estrategiaOferta) {
		//Comprobar datos bancarios del cliente
		//Comprobar las existencias
		//Reservar un camión para el envío

		pedido.calcularTotal();
		estrategiaOferta.calcularOferta(pedido);
		pedido.calcularTotal();
		
		System.out.println(pedido.formatear());
	}
	
	
	
}
