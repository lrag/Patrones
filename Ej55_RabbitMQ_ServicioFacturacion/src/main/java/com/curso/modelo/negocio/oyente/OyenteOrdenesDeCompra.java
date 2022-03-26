package com.curso.modelo.negocio.oyente;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.negocio.GestorFacturas;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OyenteOrdenesDeCompra {

	@Autowired
	private GestorFacturas gestorFacturas;
	
    @RabbitListener(queues = "colaOrdenesDeCompra")
    public void listen(String json) {
    	
    	//Esto es lógica de control
    	
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
