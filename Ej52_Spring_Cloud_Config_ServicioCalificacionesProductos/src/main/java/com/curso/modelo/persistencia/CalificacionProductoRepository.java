package com.curso.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.CalificacionProducto;

@Repository
public interface CalificacionProductoRepository extends JpaRepository<CalificacionProducto, Integer>{	
	public List<CalificacionProducto> findAllByCodigoProducto(String codigo);
}
