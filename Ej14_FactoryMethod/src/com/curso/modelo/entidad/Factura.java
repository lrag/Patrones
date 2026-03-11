package com.curso.modelo.entidad;

public class Factura {

	private String codigo;
	private String fecha;
	private Double total;

	public Factura() {
		super();
	}

	public Factura(String codigo, String fecha, Double total) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Factura [codigo=" + codigo + ", fecha=" + fecha + ", total=" + total + "]";
	}

}
