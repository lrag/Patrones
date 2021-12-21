package com.curso.observadores;

import com.curso.modelo.entidad.Pedido;
import com.curso.util.eventos.Observador;
import com.curso.util.eventos.SujetoPedidos;

public class GestorEnvios implements Observador<Pedido> {

	private SujetoPedidos sujetoPedidos = SujetoPedidos.getInstancia();
	
	public GestorEnvios() {
		super();
		sujetoPedidos.registro(this);
	}

	@Override
	public void procesarEvento(Pedido evento) {
		crearEnvio(evento);
	}
	
	public void crearEnvio(Pedido pedido) {
		System.out.println("GestorEnvios.crearEnvio:"+pedido);
	}

}
