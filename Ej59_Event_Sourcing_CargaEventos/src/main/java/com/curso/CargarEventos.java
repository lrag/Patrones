package com.curso;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.curso.modelo.entidad.Fabricante;
import com.curso.modelo.entidad.Producto;

@Component
public class CargarEventos {

	
	public void cargarEventos() throws InterruptedException {
				
		RestClient restClient = RestClient.create();
		
		Fabricante f1 = new Fabricante();
		f1.setCodigo("FAB-1");
		
		System.out.println("==================================");
		System.out.println("Insertando producto 1 - "+System.currentTimeMillis());
		Producto p1 = new Producto("REF-AAA", "Producto 1", "Descripcion 1", f1);
		restClient
			.post()
			.uri("http://localhost:9050/productos")
			.contentType(MediaType.APPLICATION_JSON)
			.body(p1)
			.retrieve()
			.toBodilessEntity();
		Thread.sleep(2_000);
		
		System.out.println("==================================");
		System.out.println("Insertando producto 2 - "+System.currentTimeMillis());
		Producto p2 = new Producto("REF-BBB", "Producto 2", "Descripcion 2", f1);
		restClient
			.post()
			.uri("http://localhost:9050/productos")
			.contentType(MediaType.APPLICATION_JSON)
			.body(p2)
			.retrieve()
			.toBodilessEntity();
		Thread.sleep(2_000);
		
		System.out.println("==================================");
		System.out.println("Insertando producto 3 - "+System.currentTimeMillis());
		Producto p3 = new Producto("REF-CCC", "Producto 3", "Descripcion 3", f1);
		restClient
			.post()
			.uri("http://localhost:9050/productos")
			.contentType(MediaType.APPLICATION_JSON)
			.body(p3)
			.retrieve()
			.toBodilessEntity();
		Thread.sleep(2_000);
		
		System.out.println("==================================");
		System.out.println("Insertando producto 4 - "+System.currentTimeMillis());
		Producto p4 = new Producto("REF-DDD", "Producto 4", "Descripcion 4", f1);
		restClient
			.post()
			.uri("http://localhost:9050/productos")
			.contentType(MediaType.APPLICATION_JSON)
			.body(p4)
			.retrieve()
			.toBodilessEntity();
		Thread.sleep(2_000);
		
		System.out.println("==================================");
		System.out.println("Modificando producto 2 - "+System.currentTimeMillis());
		Producto p2Bis = new Producto("REF-BBB", "Producto 2 MODIFICADO", "Descripcion 2", f1);
		restClient
			.put()
			.uri("http://localhost:9050/productos/REF-BBB")
			.contentType(MediaType.APPLICATION_JSON)
			.body(p2Bis)
			.retrieve()
			.toBodilessEntity();
		Thread.sleep(2_000);		
		
		System.out.println("==================================");
		System.out.println("Eliminando producto 4 - "+System.currentTimeMillis());
		restClient
			.delete()
			.uri("http://localhost:9050/productos/REF-DDD")
			.retrieve()
			.toBodilessEntity();
		
		System.out.println("FIN");
		
	}

	
	
}
