package com.curso.modelo.negocio;

import java.util.List;

import com.curso.modelo.entidad.Alumno;
import com.curso.modelo.entidad.Curso;
import com.curso.modelo.repositorio.MatriculaRepository;


public class ServicioCursos {

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
	/*
	public void matricularAlumno(Alumno alumno, Curso curso) {		
		
		//if(curso.getTipo = presencial)
		List<Alumno> alumnos = curso.getAlumnos();
		if(alumnos.size()<curso.getPlazas()) {
			alumnos.add(alumno);
		}
		
		//else if tipo = online
		//LN 2

		//else if tipo = enlatado
		//LN 3
		
		matriculaRepo.save("matricula");	
	}
	*/
	
	/*
	//Aqui al menos estamos respetando el principio de responsabilidad única
	//Pero seguimos sin respetar el principio abierto/cerrado
	public void matricularAlumno(Alumno alumno, Curso curso) {		
		switch(curso.tipo)
			case presencial matricularPresencial()
			case online     matricularOnline()
			case enlatado   matricularEnlatado()
	}	
	
	private void matricularPresencial(Alumno alumno, Curso curso){
		//LN1
	}
	
	private void matricularOnline(Alumno alumno, Curso curso){
		//LN2
	}
	
	private void matricularEnlatado(Alumno alumno, Curso curso){
		//LN3
	}
	*/
	
	
	public void matricularAlumno(Alumno alumno, Curso curso) {		
		//OO
		curso.matricularAlumno(alumno);
	}	
	
}

/*
//Intentemos cerrar esta clase para respetar el principio abierto/cerrado

//Esta está cerrada para la modificación, abierta para la extension
abstract class ServicioCursos_ {
	public void insertar(Curso curso){
		//LN...
	}
	
	public abstract void matricularAlumno(Alumno alumno, Curso curso);
}

class ServicioCursosPresenciales extends ServicioCursos_ {
	public void matricularAlumno(Alumno alumno, Curso curso){
		//LN 1
	}
}
class ServicioCursosOnline extends ServicioCursos_ {
	public void matricularAlumno(Alumno alumno, Curso curso){
		//LN 2
	}
}
class ServicioCursosEnlatados extends ServicioCursos_ {
	public void matricularAlumno(Alumno alumno, Curso curso){
		//LN 3
	}
}
*/






