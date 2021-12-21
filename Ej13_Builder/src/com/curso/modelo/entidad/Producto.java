package com.curso.modelo.entidad;

public class Producto {

	private int id;
	private String codigo;
	private String nombre;
	private String fabricante;

	public Producto() {
		super();
	}

	public Producto(int id, String codigo, String nombre, String fabricante) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.fabricante = fabricante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", fabricante=" + fabricante + "]";
	}

}
