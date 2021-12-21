package com.curso.endpoint.dto;

import java.util.List;

import com.curso.modelo.entidad.CalificacionProducto;
import com.curso.modelo.entidad.Producto;

public class ProductoDTO {

	private String codigo;
	private String nombre;
	private String imagen;
	private String fabricante;
	private Double precio;
	private List<CalificacionProducto> calificaciones;

	public ProductoDTO() {
		super();
	}

	public ProductoDTO(String codigo, String nombre, String imagen, String fabricante, Double precio,
			List<CalificacionProducto> calificaciones) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.imagen = imagen;
		this.fabricante = fabricante;
		this.precio = precio;
		this.calificaciones = calificaciones;
	}

	public ProductoDTO(Producto producto) {
		super();
		this.codigo     = producto.getCodigo();
		this.nombre     = producto.getNombre();
		this.imagen     = producto.getImagen();
		this.fabricante = producto.getFabricante();
		this.precio     = producto.getPrecio();
		this.calificaciones = producto.getCalificaciones();
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public List<CalificacionProducto> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<CalificacionProducto> calificaciones) {
		this.calificaciones = calificaciones;
	}

	@Override
	public String toString() {
		return "ProductoDTO [ codigo=" + codigo + ", nombre=" + nombre + ", imagen=" + imagen
				+ ", fabricante=" + fabricante + ", precio=" + precio + ", calificaciones=" + calificaciones + "]";
	}
	
	public Producto asProducto() {
		return new Producto(null,codigo,nombre,fabricante,imagen,precio,calificaciones);
	}
	
}
