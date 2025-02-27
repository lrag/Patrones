package com.curso.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Pelicula;


@Repository //Es opcional porque ya la añade 'JpaRepository'
public interface PeliculaRepositorio extends JpaRepository<Pelicula, Integer> {
}

/*
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Pelicula;

@Repository
public class PeliculaRepositorio {
	
	@PersistenceContext
	private EntityManager em;
	
	public PeliculaRepositorio() {
		super();
	}

	public void insertar(Pelicula pelicula) {
		em.persist(pelicula);
	}
	
	public void modificar(Pelicula pelicula) {
		em.merge(pelicula);
	}
	
	public void borrar(Pelicula pelicula) {
		em.merge(pelicula);
		em.remove(pelicula);
	}
	
	public Pelicula buscar(Integer idPelicula) {
		return em.find(Pelicula.class, idPelicula);
	}
	
	public List<Pelicula> listar(){
		return em.createQuery("select p from Pelicula p").getResultList();
	}
	
}
*/
