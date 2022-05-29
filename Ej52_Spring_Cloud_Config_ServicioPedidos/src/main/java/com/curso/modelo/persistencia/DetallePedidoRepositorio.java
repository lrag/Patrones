package com.curso.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.DetallePedido;

@Repository
public interface DetallePedidoRepositorio extends JpaRepository<DetallePedido, Integer>{
}
