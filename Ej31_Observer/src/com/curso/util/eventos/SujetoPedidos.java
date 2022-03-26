package com.curso.util.eventos;

import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.entidad.Pedido;

public class SujetoPedidos extends SujetoAbstracto<Pedido> {

	private static SujetoPedidos instancia;
	
	public static synchronized SujetoPedidos getInstancia() {
		if(instancia == null) {
			instancia = new SujetoPedidos();
		}
		return instancia;
	}
	
	private SujetoPedidos() {
	}
	
}
