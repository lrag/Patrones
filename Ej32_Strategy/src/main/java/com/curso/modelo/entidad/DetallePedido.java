package com.curso.modelo.entidad;

public class DetallePedido {

	private Integer id;
	private Pedido pedido;
	private Producto producto;
	private Double precio;
	private Integer cantidad;
	private Double descuento;

	public DetallePedido() {
		super();
	}

	public DetallePedido(Integer id, Pedido pedido, Producto producto, Double precio, Integer cantidad,
			Double descuento) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
		this.descuento = descuento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "DetallePedido [id=" + id + ", pedido=" + pedido + ", producto=" + producto + ", precio=" + precio
				+ ", cantidad=" + cantidad + ", descuento=" + descuento + "]";
	}

}
