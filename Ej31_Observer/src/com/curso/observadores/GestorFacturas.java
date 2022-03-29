package com.curso.observadores;

import com.curso.modelo.entidad.Factura;
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
		//En los métodos que reciben eventos hay lógica de control
		//Si el método de negocio devuelve algo aqui se ignora
		facturarPedido(evento);
	}
	
	public Factura facturarPedido(Pedido pedido) {
		System.out.println("GestorFacturas.insertarFactura:"+pedido);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new Factura();
	}

}
