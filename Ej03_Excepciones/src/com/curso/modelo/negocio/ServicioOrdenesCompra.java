package com.curso.modelo.negocio;

import java.util.Arrays;
import java.util.List;

import com.curso.modelo.negocio.excepcion.ExistenciasException;
import com.curso.modelo.negocio.excepcion.OrdenCompraException;

public class ServicioOrdenesCompra {
	
	private ServicioAlmacen servicioAlmacen; 

	public void aceptarOrdenDeCompra() throws Exception {
		//Comprobación 1
		//Comprobación 2
		//Comprobación 3
		
		List<String> almacenes = Arrays.asList("Almacen1", "Almacen2", "Almacen3");
		boolean hayExistencias = false;
		for(String almacen: almacenes) {
			try {
				servicioAlmacen.comprobarExistencias(almacen);
				hayExistencias = true;
			} catch (ExistenciasException e) {
				System.out.println("Probando otro almacen");
			}
		}
		if(!hayExistencias) {
			throw new OrdenCompraException("No hay existencias");
		}
		
	}

}
