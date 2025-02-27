package com.curso.modelo.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.persistencia.ProductoRepositorio;

@Component
public class ServicioProductosProxy {

	@Autowired private ProductosClient productosClient;
	@Autowired private ProductoRepositorio productoRepo;
	
	public Producto buscar(String codigo){
		
		return productoRepo
				.findByCodigo(codigo)
				.orElseGet( () -> {
					System.out.println("Invocando al microservicio de productos");
					Producto prodAux = productosClient.buscar(codigo);
					System.out.println("Producto obtenido:"+prodAux);
					productoRepo.save(prodAux);
					return prodAux;
				});				
	}
	
	/*
	public Producto buscar_(String codigo){
		return restTemplate.getForEntity("http://ServicioProductos/productos/"+codigo, Producto.class).getBody();
	}
	*/	
	
}
