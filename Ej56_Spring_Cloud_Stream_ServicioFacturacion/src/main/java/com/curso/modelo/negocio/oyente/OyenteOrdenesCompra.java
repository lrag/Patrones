package com.curso.modelo.negocio.oyente;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.negocio.GestorFacturas;

@Component
public class OyenteOrdenesCompra implements Consumer<Pedido>{

	@Autowired
	private GestorFacturas gestorFacturas;
	
	@Override
	public void accept(Pedido pedido) {
		//Esto es lógica de control
		System.out.println("========================================");
		System.out.println("Pedido recibido: " + pedido);
		gestorFacturas.facturarPedido(pedido);
		
	}	
	
}
