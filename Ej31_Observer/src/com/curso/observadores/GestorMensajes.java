package com.curso.observadores;

import com.curso.modelo.entidad.Pedido;
import com.curso.util.eventos.Observador;
import com.curso.util.eventos.SujetoPedidos;

public class GestorMensajes implements Observador<Pedido> {

	private SujetoPedidos sujetoPedidos = SujetoPedidos.getInstancia();
	
	public GestorMensajes() {
		super();
		sujetoPedidos.registro(this);
	}	
	
	@Override
	public void procesarEvento(Pedido evento) {
		enviarCorreoElectronico(evento);
	}
	
	public void enviarCorreoElectronico(Pedido pedido) {
		System.out.println("GestorMensajes.enviarCorreoElectronico:"+pedido);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
