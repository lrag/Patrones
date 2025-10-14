package com.curso.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DetallePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	private Double precio;
	private Integer cantidad;
	
	@ManyToOne
	private Pedido pedido;
	
	@ManyToOne
	private Producto producto;		
	
	public DetallePedido() {
		super();
	}
	
	public DetallePedido(Integer id, Double precio, Integer cantidad, Pedido pedido, Producto producto) {
		super();
		this.id = id;
		this.precio = precio;
		this.cantidad = cantidad;
		this.pedido = pedido;
		this.producto = producto;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}	
	
}
