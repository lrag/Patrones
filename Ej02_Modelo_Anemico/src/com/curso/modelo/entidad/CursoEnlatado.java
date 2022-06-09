package com.curso.modelo.entidad;

import java.util.ArrayList;
import java.util.List;

//@Component
//@Scope("prototype")
//@Entity
public class CursoEnlatado extends Curso{

	private String material;

	public CursoEnlatado() {
		super();
	}

	public CursoEnlatado(Integer id, String codigo, String titulo, Integer plazas, List<Alumno> alumnos, String material) {
		super(id,codigo,titulo,plazas,alumnos);
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void matricularAlumno(Alumno alumno) {
		//LN
		System.out.println("Matriculando a un alumno en un curso enlatado");
		//Aqui no hay límite de aforo
	}	
	
	@Override
	public String toString() {
		return super.toString()+" Material:"+ material + "]";
	}

}
