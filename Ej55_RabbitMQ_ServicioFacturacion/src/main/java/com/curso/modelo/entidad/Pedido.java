package com.curso.modelo.entidad;

import java.util.List;
import java.util.stream.Collectors;

import com.curso.modelo.entidad.Pedido;

public class Pedido {

	private String codigo;
	private String fecha;
	private String estado;
	private Double total;
	private Cliente cliente;
	private List<DetallePedido> detalles;

	public Pedido() {
		super();
	}

	public Pedido(String codigo, String fecha, String estado, Double total, Cliente cliente,
			List<DetallePedido> detalles) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.estado = estado;
		this.total = total;
		this.cliente = cliente;
		this.detalles = detalles;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
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

	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", fecha=" + fecha + ", estado=" + estado + ", total=" + total
				+ ", cliente=" + cliente + ", detalles=" + detalles + "]";
	}

}
