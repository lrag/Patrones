package com.curso.modelo.negocio;

import java.util.List;

import com.curso.modelo.entidad.DetallePedido;
import com.curso.modelo.entidad.Pedido;
import com.curso.persistencia.dao.FactoriaDAO;
import com.curso.persistencia.dao.PedidoDao;
import com.curso.persistencia.transacciones.GestorTransacciones;

public class GestorPedidosImpl implements GestorPedidos {

	//SINGLETON//////////////////////////////////////////////////
	private static GestorPedidosImpl instancia;
	
	public synchronized static GestorPedidosImpl getInstancia() {
		if(instancia == null) {
			instancia = new GestorPedidosImpl();
		}
		return instancia;
	}
	/////////////////////////////////////////////////////////////
	
	private PedidoDao pedidoDao = FactoriaDAO.getPedidoDao();
	private GestorBancos gestorBancos = GestorBancos.getInstancia();
	private GestorAlmacen gestorAlmacen = GestorAlmacen.getInstancia();
	private GestorTransportes gestorTransportes = GestorTransportes.getInstancia();

	private GestorPedidosImpl() {
	}
	
	@Override
	public void insertar(Pedido pedido){
		//Seguridad
		/*
		if(usuario.rol != "EMPLEADO") {
			throw new Ex
		}
		*/
		
		//GestorTransacciones.beginTX();	
		pedidoDao.insertar(pedido);
		//GestorTransacciones.commit()/rollback();
	}
	
	@Override
	public void modificar(Pedido pedido){
		//Seguridad
		//GestorTransacciones.beginTX();	
		pedidoDao.modificar(pedido);
		//GestorTransacciones.commit()/rollback();
	}
	
	@Override
	public void borrar(Integer idPedido){
		//Seguridad
		//GestorTransacciones.beginTX();	
		Pedido pedido = pedidoDao.buscar(idPedido);
		//if pedido==null...
		pedidoDao.borrar(pedido);
		//GestorTransacciones.commit()/rollback();
	}
	
	@Override	
	public void aceptar(Pedido pedido) throws Exception{
		
		//hora inicio
		
		//log
		
		//Seguridad
		
		//GestorTransacciones.beginTX();
		//try {

			pedido = pedidoDao.buscar(pedido.getId());
		
			Integer numeroTC = pedido.getCliente().getNumeroTC();
			gestorBancos.comprobarTC(numeroTC);
			
			for(DetallePedido dp : pedido.getDetalles()) {
				gestorAlmacen.comprobarExistencias(dp.getProducto(), dp.getCantidad());
				gestorAlmacen.reducirExistencias(dp.getProducto(), dp.getCantidad());
			}
			
			//calcular ofertas
			
			
			String camion = gestorTransportes.obtenerCamion(true);
			pedido.setCamion(camion);
			
			//EMITIR UNA FACTURA
			//gestorFacturas.bla bla blá...
			
			pedido.setEstado("ACEPTADO");
			pedidoDao.modificar(pedido);
			System.out.println("FIN");
			
		//  GestorTransacciones.commitTX();		
		//    
		//} catch (Exception e) {
		//	GestorTransacciones.rollbackTX();
		//	throw e;
		//}

		//hora-fin 
		
	}
	
	@Override
	public Pedido buscar(Integer id){
		return pedidoDao.buscar(id);
	}
	
	@Override
	public Pedido buscarConDetalles(Integer id){
		return pedidoDao.buscarConDetalles(id);
	}
	
	@Override
	public List<Pedido> listar(){
		return pedidoDao.listar();
	}
	
	////////////
	//DETALLES//
	////////////
	@Override
	public void addDetalle(Pedido pedido, DetallePedido detalle) {		
		//Si invocamos 'buscarConDetalles' en vez de dos selects se hace uno
		pedido = pedidoDao.buscarConDetalles(pedido.getId());
		//Modelo anémico:
		//pedido.getDetalles().add(e)
		//'Domain Driven Design':
		pedido.addDetalle(detalle);
		pedidoDao.modificar(pedido);		
	}	
	
}










