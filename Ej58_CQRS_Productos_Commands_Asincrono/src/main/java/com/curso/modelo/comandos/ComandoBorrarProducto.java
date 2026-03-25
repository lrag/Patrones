package com.curso.modelo.comandos;

import com.curso.modelo.negocio.ServicioProductos;

public class ComandoBorrarProducto implements Comando {

	private String referencia;
	private ServicioProductos servicioProductos;
	
	public ComandoBorrarProducto(String referencia, ServicioProductos servicioProductos) {
		super();
		this.referencia = referencia;
		this.servicioProductos = servicioProductos;
	}

	@Override
	public void ejecutar() {
		servicioProductos.borrar(referencia);
	}
	
}
