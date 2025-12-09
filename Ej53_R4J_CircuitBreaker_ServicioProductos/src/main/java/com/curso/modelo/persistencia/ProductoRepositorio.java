package com.curso.modelo.persistencia;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{
	Optional<Producto> findByCodigo(String codigo);
}

