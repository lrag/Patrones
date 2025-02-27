package com.curso.modelo.negocio;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.persistencia.PeliculaRepositorio;

/*
Estereotipos:

Service
Repository
Component

Si tenemos Spring MVC:

Controller
RestController

Ámbitos:

Singleton, por defecto
Prototype

Si tenemos Spring web:
Request
Session

*/

/*
receta: servicioPeliculas
Crear un objeto del tipo ServicioPeliculas
Ámbito: singleton
Dependencias del constructor: PeliculasRepositorio
*/

@Service //("fistro")
//@Scope("singleton")
public class ServicioPeliculas {
	
	private PeliculaRepositorio peliculasRepo;

	public ServicioPeliculas(PeliculaRepositorio peliculasRepo) {
		super();
		this.peliculasRepo = peliculasRepo;
	}

	public void setPeliculasRepo(PeliculaRepositorio peliculasRepo) {
		this.peliculasRepo = peliculasRepo;
	}

	@Transactional(rollbackFor = Exception.class)
	public void insertar(Pelicula pelicula) {
		//LN para insertar
		System.out.println("Insertando la pelicula: "+pelicula);
		System.out.println("Repositorio: "+peliculasRepo);
		peliculasRepo.save(pelicula);
	}
	
	public void modificar(Pelicula pelicula) {
		//LN para modificar
		System.out.println("Insertando la pelicula: "+pelicula);
		System.out.println("Repositorio: "+peliculasRepo);
		peliculasRepo.save(pelicula);
	}
	
	public void borrar(Pelicula pelicula) {
		//LN para modificar
		System.out.println("Insertando la pelicula: "+pelicula);
		System.out.println("Repositorio: "+peliculasRepo);
		peliculasRepo.deleteById(pelicula.getId());
	}	
	
}
