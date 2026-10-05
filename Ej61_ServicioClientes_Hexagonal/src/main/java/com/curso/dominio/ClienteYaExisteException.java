package com.curso.dominio;

public class ClienteYaExisteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteYaExisteException(String login) {
		super("Ya existe un cliente con login " + login);
	}

}
