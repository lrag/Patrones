package com.curso.modelo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity //Obligatoria
@Table(name="productos") //Opcional
public class Producto {

	@Id //Obligatoria
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column( length = 40 )
	private String nombre;
	private String fabricante;
	private Double precio;
	private Integer existencias;

	public Producto() {
		super();
	}

	public Producto(Integer id, String nombre, String fabricante, Double precio, Integer existencias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fabricante = fabricante;
		this.precio = precio;
		this.existencias = existencias;
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

	public Integer getExistencias() {
		return existencias;
	}

	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", fabricante=" + fabricante + ", precio=" + precio
				+ ", existencias=" + existencias + "]";
	}

}
