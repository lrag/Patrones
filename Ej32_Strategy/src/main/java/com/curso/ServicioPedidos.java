package com.curso;

import com.curso.modelo.entidad.Pedido;

public class ServicioPedidos {

	//La estrategia puede ser un atributo del objeto y que se asigne al crearlo
	private EstrategiaOferta estrategiaOferta;
	
	//Tambien puede ser un parámetro de un método y que la estrategia cambie a cada llamada
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
