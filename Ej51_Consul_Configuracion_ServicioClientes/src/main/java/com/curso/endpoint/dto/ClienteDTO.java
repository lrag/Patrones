package com.curso.endpoint.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.curso.modelo.entidad.Cliente;

@Entity
public class ClienteDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String login;
	private String nombre;
	private String direccion;
	private String telefono;
	private String correoE;
	private String datosBancarios;

	public ClienteDTO() {
		super();
	}

	public ClienteDTO(String login, String nombre, String direccion, String telefono, String correoE,
			String datosBancarios) {
		super();
		this.login = login;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoE = correoE;
		this.datosBancarios = datosBancarios;
	}
	
	public ClienteDTO(Cliente cliente) {
		super();
		this.login = cliente.getLogin();
		this.nombre = cliente.getNombre();
		this.direccion = cliente.getDireccion();
		this.telefono = cliente.getTelefono();
		this.correoE = cliente.getCorreoE();
		this.datosBancarios = cliente.getDatosBancarios();		
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
	
	public Cliente asCliente() {
		return new Cliente(null,login,nombre,direccion,telefono,correoE,datosBancarios);
	}

}
