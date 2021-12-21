package com.curso.modelo.entidad;

public class DetalleFactura implements Cloneable {

	private int id;
	private double cantidad;
	private double precio;
	private Producto producto;

	public DetalleFactura() {
		super();
	}

	public DetalleFactura(int id, double cantidad, double precio, Producto producto) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.producto = producto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return super.toString()+" [id=" + id + ", cantidad=" + cantidad + ", precio=" + precio + ", producto=" + producto.getCodigo()
				+ "]";
	}
	
	@Override
	public Object clone() {
		return new DetalleFactura(id, cantidad, precio, (Producto) producto.clone());
	}

}
