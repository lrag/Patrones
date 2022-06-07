package com.curso.modelo.entidad;

import java.time.LocalDate;

public class Cliente {

	private Integer id;
	String nombre;
	private String direccion;
	private String telefono;
	private Integer numeroTC;
	private LocalDate fechaAlta;

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nombre, String direccion, String telefono, Integer numeroTC,
			LocalDate fechaAlta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.numeroTC = numeroTC;
		this.fechaAlta = fechaAlta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getNumeroTC() {
		return numeroTC;
	}

	public void setNumeroTC(Integer numeroTC) {
		this.numeroTC = numeroTC;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", numeroTC=" + numeroTC + ", fechaAlta=" + fechaAlta + "]";
	}
	
}
