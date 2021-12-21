package com.curso.modelo.persistencia;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Pedido;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Integer>{
	
	@Query("select p from Pedido p where p.id=:id")
	Optional<Pedido> buscarPedidosConDetalles(Integer id);
	
}
