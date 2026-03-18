package com.curso.modelo.comandos;

import com.curso.modelo.negocio.ServicioProductos;

public class ComandoBorrarProducto implements Comando {

	private String referencia;
	private ServicioProductos gestorProductos;
	
	public ComandoBorrarProducto(String referencia, ServicioProductos gestorProductos) {
		super();
		this.referencia = referencia;
		this.gestorProductos = gestorProductos;
	}

	@Override
	public void ejecutar() {
		gestorProductos.borrar(referencia);
	}
	
}
