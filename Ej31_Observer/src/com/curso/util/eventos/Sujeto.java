package com.curso.util.eventos;

public interface Sujeto<T> {

	//invocados por los subscriptores
	void registro(Observador<T> observador);
	void baja(Observador<T> observador);
	//invocado por los emisores/publishers de eventos/mensajes
	void emitir(T evento);
	
}
