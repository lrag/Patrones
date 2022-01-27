package com.curso.modelo.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.curso.modelo.evento.EventoProducto;

@Component
public class ProxyMensajeria {

	@Value("${kafka.topic.nombre}") 
	private String nombreTopic;
	
	@Autowired 
	private KafkaTemplate<String, EventoProducto> kafkaTemplate;
	
	public void enviarMensaje(String clave, EventoProducto valor) {
		
		System.out.println("Enviando el mensaje...");
		ListenableFuture<SendResult<String, EventoProducto>> future = kafkaTemplate.send(nombreTopic, clave, valor);

		future.addCallback(new ListenableFutureCallback<SendResult<String, EventoProducto>>() {

		    @Override
		    public void onSuccess(SendResult<String, EventoProducto> result) {
		        System.out.println("OK");
		    }

		    @Override
		    public void onFailure(Throwable ex) {
		        System.out.println("ZASCA");
		        ex.printStackTrace();
		    }

		});
	}
	
}
