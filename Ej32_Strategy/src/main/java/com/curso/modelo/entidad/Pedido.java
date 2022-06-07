package com.curso.modelo.entidad;

import java.time.LocalDate;
import java.util.Formatter;
import java.util.List;
import java.util.stream.Collectors;

public class Pedido {
	
	private Integer id;
	private String codigo;
	private LocalDate fecha;
	private String estado;
	private Cliente cliente;
	private List<DetallePedido> detalles;
	private Double total;
	private Double descuento;
	
	public Pedido() {
		super();
	}

	public Pedido(Integer id, String codigo, LocalDate fecha, String estado, Cliente cliente,
			List<DetallePedido> detalles) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.fecha = fecha;
		this.estado = estado;
		this.cliente = cliente;
		this.detalles = detalles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetallePedido> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetallePedido> detalles) {
		this.detalles = detalles;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", codigo=" + codigo + ", fecha=" + fecha + ", estado=" + estado + ", cliente="
				+ cliente + ", detalles=" + detalles + ", total=" + total + ", descuento=" + descuento + "]";
	}
	
	public void calcularTotal() {
		total = detalles
			.stream()
			.collect(Collectors.summarizingDouble(dp -> (dp.getPrecio()-dp.getPrecio()*dp.getDescuento()/100)*dp.getCantidad()))
			.getSum();
	}

	public void addDetalle(DetallePedido detalle) {
		//LN para añadir el detalle
		detalles.add(detalle);
		calcularTotal();
	}
	
	public String formatear() {		
		StringBuilder sb =new StringBuilder()
			.append("PEDIDO:"+codigo+"\n")
			.append("Fecha:"+fecha+"\n")
			.append("Cliente:"+cliente.getNombre()+"\n")
			.append("-------------------------------------------"+"\n");
		
	    Formatter fm = new Formatter(sb);
		for(DetallePedido dp: detalles) {
			fm.format("%-15s %10d %6.2f %6.2f \n", dp.getProducto().getNombre(), dp.getCantidad(), dp.getPrecio(), dp.getDescuento());
		}
		sb.append("Total    :"+total+"\n");
		sb.append("Descuento:"+descuento+"\n");
		
		return sb.toString();
	}
	
}
