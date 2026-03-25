package com.curso.modelo.comandos;

import com.curso.modelo.entidad.Producto;
import com.curso.modelo.negocio.ServicioProductos;

public class ComandoModificarProducto implements Comando {

	private Producto producto;
	private ServicioProductos servicioProductos;
	
	public ComandoModificarProducto( Producto producto, ServicioProductos servicioProductos) {
		super();
		this.producto = producto;
		this.servicioProductos = servicioProductos;		
	}
	
	@Override
	public void ejecutar() {
		servicioProductos.modificar(producto);
	}
	
}
