package com.curso.modelo.proxy;

import com.curso.modelo.evento.EventoProducto;

public interface ProxyMensajeria {

	void enviarMensaje(String referencia, EventoProducto ep);

}