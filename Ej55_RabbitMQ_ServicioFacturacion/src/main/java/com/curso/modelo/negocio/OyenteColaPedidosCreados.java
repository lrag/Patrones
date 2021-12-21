package com.curso.modelo.negocio;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Pedido;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OyenteColaPedidosCreados {

	@Autowired
	private GestorFacturas gestorFacturas;
	
    @RabbitListener(queues = "colaPedidosCreados")
    public void listen(String json) {
    	
    	System.out.println("========================================");
        System.out.println("Pedido recibido: " + json);
        
        ObjectMapper objectMapper = new ObjectMapper();
        Pedido pedido = null;
        try {
			pedido = objectMapper.readValue(json, Pedido.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}	
        System.out.println(pedido);
        gestorFacturas.facturarPedido(pedido);
    }	
	
}
