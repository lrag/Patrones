package com.curso.modelo.entidad;

public class Cliente {

	private int id;
	private String codigo;
	private String nombre;
	private String direccion;
	private String telefono;

	public Cliente() {
		super();
	}

	public Cliente(int id, String codigo, String nombre, String direccion, String telefono) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public Cliente setId(int id) {
		this.id = id;
		return this;
	}

	public String getCodigo() {
		return codigo;
	}

	public Cliente setCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public Cliente setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public String getDireccion() {
		return direccion;
	}

	public Cliente setDireccion(String direccion) {
		this.direccion = direccion;
		return this;
	}

	public String getTelefono() {
		return telefono;
	}

	public Cliente setTelefono(String telefono) {
		this.telefono = telefono;
		return this;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", telefono=" + telefono + "]";
	}

}
