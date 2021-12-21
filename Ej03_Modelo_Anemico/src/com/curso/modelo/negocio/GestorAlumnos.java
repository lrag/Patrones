package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Alumno;
import com.curso.modelo.entidad.Curso;

public class GestorAlumnos {

	public void matricularAlumnoEnCurso(Alumno alumno, Curso curso) {
		curso.matricularAlumno(alumno);
	}
	
}
