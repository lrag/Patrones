package com.curso.modelo.repositorio;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Producto;

@Repository
public interface RepositorioProductos extends JpaRepository<Producto, String>{
}
