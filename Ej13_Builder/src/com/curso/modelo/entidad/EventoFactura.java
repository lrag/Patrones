package com.curso.modelo.entidad;

import java.time.LocalDateTime;

public class EventoFactura {

	private int id;
	private LocalDateTime fecha;
	private String descripcion;

	public EventoFactura() {
		super();
	}

	public EventoFactura(int id, LocalDateTime fecha, String descripcion) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "EventoFactura [id=" + id + ", fecha=" + fecha + ", descripcion=" + descripcion + "]";
	}

}
