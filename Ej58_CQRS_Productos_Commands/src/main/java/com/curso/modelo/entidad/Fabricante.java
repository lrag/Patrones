package com.curso.modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fabricante {

	@Id
	private String codigo;
	private String nombre;
	private String direccion;
	private String telefono;

	public Fabricante() {
		super();
	}

	public Fabricante(String id, String nombre, String direccion, String telefono) {
		super();
		this.codigo = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	@Override
	public String toString() {
		return "Fabricante [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ "]";
	}

}
