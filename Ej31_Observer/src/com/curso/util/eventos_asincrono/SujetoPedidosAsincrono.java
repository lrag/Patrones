package com.curso.util.eventos_asincrono;

import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.entidad.Pedido;

public class SujetoPedidosAsincrono extends SujetoAsincronoAbstracto<Pedido> {

	public static SujetoPedidosAsincrono instancia;
	
	public static synchronized SujetoPedidosAsincrono getInstancia() {
		if(instancia == null) {
			instancia = new SujetoPedidosAsincrono();
		}
		return instancia;
	}
	
	private SujetoPedidosAsincrono() {
	}
	
}
