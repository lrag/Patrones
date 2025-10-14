package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Producto;

public interface ServicioProductos {

	/*
	{
		id : null
		nombre : "X"
		fabricante: {
			id: 12
		}	
	}
	*/
	void insertar(Producto producto);

	void modificar(Producto producto);

	void borrar(String referencia);

}