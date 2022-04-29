package com.curso.modelo.comandos;

import com.curso.modelo.entidad.Producto;
import com.curso.modelo.negocio.GestorProductos;

public class ComandoBorrarProducto implements Comando {

	private String referencia;
	private GestorProductos gestorProductos;
	
	public ComandoBorrarProducto(String referencia, GestorProductos gestorProductos) {
		super();
		this.referencia = referencia;
		this.gestorProductos = gestorProductos;
	}

	@Override
	public void ejecutar() {
		gestorProductos.borrar(referencia);
	}
	
}
