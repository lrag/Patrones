package com.curso.modelo.entidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Factura {

	private int id;
	private String codigo;
	private LocalDate fecha;
	private Cliente cliente;
	private List<DetalleFactura> detalles = new ArrayList<>();
	private List<CobroFactura> cobros = new ArrayList<>();
	private List<EventoFactura> eventos = new ArrayList<>();
	
	private double total;

	/*
	//En vez de tener 400 constructores...
	public Factura() {
		super();
	}

	public Factura(int id, String codigo, LocalDate fecha, Cliente cliente) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.fecha = fecha;
		this.cliente = cliente;
	}
	
	public Factura(int id, String codigo, LocalDate fecha, Cliente cliente, List<DetalleFactura> detalles, List<CobroFactura> cobros, List<EventoFactura> eventos) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.fecha = fecha;
		this.cliente = cliente;
		setDetalles(detalles);
		this.cobros = cobros,
		this.eventos = eventos;
	}

	public Factura(int id, String codigo, LocalDate fecha, Cliente cliente, List<DetalleFactura> detalles) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.fecha = fecha;
		this.cliente = cliente;
		setDetalles(detalles);
		this.cobros = cobros,
		this.eventos = eventos;
	}
	
	//...
	
	*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		detalles.forEach(df -> addDetalle(df));
	}
	
	public void addDetalle(DetalleFactura nuevoDetalle) {		
		detalles
			.stream()
			.filter(detalle -> isIgualitos(detalle,nuevoDetalle) )
			.findAny()
			.ifPresentOrElse(
				detalle -> {	
					detalle.setCantidad(detalle.getCantidad()+nuevoDetalle.getCantidad());
				}, 
				() -> detalles.add(nuevoDetalle)				
			);		
		calcularTotal();
	}

	private boolean isIgualitos(DetalleFactura df1, DetalleFactura df2) {
		return df1.getProducto().getId()==df2.getProducto().getId() && df1.getPrecio()==df2.getPrecio();
	}
	
	public List<CobroFactura> getCobros() {
		return cobros;
	}

	public void setCobros(List<CobroFactura> cobros) {
		this.cobros = cobros;
	}

	public List<EventoFactura> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoFactura> eventos) {
		this.eventos = eventos;
	}

	public double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", codigo=" + codigo + ", fecha=" + fecha + ", total="+total+", cliente=" + cliente.getCodigo()
				+ ", detalles=" + detalles.size() + "]";
	}
	
	private void calcularTotal() {
		total = detalles
			.stream()
			.mapToDouble(df -> df.getCantidad()*df.getPrecio())
			.sum();
	}

}
