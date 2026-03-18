package com.curso.modelo.evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Producto;
import com.curso.modelo.negocio.ProjectorProductos;

//@Component
public class OyenteEventos {

	@Autowired
	private ProjectorProductos projectorProductos;

	@KafkaListener(
			topics = "${kafka.topic.nombre}", 
			groupId = "${random.uuid}", //<----
			properties = {"auto.offset.reset = earliest"}
		)
	public void oyenteEventoProducto(EventoProducto eventoProducto) {
		
		//Esto es lógica de control
		
		System.out.println("Evento recibido:"+eventoProducto);
		
		Producto producto = eventoProducto.getProducto();
		switch (eventoProducto.getTipo()) {
			case PRODUCTO_CREADO :
				projectorProductos.insertar(producto);
				break;
			case PRODUCTO_MODIFICADO :
				projectorProductos.modificar(producto);
				break;
			case PRODUCTO_BORRADO :
				projectorProductos.borrar(producto.getReferencia());
				break;	
			default:
				break;
		}
	}

}
