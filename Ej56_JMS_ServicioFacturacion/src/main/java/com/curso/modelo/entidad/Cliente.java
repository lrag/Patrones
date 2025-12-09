package com.curso.modelo.entidad;

public class Cliente {

	private Integer id;
	private String login;
	private String nombre;
	private String datosBancarios;

	public Cliente(Integer id, String login, String nombre, String datosBancarios) {
		super();
		this.id = id;
		this.login = login;
		this.nombre = nombre;
		this.datosBancarios = datosBancarios;
	}

	public Cliente() {
		super();
	}

	public Integer getId() {
		return id;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDatosBancarios() {
		return datosBancarios;
	}

	public void setDatosBancarios(String datosBancarios) {
		this.datosBancarios = datosBancarios;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", login=" + login + ", nombre=" + nombre + ", datosBancarios=" + datosBancarios + "]";
	}

}
