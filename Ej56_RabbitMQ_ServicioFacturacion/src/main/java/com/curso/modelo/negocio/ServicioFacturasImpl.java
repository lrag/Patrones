package com.curso.modelo.negocio;

import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.Factura;
import com.curso.modelo.entidad.Pedido;

@Service
public class ServicioFacturasImpl implements ServicioFacturas {

	@Override
	public Factura facturarPedido(Pedido pedido) {
		//Lógica de negocio...
		//...
    	System.out.println("========================================");
    	System.out.println("Hilo: "+Thread.currentThread().getName());
    	System.out.println("GestorFacturas.facturarPedido.");
    	System.out.println("Emitiendo una facturita");
		return null;
	}
	
}
