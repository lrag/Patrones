package com.curso.endpoint.dto;

import java.io.Serializable;

import com.curso.modelo.entidad.DetallePedido;

public class DetallePedidoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Double precio;
	private Integer cantidad;
	private ProductoDTO producto;		
	
	public DetallePedidoDTO() {
		super();
	}
	
	public DetallePedidoDTO(Double precio, Integer cantidad, ProductoDTO producto) {
		super();
		this.precio = precio;
		this.cantidad = cantidad;
		this.producto = producto;
	}

	public DetallePedidoDTO(DetallePedido detalle) {
		super();
		this.precio = detalle.getPrecio();
		this.cantidad = detalle.getCantidad();
		this.producto = new ProductoDTO(detalle.getProducto());
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

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}	
	
	public DetallePedido asDetallePedido() {
		return new DetallePedido(null,precio,cantidad,null,producto.asProducto());
	}
	
}
