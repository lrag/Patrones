package com.curso.modelo.persistencia;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Factura;

@Repository
public class FacturaRepositorio {

	public List<Factura> findAll() {
		return null;
	}

	public Optional<Factura> findById(Integer id) {
		return Optional.of(null);
	}
}
