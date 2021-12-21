package com.curso.util.eventos;

import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.entidad.Pedido;

public class SujetoPedidos implements Sujeto<Pedido> {

	public static SujetoPedidos instancia;
	
	public static synchronized SujetoPedidos getInstancia() {
		if(instancia == null) {
			instancia = new SujetoPedidos();
		}
		return instancia;
	}
	
	private List<Observador<Pedido>> observadores = new ArrayList<Observador<Pedido>>();

	private SujetoPedidos() {
	}
	
	@Override
	public void registro(Observador<Pedido> observador) {
		observadores.add(observador);		
	}

	@Override
	public void baja(Observador<Pedido> observador) {
		for(Observador<Pedido> obs: observadores) {
			if(obs.equals(observador)) {
				observadores.remove(observador);
				break;
			}
		}
	}

	@Override
	public void emitir(Pedido evento) {
		observadores.forEach( obs -> obs.procesarEvento(evento));
	}
	
}
