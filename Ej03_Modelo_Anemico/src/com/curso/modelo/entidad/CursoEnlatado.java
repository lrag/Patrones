package com.curso.modelo.entidad;

import java.util.ArrayList;
import java.util.List;

//@Component
//@Scope("prototype")
//@Entity
public class CursoEnlatado extends Curso{

	private Integer id;
	private String codigo;
	private String titulo;
	private Integer plazas = 0;

	private List<Alumno> alumnos = new ArrayList<>();

	public CursoEnlatado() {
		super();
	}

	public CursoEnlatado(Integer id, String codigo, String titulo, Integer plazas, List<Alumno> alumnos) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.titulo = titulo;
		this.plazas = plazas;
		this.alumnos = alumnos;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getPlazas() {
		return plazas;
	}

	public void setPlazas(Integer plazas) {
		this.plazas = plazas;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public void matricularAlumno(Alumno alumno) {
		//LN
		System.out.println("Matriculando a un alumno en un curso enlatado");
		//Aqui no hay límite de aforo
	}	
	
	@Override
	public String toString() {
		return "Curso [id=" + id + ", codigo=" + codigo + ", titulo=" + titulo + ", plazas=" + plazas + ", alumnos="
				+ alumnos + "]";
	}

}
