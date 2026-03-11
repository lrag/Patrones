package com.curso.modelo.entidad;

import java.util.List;

//@Component
//@Scope("prototype")
//@Entity
public class CursoOnline extends Curso {

	//private RepoMatriculas repoMatriculas;
	//private EmisorMensajes emisorMensajes;
	
	//@Autowired
	//public CursoOnline(RepoMatriculas repoMatriculas, EmisorMensajes emisorMensajes) {
	//	super();
	//	this.repoMatriculas = repoMatriculas;
	//	this.emisorMensajes = emisorMensajes;
	//}

	private String url;

	public CursoOnline() {
		super();
	}

	public CursoOnline(Integer id, String codigo, String titulo, Integer plazas, List<Alumno> alumnos, String url) {
		super(id, codigo, titulo, plazas, alumnos);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void matricularAlumno(Alumno alumno) {
		// LN
		System.out.println("Matriculando a un alumno en un curso online");
		if (alumnos.size() < plazas) {
			alumnos.add(alumno);
		}
		
		//repoMatriculas.save(matricula);
		//emisorMensajes("te has matriculado");	
		
	}

	@Override
	public String toString() {
		return super.toString() + " Url:" + url + "]";
	}

}
