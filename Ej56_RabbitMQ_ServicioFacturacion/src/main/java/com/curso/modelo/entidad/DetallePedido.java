package com.curso.modelo.entidad;

import com.curso.modelo.entidad.DetallePedido;

public class DetallePedido {

	private Double precio;
	private Integer cantidad;
	private Producto producto;		
	
	public DetallePedido() {
		super();
	}
	
	public DetallePedido(Double precio, Integer cantidad, Producto producto) {
		super();
		this.precio = precio;
		this.cantidad = cantidad;
		this.producto = producto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}	
	
}
