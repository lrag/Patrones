package com.curso.modelo.entidad;

import java.time.LocalDate;

public class CobroFactura {

	private int id;
	private LocalDate fecha;
	private double cantidad;

	public CobroFactura() {
		super();
	}

	public CobroFactura(int id, LocalDate fecha, double cantidad) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "CobroFactura [id=" + id + ", fecha=" + fecha + ", cantidad=" + cantidad + "]";
	}

}
