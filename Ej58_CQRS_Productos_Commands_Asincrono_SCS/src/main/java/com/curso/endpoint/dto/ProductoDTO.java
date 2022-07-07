package com.curso.endpoint.dto;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.curso.modelo.entidad.Fabricante;
import com.curso.modelo.entidad.Producto;

public class ProductoDTO {

	private String referencia;
	private String nombre;
	private String descripcion;
	private FabricanteDTO fabricante;

	public ProductoDTO() {
		super();
	}
	
	public ProductoDTO(String referencia, String nombre, String descripcion, FabricanteDTO fabricante) {
		super();
		this.referencia  = referencia;
		this.nombre      = nombre;
		this.descripcion = descripcion;
		this.fabricante  = fabricante;
	}

	public ProductoDTO(Producto producto) {
		referencia  = producto.getReferencia();
		nombre      = producto.getNombre();
		descripcion = producto.getDescripcion();
		fabricante  = new FabricanteDTO(producto.getFabricante());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public FabricanteDTO getFabricante() {
		return fabricante;
	}

	public void setFabricante(FabricanteDTO fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Producto [id=" + referencia + ", nombre=" + nombre + ", referencia=" + referencia + ", descripcion="
				+ descripcion + ", fabricante=" + fabricante + "]";
	}
	
	public Producto asProducto() {
		return new Producto(referencia, nombre, descripcion, fabricante.asFabricante());
	}

}
