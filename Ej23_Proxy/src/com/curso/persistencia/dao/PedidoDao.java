package com.curso.persistencia.dao;

import com.curso.modelo.entidad.Pedido;

public interface PedidoDao extends InterfaceDao<Pedido, Integer>{
	
	Pedido buscarConDetalles(Integer id);
	
}
