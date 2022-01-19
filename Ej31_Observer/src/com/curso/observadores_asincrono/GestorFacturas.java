package com.curso.observadores_asincrono;

import com.curso.modelo.entidad.Pedido;
import com.curso.util.eventos.Observador;
import com.curso.util.eventos.SujetoPedidos;
import com.curso.util.eventos.SujetoPedidosAsincrono;

public class GestorFacturas implements Observador<Pedido> {

	private SujetoPedidosAsincrono sujetoPedidos = SujetoPedidosAsincrono.getInstancia();
	
	public GestorFacturas() {
		super();
		sujetoPedidos.registro(this);
	}
	
	@Override
	public void procesarEvento(Pedido evento) {
		insertarFactura(evento);
	}
	
	public void insertarFactura(Pedido pedido) {
		System.out.println("GestorFacturas.insertarFactura:"+pedido);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
