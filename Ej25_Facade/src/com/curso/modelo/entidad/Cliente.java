package com.curso.modelo.entidad;

public class Cliente {

	private Long id;
	private String login;
	private String nombre;
	private String direccion;
	private String telefono;
	private String correoE;
	private String datosBancarios; 

	public Cliente() {
		super();
	}

	public Cliente(Long id, String login, String nombre, String direccion, String telefono, String correoE,	String datosBancarios) {
		super();
		this.id = id;
		this.login = login;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoE = correoE;
		this.datosBancarios = datosBancarios;
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

	public String getDatosBancarios() {
		return datosBancarios;
	}

	public void setDatosBancarios(String datosBancarios) {
		this.datosBancarios = datosBancarios;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", login=" + login + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", correoE=" + correoE + ", datosBancarios=" + datosBancarios + "]";
	}

}
