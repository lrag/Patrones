package com.curso.modelo.entidad;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String codigo;
	private String nombre;
	private String imagen;
	private String fabricante;
	private Double precio;	
	
	@Transient
	private List<CalificacionProducto> calificaciones;

	public Producto() {
		super();
	}

	public Producto(Integer id, String nombre, String codigo, String fabricante, String imagen, Double precio, List<CalificacionProducto> calificaciones) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.imagen = imagen;
		this.fabricante = fabricante;
		this.precio = precio;
		this.calificaciones = calificaciones;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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
		return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", imagen=" + imagen
				+ ", fabricante=" + fabricante + ", precio=" + precio + ", calificaciones=" + calificaciones + "]";
	}
	
}
