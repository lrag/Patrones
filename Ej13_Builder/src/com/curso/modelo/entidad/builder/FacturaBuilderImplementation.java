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

	//El builder tiene un estado. Lo utilizará para crear la factura
	//El builder NO ES UNA FACTURA
	private int id;
	private String codigo;
	private LocalDate fecha;
	private Cliente cliente;
	private List<DetalleFactura> detalles = new ArrayList<>();
	private List<CobroFactura> cobros = new ArrayList<>();
	private List<EventoFactura> eventos = new ArrayList<>();	
	
	public FacturaBuilderImplementation() {
		super();
	}

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
	public FacturaBuilder codigo(String codigo) {
		this.codigo = codigo;
		return this;
	}
	
	@Override
	public FacturaBuilder fecha(LocalDate fecha) {
		this.fecha = fecha;
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
		Factura f = new Factura();
		f.setId(id);
		f.setCodigo(codigo);
		f.setFecha(fecha);
		f.setCliente(cliente);
		f.setDetalles(detalles);
		f.setCobros(cobros);
		f.setEventos(eventos);
		return f;		
	}

}
