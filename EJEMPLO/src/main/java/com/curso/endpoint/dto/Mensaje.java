package com.curso.endpoint.dto;

public class Mensaje {

	private String codigo;
	private String mensaje;

	public Mensaje() {
		super();
	}

	public Mensaje(String codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "Mensaje [codigo=" + codigo + ", mensaje=" + mensaje + "]";
	}

}
