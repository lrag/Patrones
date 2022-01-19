package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Producto;
import com.curso.modelo.negocio.excepcion.ExistenciasException;
import com.curso.persistencia.dao.FactoriaDAO;
import com.curso.persistencia.dao.ProductoDao;


public class GestorAlmacen {
	
	private static GestorAlmacen instancia;
	
	public synchronized static GestorAlmacen getInstancia() {
		if(instancia == null) {
			instancia = new GestorAlmacen();
		}
		return instancia;
	}	
	
	private ProductoDao productoDao = FactoriaDAO.getProductoDao();
	
	private GestorAlmacen() {
		super();
	}

	public void comprobarExistencias(Producto producto, Integer cantidad) throws ExistenciasException{
		
		System.out.printf("Comprobando existencias para el producto %s, cantidad %d...", 
				          producto.getNombre(), cantidad);
		
		producto = productoDao.buscar(producto.getId());		
		if(producto.getExistencias()<cantidad) {
			System.out.println("MAL");			
			throw new ExistenciasException(producto, cantidad, producto.getExistencias());
		}
		
		System.out.println("OK");
		
	}
	
	public void reducirExistencias(Producto producto, Integer cantidad){
		System.out.println("Reduciendo existencias del producto "+producto.getNombre());
		
		producto = productoDao.buscar(producto.getId());		
		producto.setExistencias(producto.getExistencias()-cantidad);
		productoDao.modificar(producto);
	}	
	
}









