package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.Fabricante;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.evento.EventoProducto;
import com.curso.modelo.evento.TipoEventoProducto;
import com.curso.modelo.proxy.ProxyMensajeria;
import com.curso.modelo.repositorio.RepositorioFabricantes;
import com.curso.modelo.repositorio.RepositorioProductos;

@Service
@Transactional
public class GestorProductos {

	@Autowired private RepositorioProductos repoProductos;
	@Autowired private RepositorioFabricantes repoFabricantes;
	@Autowired private ProxyMensajeria proxyMensajeria;
	

	/*
	{
		id : null
		nombre : "X"
		fabricante: {
			id: 12
		}	
	}
	*/
	public void insertar(Producto producto) {
		//LN...
		System.out.println("Insertando el producto:"+producto);
		Fabricante f = repoFabricantes.findById(producto.getFabricante().getCodigo()).get();
		producto.setFabricante(f);
		repoProductos.save(producto);
		
		EventoProducto ep = new EventoProducto(TipoEventoProducto.PRODUCTO_CREADO, producto);
		proxyMensajeria.enviarMensaje(producto.getReferencia(), ep);
	}

	public void modificar(Producto producto) {
		//LN...
		System.out.println("Modificando el producto:"+producto);
		repoProductos.save(producto);
		
		EventoProducto ep = new EventoProducto(TipoEventoProducto.PRODUCTO_MODIFICADO, producto);
		proxyMensajeria.enviarMensaje(producto.getReferencia(), ep);		
	}

	public void borrar(String referencia) {
		//LN...
		
		Producto producto = repoProductos.findById(referencia).get();
		
		System.out.println("Borrando el producto:"+referencia);
		repoProductos.deleteById(referencia);
		
		EventoProducto ep = new EventoProducto(TipoEventoProducto.PRODUCTO_BORRADO, producto);
		proxyMensajeria.enviarMensaje(producto.getReferencia(), ep);
	}

}

/*

evento = tipo: producto_insertado
         producto:
        	 referencia: 123
        	 nombre:
        	 fabricante:
        	 ...



'topic-productos-cqrs', 123, evento

*/






