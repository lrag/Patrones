package com.curso.modelo.entidad.builder;

import java.time.LocalDate;
import java.util.List;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.CobroFactura;
import com.curso.modelo.entidad.DetalleFactura;
import com.curso.modelo.entidad.EventoFactura;
import com.curso.modelo.entidad.Factura;

public interface FacturaBuilder {

	FacturaBuilder id(int id);
	FacturaBuilder codigo(String codigo);
	FacturaBuilder fecha(LocalDate fecha);
	FacturaBuilder cliente(Cliente cliente);
	FacturaBuilder detalles(List<DetalleFactura> detalles);
	FacturaBuilder cobros(List<CobroFactura> cobros);
	FacturaBuilder eventos(List<EventoFactura> eventos);
	Factura build();
	
}
