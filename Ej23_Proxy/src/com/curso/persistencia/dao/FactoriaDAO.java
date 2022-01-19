package com.curso.persistencia.dao;

public class FactoriaDAO {

	private static ProductoDao productoDao;
	private static PedidoDao   pedidoDao;
	
	public synchronized static ProductoDao getProductoDao() {
		if(productoDao == null) {
			productoDao = new ProductoDaoJPAImplementation();
		}
		return productoDao;
	}
	
	public synchronized static PedidoDao getPedidoDao() {
		if(pedidoDao == null) {
			pedidoDao = new PedidoDaoJPAImplementation();
		}
		return pedidoDao;
	}
	
	private FactoriaDAO() {
	}
	
}
