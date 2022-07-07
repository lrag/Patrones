package com.curso.modelo.comandos;

import com.curso.modelo.entidad.Producto;
import com.curso.modelo.negocio.GestorProductos;

public class ComandoInsertarProducto implements Comando {

	private Producto producto;
	private GestorProductos gestorProductos;
	
	public ComandoInsertarProducto(Producto producto, GestorProductos gestorProductos) {
		super();
		this.producto = producto;
		this.gestorProductos = gestorProductos;		
	}

	@Override
	public void ejecutar() {
		gestorProductos.insertar(producto);
	}
	
}
