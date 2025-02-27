package com.curso.endpoint.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import com.curso.modelo.entidad.Pelicula;

public class PeliculaDTO {

	private Integer id;
	@NotEmpty
	private String titulo;
	@NotEmpty
	private String director;
	private String genero;
	@Min(1900)
	private Integer year;

	public PeliculaDTO() {
		super();
	}

	public PeliculaDTO(Integer id, String titulo, String director, String genero, Integer year) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.director = director;
		this.genero = genero;
		this.year = year;
	}
	
	public PeliculaDTO(Pelicula pelicula) {
		id       = pelicula.getId();
		titulo   = pelicula.getTitulo();
		director = pelicula.getDirector();
		genero   = pelicula.getGenero();
		year     = pelicula.getYear();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	public Pelicula asPelicula() {
		return new Pelicula(id, titulo, director, genero, year);
	}

	@Override
	public String toString() {
		return "PeliculaDTO [id=" + id + ", titulo=" + titulo + ", director=" + director + ", genero=" + genero + ", year="
				+ year + ", getId()=" + getId() + ", getTitulo()=" + getTitulo() + ", getDirector()=" + getDirector()
				+ ", getGenero()=" + getGenero() + ", getYear()=" + getYear() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
