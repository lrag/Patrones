package com.curso.modelo.entidad;

public class Factura {

	private Integer id;
	private String codigo;
	private String fecha;
	private String cliente;
	private Double total;

	public Factura() {
		super();
	}

	public Factura(Integer id, String codigo, String fecha, String cliente, Double total) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.fecha = fecha;
		this.cliente = cliente;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "Factura [id=" + id + ", codigo=" + codigo + ", fecha=" + fecha + ", cliente=" + cliente + ", total="
				+ total + "]";
	}

}
