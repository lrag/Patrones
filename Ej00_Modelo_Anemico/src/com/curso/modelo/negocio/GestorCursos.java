package com.curso.modelo.negocio;

import java.util.List;

import com.curso.modelo.entidad.Alumno;
import com.curso.modelo.entidad.Curso;
import com.curso.modelo.repositorio.MatriculaRepository;


public class GestorCursos {

	private MatriculaRepository matriculaRepo;
	
	public void insertarCurso(Curso curso) {
		//LN
		//...
		//cursoRepo.save(curso)
	}
	
	public void modificarCurso(Curso curso) {
		//LN
		//...		
	}
	
	public void borrarCurso(Curso curso) {
		//LN
		//...		
	}	
	
	//MODELO ANÉMICO
	public void matricularAlumno(Alumno alumno, Curso curso) {		
		
		List<Alumno> alumnos = curso.getAlumnos();
		if(alumnos.size()<curso.getPlazas()) {
			alumnos.add(alumno);
		}
		
		matriculaRepo.save("matricula");	
	}
	
	/*
	
	
	
	
	
	
	

	public void matricularAlumno(Alumno alumno, Curso curso) {		
		//OO
		curso.matricularAlumno(alumno);
	}	
	
	
	
	*/
	
}
