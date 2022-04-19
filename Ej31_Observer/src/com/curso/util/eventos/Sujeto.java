package com.curso.util.eventos;

public interface Sujeto<T> {

	void registro(Observador<T> observador);
	void baja(Observador<T> observador);
	void emitir(T evento);
	
}
