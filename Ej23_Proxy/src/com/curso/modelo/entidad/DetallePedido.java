package com.curso.modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalles_pedidos")
public class DetallePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "fk_id_pedido", referencedColumnName = "id")	
	private Pedido pedido;
	@ManyToOne
	@JoinColumn(name = "fk_id_producto", referencedColumnName = "id")
	private Producto producto;
	private Double precio;
	private Integer cantidad;

	public DetallePedido() {
		super();
	}

	public DetallePedido(Integer id, Pedido pedido, Producto producto, Double precio, Integer cantidad) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "DetallePedido [id=" + id + ", pedido=" + pedido + ", producto=" + producto + ", precio=" + precio
				+ ", cantidad=" + cantidad + "]";
	}

}
