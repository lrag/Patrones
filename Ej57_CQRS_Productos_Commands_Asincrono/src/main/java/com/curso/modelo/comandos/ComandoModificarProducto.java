package com.curso.modelo.comandos;

import com.curso.modelo.entidad.Producto;
import com.curso.modelo.negocio.GestorProductos;

public class ComandoModificarProducto implements Comando {

	private Producto producto;
	private GestorProductos gestorProductos;
	
	public ComandoModificarProducto( Producto producto, GestorProductos gestorProductos) {
		super();
		this.producto = producto;
		this.gestorProductos = gestorProductos;		
	}
	
	@Override
	public void ejecutar() {
		gestorProductos.modificar(producto);
	}
	
}
