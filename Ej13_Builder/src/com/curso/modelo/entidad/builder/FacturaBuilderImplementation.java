package com.curso.modelo.entidad.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.CobroFactura;
import com.curso.modelo.entidad.DetalleFactura;
import com.curso.modelo.entidad.EventoFactura;
import com.curso.modelo.entidad.Factura;

public class FacturaBuilderImplementation implements FacturaBuilder{

	private int id;
	private String codigo;
	private LocalDate fecha;
	private Cliente cliente;
	private List<DetalleFactura> detalles = new ArrayList<>();
	private List<CobroFactura> cobros = new ArrayList<>();
	private List<EventoFactura> eventos = new ArrayList<>();	
	
	public FacturaBuilderImplementation(String codigo, LocalDate fecha) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
	}

	@Override
	public FacturaBuilder id(int id) {
		this.id = id;
		return this;
	}
	
	@Override
	public FacturaBuilder cliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}
	
	@Override
	public FacturaBuilder detalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
		return this;
	}
	
	@Override
	public FacturaBuilder cobros(List<CobroFactura> cobros) {
		this.cobros = cobros;
		return this;
	}
	
	@Override
	public FacturaBuilder eventos(List<EventoFactura> eventos) {
		this.eventos = eventos;
		return this;
	}
	
	@Override
	public Factura build() {
		return new Factura(id, codigo, fecha, cliente, detalles, cobros, eventos);
	}

}
