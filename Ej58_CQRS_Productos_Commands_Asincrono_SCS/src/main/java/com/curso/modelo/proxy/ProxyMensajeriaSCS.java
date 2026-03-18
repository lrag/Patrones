package com.curso.modelo.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.curso.modelo.evento.EventoProducto;

@Component
public class ProxyMensajeriaSCS implements ProxyMensajeria {

	@Autowired
	private StreamBridge streamBridge;

	@Override
	public void enviarMensaje(String referencia, EventoProducto ep) {
		Message<EventoProducto> mensaje = MessageBuilder
			.withPayload(ep)
			.setHeader("REFERENCIA", referencia.getBytes())
			.build();
		
		//Licencia: el nombre del topic está a fuego 
		streamBridge.send("topic-productos-cqrs", mensaje);		
	}

}
