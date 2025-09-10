package com.curso.observadores_asincrono;

import com.curso.modelo.entidad.Pedido;
import com.curso.util.eventos.Observador;
import com.curso.util.eventos_asincrono.SujetoPedidosAsincrono;

public class ServicioEnvios implements Observador<Pedido> {

	private SujetoPedidosAsincrono sujetoPedidos = SujetoPedidosAsincrono.getInstancia();
	
	public ServicioEnvios() {
		super();
		sujetoPedidos.registro(this);
	}

	@Override
	public void procesarEvento(Pedido evento) {
		//Aqui no hay lógica de negocio
		//AQUI HAY LÓGICA DE CONTROL!
		crearEnvio(evento);
	}
	
	public void crearEnvio(Pedido pedido) {
		System.out.println("GestorEnvios.crearEnvio:"+pedido);
		//LN
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
