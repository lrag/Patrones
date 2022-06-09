package com.curso.modelo.entidad;

import java.util.ArrayList;
import java.util.List;

//@Component
//@Scope("prototype")
//@Entity
public abstract class Curso {

	protected Integer id;
	protected String codigo;
	protected String titulo;
	protected Integer plazas = 10; //Para simplificar

	protected List<Alumno> alumnos = new ArrayList<>(); // Por poner algo...

	public Curso() {
		super();
	}

	public Curso(Integer id, String codigo, String titulo, Integer plazas, List<Alumno> alumnos) {
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
		if (plazas < 1) {
			throw new RuntimeException("El número de plazas no puede ser negativo");
		}
		this.plazas = plazas;
	}

	public final List<Alumno> getAlumnos() {
		// Aqui deberíamos devolver una copia de la lista y de los alumnos
		return alumnos;
	}

	public final void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public abstract void matricularAlumno(Alumno alumno);

	@Override
	public String toString() {
		return "Curso [id=" + id + ", codigo=" + codigo + ", titulo=" + titulo + ", plazas=" + plazas + ", alumnos="
				+ alumnos + "]";
	}

}
