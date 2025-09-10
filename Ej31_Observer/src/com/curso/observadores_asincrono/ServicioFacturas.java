package com.curso.observadores_asincrono;

import com.curso.modelo.entidad.Pedido;
import com.curso.util.eventos.Observador;
import com.curso.util.eventos_asincrono.SujetoPedidosAsincrono;

public class ServicioFacturas implements Observador<Pedido> {

	private SujetoPedidosAsincrono sujetoPedidos = SujetoPedidosAsincrono.getInstancia();
	
	public ServicioFacturas() {
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
