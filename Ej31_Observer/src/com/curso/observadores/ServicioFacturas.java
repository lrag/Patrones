package com.curso.observadores;

import com.curso.modelo.entidad.Factura;
import com.curso.modelo.entidad.Pedido;
import com.curso.util.eventos.Observador;
import com.curso.util.eventos.SujetoPedidos;

public class ServicioFacturas implements Observador<Pedido> {

	private SujetoPedidos sujetoPedidos = SujetoPedidos.getInstancia();
	
	public ServicioFacturas() {
		super();
		sujetoPedidos.registro(this);
	}
	
	@Override
	public void procesarEvento(Pedido evento) {
		//En los m�todos que reciben eventos hay l�gica de control
		//Si el m�todo de negocio devuelve algo aqui se ignora
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
