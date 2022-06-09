package com.curso.problema;

public class CursoPresencialPlazos extends Curso {

	protected String aula;

	public CursoPresencialPlazos() {
		super();
	}

	public CursoPresencialPlazos(String titulo, String duracion, String profesor, String aula) {
		super(titulo,duracion,profesor);
		this.aula = aula;
	}

	@Override
	public String toString() {
		return super.toString()+", aula: " +aula+"]";
	}

	public void matricularAlumno(Alumno alumno) {
		System.out.println("Matriculando a "+alumno+" en Curso Presencial plazos");
	}
	
}
