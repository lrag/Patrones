package com.curso.util.eventos;

import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.entidad.Pedido;

public abstract class SujetoAbstracto<T> implements Sujeto<T> {
	
	private List<Observador<T>> observadores = new ArrayList<Observador<T>>();
	
	@Override
	public void registro(Observador<T> observador) {
		observadores.add(observador);		
	}

	@Override
	public void baja(Observador<T> observador) {
		for(Observador<T> obs: observadores) {
			if(obs.equals(observador)) {
				observadores.remove(observador);
				break;
			}
		}
	}

	@Override
	public void emitir(T evento) {
		observadores.forEach(obs -> obs.procesarEvento(evento));
	}
	
}
