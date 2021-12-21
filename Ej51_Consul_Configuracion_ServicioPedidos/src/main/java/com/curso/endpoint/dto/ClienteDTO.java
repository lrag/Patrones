package com.curso.endpoint.dto;

import com.curso.modelo.entidad.Cliente;

public class ClienteDTO {

	private String login;
	private String nombre;
	private String datosBancarios;

	public ClienteDTO(String login, String nombre, String datosBancarios) {
		super();
		this.login = login;
		this.nombre = nombre;
		this.datosBancarios = datosBancarios;
	}

	public ClienteDTO(Cliente cliente) {
		super();
		this.login = cliente.getLogin();
		this.nombre = cliente.getNombre();
		this.datosBancarios = cliente.getDatosBancarios();		
	}
	
	public ClienteDTO() {
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

	public Cliente asCliente() {
		return new Cliente(null,login,nombre,datosBancarios);
	}
	
}
