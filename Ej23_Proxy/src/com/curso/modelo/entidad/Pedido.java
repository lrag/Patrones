package com.curso.modelo.entidad;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String codigo;
	private LocalDate fecha;
	private String estado;

	@ManyToOne
	@JoinColumn(name = "fk_id_cliente", referencedColumnName = "id")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<DetallePedido> detalles;
	
	private String camion;
	@Transient
	private String regalo;

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

	public String getCamion() {
		return camion;
	}

	public void setCamion(String camion) {
		this.camion = camion;
	}
	
	public String getRegalo() {
		return regalo;
	}

	public void setRegalo(String regalo) {
		this.regalo = regalo;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", codigo=" + codigo + ", fecha=" + fecha + ", estado=" + estado + ", cliente="
				+ cliente + ", camion=" + camion + "]";
	}

	public void addDetalle(DetallePedido detalle) {
		//LN para añadir el detalle
		detalles.add(detalle);
	}
	
}
