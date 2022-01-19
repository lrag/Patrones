package com.curso.modelo.negocio;

import java.util.List;

import com.curso.modelo.entidad.DetallePedido;
import com.curso.modelo.entidad.Pedido;

public interface GestorPedidos {

	void insertar(Pedido pedido);

	void modificar(Pedido pedido);

	void borrar(Integer idPedido);

	void aceptar(Pedido pedido) throws Exception;

	Pedido buscar(Integer id);

	Pedido buscarConDetalles(Integer id);

	List<Pedido> listar();

	////////////
	//DETALLES//
	////////////
	void addDetalle(Pedido pedido, DetallePedido detalle);

}