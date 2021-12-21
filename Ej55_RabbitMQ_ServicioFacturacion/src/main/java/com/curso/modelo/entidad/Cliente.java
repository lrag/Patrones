package com.curso.modelo.entidad;

import com.curso.modelo.entidad.Cliente;

public class Cliente {

	private String login;
	private String nombre;
	private String datosBancarios;

	public Cliente(String login, String nombre, String datosBancarios) {
		super();
		this.login = login;
		this.nombre = nombre;
		this.datosBancarios = datosBancarios;
	}

	public Cliente() {
		super();
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

	public String getDatosBancarios() {
		return datosBancarios;
	}

	public void setDatosBancarios(String datosBancarios) {
		this.datosBancarios = datosBancarios;
	}

	@Override
	public String toString() {
		return "Cliente [login=" + login + ", nombre=" + nombre + ", datosBancarios=" + datosBancarios + "]";
	}

	
}
