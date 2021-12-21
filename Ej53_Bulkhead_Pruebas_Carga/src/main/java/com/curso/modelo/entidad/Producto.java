package com.curso.modelo.entidad;

import java.util.List;

public class Producto {

	private Integer id;
	private String codigo;
	private String nombre;
	private String fabricante;
	private Double precio;
	private List<CalificacionProducto> calificaciones;

	public Producto() {
		super();
	}

	public Producto(Integer id, String nombre, String codigo, String fabricante, Double precio) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.fabricante = fabricante;
		this.precio = precio;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public List<CalificacionProducto> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<CalificacionProducto> calificaciones) {
		this.calificaciones = calificaciones;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", fabricante=" + fabricante
				+ ", precio=" + precio + ", calificaciones=" + calificaciones + "]";
	}

}
