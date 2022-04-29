package com.curso.endpoint.dto;

import java.util.UUID;

import com.curso.modelo.entidad.Fabricante;

public class FabricanteDTO {

	private String codigo;
	private String nombre;
	private String direccion;
	private String telefono;

	public FabricanteDTO() {
		super();
	}

	public FabricanteDTO(String codigo, String nombre, String direccion, String telefono) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public FabricanteDTO(Fabricante fabricante) {
		codigo    = fabricante.getCodigo();
		nombre    = fabricante.getNombre();
		direccion = fabricante.getDireccion();
		telefono  = fabricante.getTelefono();
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
		return "Fabricante [id=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ "]";
	}
	
	public Fabricante asFabricante() {
		return new Fabricante(codigo, nombre, direccion, telefono);
	}

}
