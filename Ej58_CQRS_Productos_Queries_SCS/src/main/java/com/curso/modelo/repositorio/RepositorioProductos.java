package com.curso.modelo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Producto;

@Repository
public interface RepositorioProductos extends MongoRepository<Producto, String>{
}
