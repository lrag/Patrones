package com.curso.modelo.entidad;

public class CalificacionProducto {

	private Integer id;
	private String codigoProducto;
	private String nombre;
	private String autor;
	private Integer nota;
	private String comentario;
	private String fecha;

	public CalificacionProducto() {
		super();
	}

	public CalificacionProducto(Integer id, String codigoProducto, String nombre, Integer nota, String autor, String comentario,
			String fecha) {
		super();
		this.id = id;
		this.codigoProducto = codigoProducto;
		this.nombre = nombre;
		this.autor = autor;
		this.nota = nota;
		this.comentario = comentario;
		this.fecha = fecha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigo) {
		this.codigoProducto = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "CalificacionProducto [id=" + id + ", codigoProducto=" + codigoProducto + ", nombre=" + nombre + ", autor=" + autor
				+ ", nota=" + nota + ", comentario=" + comentario + ", fecha=" + fecha + "]";
	}

}
