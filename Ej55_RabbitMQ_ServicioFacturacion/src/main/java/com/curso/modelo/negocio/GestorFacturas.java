package com.curso.modelo.negocio;

import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.Factura;
import com.curso.modelo.entidad.Pedido;

@Service
public class GestorFacturas {

	public Factura facturarPedido(Pedido pedido) {
		//Lógica de negocio...
		//...
    	System.out.println("========================================");
    	System.out.println("GestorFacturas.facturarPedido.");
    	System.out.println("Emitiendo una facturita");
		return null;
	}
	
}
