package com.curso;

import java.util.List;

public abstract class Curso {

	protected String titulo;
	protected String duracion;
	protected String profesor;
	protected List<Alumno> alumnos;
	
	protected Matriculacion matriculacion;

	public Curso() {
		super();
	}
	
	public Curso(Matriculacion matriculacion) {
		super();
		this.matriculacion = matriculacion;
	}

	public Curso(String titulo, String duracion, String profesor, Matriculacion matriculacion) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.profesor = profesor;
		this.matriculacion = matriculacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "Curso [titulo=" + titulo + ", duracion=" + duracion + ", profesor=" + profesor + ", alumnos=" + alumnos
				+ "]";
	}

	public abstract void matricularAlumno(Alumno alumno);
	
}
