package com.curso;

public class CursoOnline extends Curso {

	protected String url;

	public CursoOnline() {
		super();
	}
	
	public CursoOnline(Matriculacion matriculacion) {
		super(matriculacion);
	}

	public CursoOnline(String titulo, String duracion, String profesor, String aula, Matriculacion matriculacion,
			String url) {
		super(titulo, duracion, profesor, matriculacion);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return super.toString() + ", url: " + url + "]";
	}

	public void matricularAlumno(Alumno alumno) {
		System.out.println("Matriculando a " + alumno + " en Curso online");
		// ...
		matriculacion.matricular(alumno, this);
	}

}
