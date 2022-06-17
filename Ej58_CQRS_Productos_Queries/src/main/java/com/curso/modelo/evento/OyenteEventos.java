package com.curso.modelo.evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Producto;
import com.curso.modelo.negocio.ProjectorProductos;

@Component
public class OyenteEventos {

	@Value("${kafka.topic.grupo}") 
	private String idGrupo;
	@Value("${kafka.topic.nombre}") 
	private String nombreTopic;
	
	//En este ejemplo. en vez del projector este yo inyectaría aqui directamente al repositorio
	//Esto es asi porque el modelo de clases es igual en la aplicacion de los comando y la de las consultas
	//Si fueran distintas si que vendría bien un projector
	@Autowired
	private ProjectorProductos projectorPoductos;
	
	public String getIdGrupo() {
		return idGrupo;
	}

	public String getNombreTopic() {
		return nombreTopic;
	}
	
	@KafkaListener(topics = "#{__listener.nombreTopic}", groupId = "#{__listener.idGrupo}")
	public void oyenteEventoProducto(EventoProducto eventoProducto) {
		
		System.out.println("Evento recibido:"+eventoProducto);
		
		Producto producto = eventoProducto.getProducto();
		switch (eventoProducto.getTipo()) {
			case PRODUCTO_CREADO :
				projectorPoductos.insertar(producto);
				break;
			case PRODUCTO_MODIFICADO :
				projectorPoductos.modificar(producto);
				break;
			case PRODUCTO_BORRADO :
				projectorPoductos.borrar(producto.getReferencia());
				break;	
			default:
				break;
		}
	}

}
