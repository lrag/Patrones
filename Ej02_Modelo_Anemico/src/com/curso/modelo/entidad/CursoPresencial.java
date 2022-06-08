package com.curso.modelo.entidad;

import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.repositorio.MatriculaRepository;

//@Component
//@Scope("prototype")
//@Entity
public class CursoPresencial extends Curso{

	//@Autowired
	//private MatriculaRepository matriculaRepo;
	
	private String aula;
	
	public CursoPresencial() {
		super();
	}

	public CursoPresencial(Integer id, String codigo, String titulo, Integer plazas, List<Alumno> alumnos, String aula) {
		super(id, codigo, titulo, plazas, alumnos);
		this.aula = aula;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	@Override
	public void matricularAlumno(Alumno alumno) {
		//LN
		System.out.println("Matriculando a un alumno en un curso presencial");
		if(alumnos.size()<plazas) {
			alumnos.add(alumno);
		}
	}	
	
	@Override
	public String toString() {
		return super.toString()+" Aula:"+ aula + "]";
	}

}
