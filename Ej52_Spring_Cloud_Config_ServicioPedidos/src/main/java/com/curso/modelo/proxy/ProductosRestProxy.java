package com.curso.modelo.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.persistencia.ProductoRepositorio;

@Component
public class ProductosRestProxy {

	@Autowired private RestTemplate restTemplate;
	@Autowired private ProductoRepositorio productoRepo;
	
	public Producto buscar(String codigo){
		
		return productoRepo
				.findByCodigo(codigo)
				.orElseGet( () -> {
					System.out.println("Invocando al microservicio de productos");
					//No estamos controlando los posibles errores al enviar la petición!!!
					//Producto prodAux = restTemplate.getForEntity("http://localhost:9020/productos/"+codigo, Producto.class).getBody();
					Producto prodAux = restTemplate.getForEntity("http://ServicioProductos/productos/"+codigo, Producto.class).getBody();
					System.out.println("Producto obtenido:"+prodAux);
					productoRepo.save(prodAux);
					return prodAux;
				});				
	}
	
}
