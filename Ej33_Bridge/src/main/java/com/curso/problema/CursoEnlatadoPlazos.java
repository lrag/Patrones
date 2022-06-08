package com.curso.problema;

public class CursoEnlatadoPlazos extends Curso {

	protected String aula;

	public CursoEnlatadoPlazos() {
		super();
	}

	public CursoEnlatadoPlazos(String titulo, String duracion, String profesor, String aula) {
		super(titulo,duracion,profesor);
		this.aula = aula;
	}

	@Override
	public String toString() {
		return super.toString()+", aula: " +aula+"]";
	}

	public void matricularAlumno(Alumno alumno) {
		System.out.println("Matriculando a "+alumno+" en Curso enlatado a plazos");
	}
	
}
