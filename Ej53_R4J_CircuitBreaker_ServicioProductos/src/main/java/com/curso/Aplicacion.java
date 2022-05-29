package com.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.curso.modelo.entidad.Producto;
import com.curso.modelo.persistencia.ProductoRepositorio;

/*
 
 
consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=127.0.0.1

config/ServicioProductos/

bbdd.url, jdbc:h2:file:c:/h2/bbdd_cloud_productos;DB_CLOSE_DELAY=-1


*/

@SpringBootApplication
public class Aplicacion implements CommandLineRunner{

	@Autowired private ProductoRepositorio productoRepo;
	
	@Value("${bbdd.url:valor_por_defecto}")
	private String url;
	
	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("========================================");
		System.out.println("Url a la base de datos: "+url);
		
		if(productoRepo.count() == 0) {
			Producto p1 = new Producto(null, "Producto 1", "PROD-1", "Fabricante 1", "imagen1.jpg", 25d , null);
			Producto p2 = new Producto(null, "Producto 2", "PROD-2", "Fabricante 2", "imagen2.jpg", 50d , null);
			Producto p3 = new Producto(null, "Producto 3", "PROD-3", "Fabricante 3", "imagen3.jpg", 75d , null);
			Producto p4 = new Producto(null, "Producto 4", "PROD-4", "Fabricante 4", "imagen4.jpg", 100d, null);
			Producto p5 = new Producto(null, "Producto 5", "PROD-5", "Fabricante 5", "imagen5.jpg", 125d, null);
			productoRepo.save(p1);
			productoRepo.save(p2);
			productoRepo.save(p3);
			productoRepo.save(p4);
			productoRepo.save(p5);
		}
		
	}

}
