package com.curso.problema;

public class CursoOnline extends Curso {

	protected String aula;

	public CursoOnline() {
		super();
	}

	public CursoOnline(String titulo, String duracion, String profesor, String aula) {
		super(titulo,duracion,profesor);
		this.aula = aula;
	}

	@Override
	public String toString() {
		return super.toString()+", aula: " +aula+"]";
	}

	public void matricularAlumno(Alumno alumno) {
		System.out.println("Matriculando a "+alumno+" en Curso online");
	}
	
}
