package com.curso.modelo.negocio;

import java.util.List;

import com.curso.modelo.entidad.DetallePedido;
import com.curso.modelo.entidad.Pedido;
import com.curso.persistencia.dao.FactoriaDAO;
import com.curso.persistencia.dao.PedidoDao;
import com.curso.persistencia.transacciones.GestorTransacciones;


public class GestorPedidos_PROXY implements GestorPedidos {

	//SINGLETON//////////////////////////////////////////////////////
	private static GestorPedidos_PROXY instancia;
	
	public synchronized static GestorPedidos_PROXY getInstancia() {
		if(instancia == null) {
			instancia = new GestorPedidos_PROXY();
		}
		return instancia;
	}
	//////////////////////////////////////////////////////////////////

	//El proxy tiene la potestad de crear al objeto delante del cuál se coloca
	private GestorPedidosImpl target = GestorPedidosImpl.getInstancia();

	private GestorPedidos_PROXY() {
	}
	
	public void insertar(Pedido pedido){
		GestorTransacciones.beginTX();
		try {
			target.insertar(pedido);
			GestorTransacciones.commitTX();
		} catch (Exception e) {
			GestorTransacciones.rollbackTX();
			throw e;
		}		
	}
	
	public void modificar(Pedido pedido){
		GestorTransacciones.beginTX();
		try {
			target.modificar(pedido);
			GestorTransacciones.commitTX();
		} catch (Exception e) {
			GestorTransacciones.rollbackTX();
			throw e;
		}	
	}
	
	public void borrar(Integer idPedido){
		GestorTransacciones.beginTX();
		try {
			target.borrar(idPedido);
			GestorTransacciones.commitTX();
		} catch (Exception e) {
			GestorTransacciones.rollbackTX();
			throw e;
		}	
	}
	
	public void aceptar(Pedido pedido) throws Exception{	
		GestorTransacciones.beginTX();
		try {
			target.aceptar(pedido);
			GestorTransacciones.commitTX();
		} catch (Exception e) {
			GestorTransacciones.rollbackTX();
			throw e;
		}		
	}

	//Este método es transparente
	public Pedido buscar(Integer id){
		return target.buscar(id);
	}
	
	//Este método es transparente
	public Pedido buscarConDetalles(Integer id){
		return target.buscarConDetalles(id);
	}
	
	//Este método es transparente
	public List<Pedido> listar(){
		return target.listar();
	}
	
	////////////
	//DETALLES//
	////////////
	public void addDetalle(Pedido pedido, DetallePedido detalle) {		
		target.addDetalle(pedido, detalle);		
	}	
	
}










