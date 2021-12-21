package com.curso.modelo.negocio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.Factura;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.persistencia.FacturaRepositorio;

@Service
public class GestorFacturas {

	@Autowired private FacturaRepositorio facturaRepo;

	public Factura facturarPedido(Pedido pedido) {
		//Lógica de negocio...
		//...
    	System.out.println("========================================");
		System.out.println("Insertando la factura...");
		return null;
	}
	
	public Factura insertar(Factura factura) {
		//Lógica de negocio...
		//...
    	System.out.println("========================================");
		System.out.println("Insertando la factura...");
		return null;
	}
	
}
