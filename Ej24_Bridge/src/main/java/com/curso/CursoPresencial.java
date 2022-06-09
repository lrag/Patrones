package com.curso;

public class CursoPresencial extends Curso {

	protected String aula;

	public CursoPresencial() {
		super();
	}

	public CursoPresencial(Matriculacion matriculacion) {
		super(matriculacion);
	}

	public CursoPresencial(String titulo, String duracion, String profesor, Matriculacion matriculacion, String aula) {
		super(titulo, duracion, profesor, matriculacion);
		this.aula = aula;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	@Override
	public String toString() {
		return super.toString() + ", aula: " + aula + "]";
	}

	public void matricularAlumno(Alumno alumno) {
		System.out.println("Matriculando a " + alumno + " en Curso Presencial");
		// ...
		matriculacion.matricular(alumno, this);
	}

}
