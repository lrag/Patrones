package com.curso.modelo.evento;

import java.util.Map;

import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.AbstractConsumerSeekAware;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Producto;
import com.curso.modelo.negocio.ProjectorProductos;

@Component
public class OyenteEventosTimestamp extends AbstractConsumerSeekAware {

    private Long startTimeMillis = 1773762751000L;
    private Long fechaFinMillis  = 1773762757999L;
    
    @Autowired private KafkaListenerEndpointRegistry registry;
    @Autowired private ProjectorProductos projectorProductos;

    @KafkaListener(
    		topics = "${kafka.topic.nombre}", 
    		groupId = "${random.uuid}", 
    		id = "oyenteEventosTimestamp"
    	)
    public void oyenteEventoProducto(EventoProducto eventoProducto, @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts) {
        if (ts > fechaFinMillis) {
        	registry.getListenerContainer("oyenteEventosTimestamp").stop();
            return; 
        }
        
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

    @Override
    public void onPartitionsAssigned(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
        assignments.keySet().forEach(tp -> 
            callback.seekToTimestamp(tp.topic(), tp.partition(), startTimeMillis)
        );
    }
}