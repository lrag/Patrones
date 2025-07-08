package com.curso.modelo.negocio.excepcion;

public class ExistenciasException extends Exception {

	private String producto;
	private int cantidadSolicitada;
	private int existencias;

	public ExistenciasException(String message) {
		super(message);
	}
}