package com.curso.problema;

import com.curso.Matriculacion;

public class CursoPresencial extends Curso {

	protected String aula;

	public CursoPresencial() {
		super();
	}

	public CursoPresencial(String titulo, String duracion, String profesor, String aula) {
		super(titulo,duracion,profesor);
		this.aula = aula;
	}

	@Override
	public String toString() {
		return super.toString()+", aula: " +aula+"]";
	}

	public void matricularAlumno(Alumno alumno) {
		System.out.println("Matriculando a "+alumno+" en Curso Presencial");
	}
	
}
