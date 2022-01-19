package com.curso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.negocio.GestorPedidos;
import com.curso.modelo.negocio.GestorPedidosImpl;
import com.curso.persistencia.dao.FactoriaDAO;
import com.curso.persistencia.dao.PedidoDao;
import com.curso.persistencia.dao.ProductoDao;

public class Aplicacion {

	public static void main(String[] args) throws Exception {

		System.out.println("=================================================");		
	
		GestorPedidos gp = GestorPedidosImpl.getInstancia();
		try {
			Pedido p = new Pedido();
			p.setId(3);
			gp.aceptar(p);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error:"+e.getMessage());
		}		
			
		System.out.println("=================================================");
		ProductoDao productoDao = FactoriaDAO.getProductoDao();
		productoDao.listar().forEach( e -> System.out.println(e) );

		System.out.println("=================================================");
		PedidoDao pedidoDao = FactoriaDAO.getPedidoDao();
		pedidoDao.listar().forEach( e -> System.out.println(e) );
				
	}
	
}

