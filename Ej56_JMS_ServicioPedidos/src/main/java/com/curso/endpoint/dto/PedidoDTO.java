package com.curso.endpoint.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.curso.modelo.entidad.Pedido;

public class PedidoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String fecha;
	private String estado;
	private Double total;
	private ClienteDTO cliente;
	private List<DetallePedidoDTO> detalles;

	public PedidoDTO() {
		super();
	}

	public PedidoDTO(String codigo, String fecha, String estado, Double total, ClienteDTO cliente,
			List<DetallePedidoDTO> detalles) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.estado = estado;
		this.total = total;
		this.cliente = cliente;
		this.detalles = detalles;
	}

	public PedidoDTO(Pedido pedido) {
		super();
		this.codigo = pedido.getCodigo();
		this.fecha = pedido.getFecha();
		this.estado = pedido.getEstado();
		this.total = pedido.getTotal();
		this.cliente = new ClienteDTO(pedido.getCliente());
		this.detalles = pedido.getDetalles().stream().map(dp -> new DetallePedidoDTO(dp)).collect(Collectors.toList());		
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

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public List<DetallePedidoDTO> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetallePedidoDTO> detalles) {
		this.detalles = detalles;
	}
	
	public Pedido asPedido() {
		return new Pedido(null,codigo,fecha,estado,total,cliente.asCliente()
				         ,detalles.stream().map(dp -> dp.asDetallePedido()).collect(Collectors.toList()));
	}

}
