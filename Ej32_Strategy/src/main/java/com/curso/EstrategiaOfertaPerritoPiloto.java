package com.curso;

import com.curso.modelo.entidad.DetallePedido;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.entidad.Producto;

public class EstrategiaOfertaPerritoPiloto implements EstrategiaOferta{

	public EstrategiaOfertaPerritoPiloto() {
		super();
	}

	@Override
	public void calcularOferta(Pedido pedido) {
		Producto pp = new Producto(6, "Perrito piloto", "Famobil", 20d, 0);
		DetallePedido dp = new DetallePedido(null, pedido, pp, 0d, 1, 0d);
		pedido.addDetalle(dp);
	}
	
}
