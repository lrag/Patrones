package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Alumno;
import com.curso.modelo.entidad.Curso;

public class ServicioAlumnos {

	public void matricularAlumnoEnCurso(Alumno alumno, Curso curso) {
		curso.matricularAlumno(alumno);
	}
	
}
