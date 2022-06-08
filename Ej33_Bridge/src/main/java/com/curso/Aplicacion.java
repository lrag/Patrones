package com.curso;

public class Aplicacion {

	public static void main(String[] args) {
	
		Matriculacion m1 = new MatriculacionImpl();
		Matriculacion m2 = new MatriculacionSubvencionadaImpl();
		Matriculacion m3 = new MatriculacionPlazosImpl();
		
		Curso c1 = new CursoPresencial(m1);		
		Curso c2 = new CursoPresencial(m2);		
		Curso c3 = new CursoPresencial(m3);		

		Curso c4 = new CursoOnline(m1);
		Curso c5 = new CursoOnline(m2);
		Curso c6 = new CursoOnline(m3);

		Curso c7 = new CursoEnlatado(m1);		
		Curso c8 = new CursoEnlatado(m2);		
		Curso c9 = new CursoEnlatado(m3);		
		
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
