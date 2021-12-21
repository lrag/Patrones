package com.curso.observadores;

import com.curso.modelo.entidad.Pedido;
import com.curso.util.eventos.SujetoPedidos;

public class GestorPedidos {

	private SujetoPedidos sujetoPedidos = SujetoPedidos.getInstancia();
	
	public void crearOrdenDeCompra(Pedido pedido) {
		
		//Lógica de negocio para aceptar el pedido
		
		//buscar los datos del cliente
		//Cliente c = servicioClientes.buscar(.GestorPedidos.)
		//buscar el precio de los productos
		//comprobar las existencias de los productos
		
		System.out.println("=====================================");
		System.out.println("GestorPedidos.altaPedido");

		sujetoPedidos.emitir(pedido);
		
	}
	
}
