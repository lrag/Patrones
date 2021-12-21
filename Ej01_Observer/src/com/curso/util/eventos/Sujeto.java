package com.curso.util.eventos;

public interface Sujeto<T> {

	public void registro(Observador<T> observador);
	public void baja(Observador<T> observador);
	public void emitir(T evento);
	
}
