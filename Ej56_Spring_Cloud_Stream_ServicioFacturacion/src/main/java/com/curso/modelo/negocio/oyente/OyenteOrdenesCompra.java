package com.curso.modelo.negocio.oyente;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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

/*
class Movida1 implements Supplier<Pedido> {
	public Pedido get() {
		return null;
	}
}

class Movida2 implements Consumer<Pedido> {
	public void accept(Pedido t) {
	}
	
}

class Movida3 implements Function<Pedido, String> {
	public String apply(Pedido pedido) {
		return pedido.getCodigo();
	}
}
*/



