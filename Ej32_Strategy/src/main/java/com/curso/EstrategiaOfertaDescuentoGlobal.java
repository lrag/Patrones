package com.curso;

import com.curso.modelo.entidad.Pedido;

public class EstrategiaOfertaDescuentoGlobal implements EstrategiaOferta{

	private Double descuento;

	public EstrategiaOfertaDescuentoGlobal(Double descuento) {
		super();
		this.descuento = descuento;
	}

	@Override
	public void calcularOferta(Pedido pedido) {
		pedido.setDescuento(pedido.getTotal()*(descuento/100));
	}
	
}
