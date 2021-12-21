package com.curso.util.eventos;

public interface Observador<T> {
	void procesarEvento(T obj);
}

