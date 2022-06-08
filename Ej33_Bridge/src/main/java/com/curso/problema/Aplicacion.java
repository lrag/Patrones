package com.curso.problema;

public class Aplicacion {

	public static void main(String[] args) {
	
		Curso c1 = new CursoPresencial();
		Curso c2 = new CursoPresencialSubvencionado();
		Curso c3 = new CursoPresencialPlazos();

		Curso c4 = new CursoOnline();
		Curso c5 = new CursoOnlineSubvencionado();
		Curso c6 = new CursoOnlinePlazos();

		Curso c7 = new CursoEnlatado();
		Curso c8 = new CursoEnlatadoSubvencionado();
		Curso c9 = new CursoEnlatadoPlazos();
		
		Alumno a = new Alumno(1,"Ringo Starr","C/Tal,123","123456789");
		c1.matricularAlumno(a);
		c2.matricularAlumno(a);
		c3.matricularAlumno(a);
		c4.matricularAlumno(a);
		c5.matricularAlumno(a);
		c6.matricularAlumno(a);
		c7.matricularAlumno(a);
		c8.matricularAlumno(a);
		c9.matricularAlumno(a);
		
	}
	
}
