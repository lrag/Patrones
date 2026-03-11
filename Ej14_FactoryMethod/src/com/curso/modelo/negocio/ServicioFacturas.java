package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Factura;
import com.curso.modelo.persistencia.FacturaRepositorio;

public class ServicioFacturas {
	
	///////////////////////////////////////
	//ESTE NO ES UN SINGLETÓN//////////////
	//Y TIENE INYECCIÓN DE DEPENDENCIAS////
	///////////////////////////////////////
	
	private FacturaRepositorio facturaRepo;
	
	public ServicioFacturas(FacturaRepositorio facturaRepo) {
		super();
		this.facturaRepo = facturaRepo;
	}	
	
	public void insertar(Factura factura) {
		System.out.println("=====================================");
		System.out.println("Insertando en GestorFacturas");
		System.out.println("Factura:"+factura);
		//LN...
		facturaRepo.insertar(factura);
	}

	
}
