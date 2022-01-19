package com.curso.modelo.entidad;

public class Pedido {

	private String codigo;
	private String fecha;
	private String cliente;
	private Double total;

	public Pedido() {
		super();
	}

	public Pedido(String codigo, String fecha, String cliente, Double total) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.cliente = cliente;
		this.total = total;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", fecha=" + fecha + ", cliente=" + cliente + ", total=" + total + "]";
	}

}
