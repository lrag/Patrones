package com.curso.modelo.negocio.oyente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.curso.endpoint.dto.PedidoDTO;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.negocio.ServicioFacturas;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OyenteOrdenesDeCompra {

	@Autowired
	private ServicioFacturas gestorFacturas;
	
    @JmsListener( destination = "cola")
    public void listen(PedidoDTO pedidoDTO) {
    	
    	//
    	//Esto es lógica de control
    	//
        
        System.out.println(pedidoDTO);
        gestorFacturas.facturarPedido(pedidoDTO.asPedido());
    }	
	
}



/*

CONTROLADOR

extraer de la petición la info
convertirla a los obtejos que entiende la LN
llamar al método correspondiente de la capa de modelo
escoger la siguiente vista
preparar los datos para la vista
'pasarle la pelota a la vista'


ENDPOINT

extraer de la petición la info
convertirla a los obtejos que entiende la LN
llamar al método correspondiente de la capa de modelo
preparar los datos para la respuesta
dar a respuesta


OYENTE/SUBSCRIPTOR

extraer del mensaje la info
convertirla a los obtejos que entiende la LN
llamar al método correspondiente de la capa de modelo


*/














