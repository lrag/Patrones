package com.curso.modelo.negocio;

import com.curso.modelo.persistencia.FacturaRepositorio;

public class FactoriaServicioFacturas {

	private static ServicioFacturas servicioFacturas;
	
	public static ServicioFacturas getServicioFacturas(FacturaRepositorio facturaRepo) {
		if(servicioFacturas == null) {
			servicioFacturas = new ServicioFacturas(facturaRepo);
		}
		return servicioFacturas;
	}
	
}
