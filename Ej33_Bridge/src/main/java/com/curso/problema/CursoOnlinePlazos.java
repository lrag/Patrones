package com.curso.problema;

public class CursoOnlinePlazos extends Curso {

	protected String aula;

	public CursoOnlinePlazos() {
		super();
	}

	public CursoOnlinePlazos(String titulo, String duracion, String profesor, String aula) {
		super(titulo,duracion,profesor);
		this.aula = aula;
	}

	@Override
	public String toString() {
		return super.toString()+", aula: " +aula+"]";
	}

	public void matricularAlumno(Alumno alumno) {
		System.out.println("Matriculando a "+alumno+" en Curso online a plazos");
	}
	
}
