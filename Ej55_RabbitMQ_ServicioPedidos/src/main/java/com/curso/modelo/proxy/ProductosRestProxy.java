package com.curso.modelo.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Producto;

@Component
public class ProductosRestProxy {

	@Autowired
	private RestTemplate restTemplate;
	
	public Producto buscar(String codigo){
		//return restTemplate.getForEntity("http://localhost:9000/clientes/"+login, Cliente.class).getBody();
		return restTemplate.getForEntity("http://ServicioProductos/productos/"+codigo, Producto.class).getBody();
	}
	
}
