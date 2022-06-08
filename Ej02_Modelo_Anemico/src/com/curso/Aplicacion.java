package com.curso;

import com.curso.modelo.entidad.Alumno;
import com.curso.modelo.entidad.Curso;
import com.curso.modelo.entidad.CursoEnlatado;
import com.curso.modelo.entidad.CursoOnline;
import com.curso.modelo.entidad.CursoPresencial;
import com.curso.modelo.negocio.ServicioAlumnos;

public class Aplicacion {

	public static void main(String[] args) {
		
		Alumno a1 = new Alumno();
		Alumno a2 = new Alumno();
		Alumno a3 = new Alumno();

		Curso c1 = new CursoPresencial();
		Curso c2 = new CursoOnline();
		Curso c3 = new CursoEnlatado();
		
		System.out.println("=================================");
		c1.matricularAlumno(a1);
		c2.matricularAlumno(a2);
		c3.matricularAlumno(a3);		
		
		System.out.println("=================================");
		ServicioAlumnos ga = new ServicioAlumnos();
		ga.matricularAlumnoEnCurso(a1, c1);
		ga.matricularAlumnoEnCurso(a2, c2);
		ga.matricularAlumnoEnCurso(a3, c3);
		
		
	}
	
}
