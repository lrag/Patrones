package com.curso.endpoint.dto;

import com.curso.modelo.entidad.Cliente;

public class ClienteDTO {

	private Long id;
	private String login;
	private String nombre;
	private String direccion;
	private String telefono;
	private String correoE;

	public ClienteDTO() {
		super();
	}

	public ClienteDTO(Long id, String login, String nombre, String direccion, String telefono, String correoE) {
		super();
		this.id = id;
		this.login = login;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoE = correoE;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public String getCorreoE() {
		return correoE;
	}

	public void setCorreoE(String correoE) {
		this.correoE = correoE;
	}

	@Override
	public String toString() {
		return "ClienteDTO [id=" + id + ", login=" + login + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", correoE=" + correoE + "]";
	}

}
