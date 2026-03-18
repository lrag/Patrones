package com.curso.modelo.comandos;

import com.curso.modelo.entidad.Producto;
import com.curso.modelo.negocio.ServicioProductos;

public class ComandoInsertarProducto implements Comando {

	private Producto producto;
	private ServicioProductos gestorProductos;
	
	public ComandoInsertarProducto(Producto producto, ServicioProductos gestorProductos) {
		super();
		this.producto = producto;
		this.gestorProductos = gestorProductos;		
	}

	@Override
	public void ejecutar() {
		gestorProductos.insertar(producto);
	}
	
}
