package com.curso;

public class CursoEnlatado extends Curso {

	protected String aula;

	public CursoEnlatado() {
		super();
	}
	
	public CursoEnlatado(Matriculacion matriculacion) {
		super(matriculacion);
	}

	public CursoEnlatado(String titulo, String duracion, String profesor, String aula, Matriculacion matriculacion) {
		super(titulo, duracion, profesor, matriculacion);
		this.aula = aula;
	}

	@Override
	public String toString() {
		return super.toString() + ", aula: " + aula + "]";
	}

	public void matricularAlumno(Alumno alumno) {
		System.out.println("Matriculando a " + alumno + " en Curso enlatado");
		// Ln...
		matriculacion.matricular(alumno, this);
	}

}
