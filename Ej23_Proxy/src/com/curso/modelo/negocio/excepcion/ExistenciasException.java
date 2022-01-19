package com.curso.modelo.negocio.excepcion;

import com.curso.modelo.entidad.Producto;

public class ExistenciasException extends Exception {

	private Producto producto;
	private Integer existenciasSolicitadas;
	private Integer existencias;

	public ExistenciasException(Producto producto, Integer existenciasSolicitadas, Integer existencias) {
		super("No hay existencias del producto " + producto.getNombre());
		this.producto               = producto;
		this.existenciasSolicitadas = existenciasSolicitadas;
		this.existencias            = existencias;
	}

	public Producto getProducto() {
		return producto;
	}

	public Integer getExistenciasSolicitadas() {
		return existenciasSolicitadas;
	}

	public Integer getExistencias() {
		return existencias;
	}

}
