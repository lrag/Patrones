package com.curso.observadores;

import com.curso.modelo.entidad.Pedido;
import com.curso.util.eventos.Observador;
import com.curso.util.eventos.SujetoPedidos;

public class GestorFacturas implements Observador<Pedido> {

	private SujetoPedidos sujetoPedidos = SujetoPedidos.getInstancia();
	
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
