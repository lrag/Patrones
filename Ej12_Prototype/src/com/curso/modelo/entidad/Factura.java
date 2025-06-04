package com.curso.modelo.entidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Factura implements Cloneable {

	private int id;
	private String codigo;
	private LocalDate fecha;
	private Cliente_ActiveRecord cliente;
	private List<DetalleFactura> detalles = new ArrayList<>();
	
	//Solo tiene get
	private double total;
	
	public Factura() {
		super();
	}

	public Factura(int id, String codigo, LocalDate fecha, Cliente_ActiveRecord cliente) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.fecha = fecha;
		this.cliente = cliente;
	}
	
	public Factura(int id, String codigo, LocalDate fecha, Cliente_ActiveRecord cliente, List<DetalleFactura> detalles) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.fecha = fecha;
		this.cliente = cliente;
		setDetalles(detalles);
	}

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

	public Cliente_ActiveRecord getCliente() {
		return cliente;
	}

	public void setCliente(Cliente_ActiveRecord cliente) {
		this.cliente = cliente;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		detalles.forEach(df -> addDetalle(df));
	}
	
	//Para evitar el modelo anémico
	public void addDetalle(DetalleFactura detalle) {		
		detalles
			.stream()
			.filter(df -> {
				return df.getProducto().getId()==detalle.getProducto().getId() && df.getPrecio()==detalle.getPrecio();
			})
			.findAny()
			.ifPresentOrElse(
				df -> {	
					df.setCantidad(df.getCantidad()+detalle.getCantidad());
				}, 
				() -> {
					detalles.add(detalle);
				}
			);
		
		calcularTotal();
	}
	
	public double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return super.toString()+" [id=" + id + ", codigo=" + codigo + ", fecha=" + fecha + ", total="+total+", cliente=" + cliente.getCodigo()
				+ ", detalles=" + detalles.size() + "]";
	}
	
	@Override
	public Object clone() {
		Factura clon = new Factura(id,codigo,fecha,(Cliente_ActiveRecord) cliente.clone());
		clon.total = total;
		List<DetalleFactura> clonDetalles = 
			detalles
			.stream()
			.map(df -> (DetalleFactura) df.clone())
			.collect(Collectors.toList());
		clon.detalles = clonDetalles;
		return clon;		
	}
	
	private void calcularTotal() {
		total = detalles
			.stream()
			.mapToDouble(df -> df.getCantidad()*df.getPrecio())
			.sum();
	}

}


class ServicioFacturas {
	
	
	public void addDetalleFactura(DetalleFactura detalle, Factura factura) {
		
		/*
		//Con modelo anémico:
		List<DetalleFactura> detalles = factura.getDetalles();
		detalles
			.stream()
			.filter(df -> {
				return df.getProducto().getId()==detalle.getProducto().getId() && df.getPrecio()==detalle.getPrecio();
			})
			.findAny()
			.ifPresentOrElse(
				df -> {	
					df.setCantidad(df.getCantidad()+detalle.getCantidad());
				}, 
				() -> {
					detalles.add(detalle);
				}
			);
		factura.calcularTotal();
		*/
		
		factura.addDetalle(detalle);
	}
	
}


