package com.curso.modelo.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.curso.modelo.entidad.Producto;
import com.curso.modelo.persistencia.ProductoRepositorio;

@Component
public class ProductosRestProxy implements ProductosProxy {

	//@Autowired private RestTemplate restTemplate;
	@Autowired private RestClient restClient;
	@Autowired private ProductoRepositorio productoRepo;
	
	@Override
	public Producto buscar(String codigo){
		
		return productoRepo
				.findByCodigo(codigo)
				.orElseGet( () -> {
					System.out.println("Invocando al microservicio de productos");
					//No estamos controlando los posibles errores al enviar la petición!!!
					//Producto prodAux = restTemplate.getForEntity("http://localhost:9020/productos/"+codigo, Producto.class).getBody();
					//Producto prodAux = restTemplate.getForEntity("http://ServicioProductos/productos/"+codigo, Producto.class).getBody();
					
					Producto prodAux = restClient
							.get()
							.uri("http://ServicioProductos/productos/"+codigo)
							.retrieve()
							.body(Producto.class);					
					
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
