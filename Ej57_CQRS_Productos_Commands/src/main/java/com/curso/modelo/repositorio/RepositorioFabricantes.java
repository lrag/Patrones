package com.curso.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Fabricante;

@Repository
public interface RepositorioFabricantes extends JpaRepository<Fabricante, String>{
}
