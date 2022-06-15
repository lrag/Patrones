package com.curso.util.eventos_asincrono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.curso.util.eventos.Observador;
import com.curso.util.eventos.Sujeto;

public abstract class SujetoAsincronoAbstracto<T> implements Sujeto<T> {
	
	private ExecutorService terminator = Executors.newFixedThreadPool(4);
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
		//Esto podría implementarse de una manera más sofisticada
		observadores.forEach( obs -> {			
			terminator.execute(() -> obs.procesarEvento(evento)); //Runnable
		});
	}
	
}
