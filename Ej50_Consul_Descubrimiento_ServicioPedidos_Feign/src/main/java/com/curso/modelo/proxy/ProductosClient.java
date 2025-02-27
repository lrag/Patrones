package com.curso.modelo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.curso.modelo.entidad.Producto;

@FeignClient(name="ServicioProductos")
public interface ProductosClient {

	@GetMapping(path="/productos/{codigo}", produces = "application/json")
	public Producto buscar(@PathVariable String codigo);
	
}
