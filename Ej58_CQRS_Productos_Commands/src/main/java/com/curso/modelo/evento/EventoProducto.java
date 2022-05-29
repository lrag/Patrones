package com.curso.modelo.evento;

import com.curso.modelo.entidad.Producto;

public class EventoProducto {

	private TipoEventoProducto tipo;
	private Producto producto;

	public EventoProducto() {
		super();
	}

	public EventoProducto(TipoEventoProducto tipo, Producto producto) {
		super();
		this.tipo = tipo;
		this.producto = producto;
	}

	public TipoEventoProducto getTipo() {
		return tipo;
	}

	public void setTipo(TipoEventoProducto tipo) {
		this.tipo = tipo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
