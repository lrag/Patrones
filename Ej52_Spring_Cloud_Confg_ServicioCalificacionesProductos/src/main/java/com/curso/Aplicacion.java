package com.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.modelo.entidad.CalificacionProducto;
import com.curso.modelo.persistencia.CalificacionProductoRepository;

/*

*/

@SpringBootApplication
public class Aplicacion implements CommandLineRunner {

	@Autowired
	private CalificacionProductoRepository productoRepo;

	@Value("${bbdd.url:valor_por_defecto}")
	private String url;

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("=======================================");
		System.out.println("Url a la base de datos: " + url);

		if (productoRepo.count() == 0) {
			productoRepo.save(
					new CalificacionProducto(null, "PROD-1", "Producto 1", 4, "Fistro", "bla bla bla", "fecha 1"));
			productoRepo.save(
					new CalificacionProducto(null, "PROD-1", "Producto 1", 4, "Fulanito", "bla bla bla", "fecha 3"));
			productoRepo.save(
					new CalificacionProducto(null, "PROD-1", "Producto 1", 5, "Fistra", "bla bla bla", "fecha 2"));
			productoRepo.save(
					new CalificacionProducto(null, "PROD-1", "Producto 1", 5, "Fulanita", "bla bla bla", "fecha 4"));
			productoRepo
					.save(new CalificacionProducto(null, "PROD-3", "Producto 3", 3, "Menganito", "AEIOU", "fecha 5"));
			productoRepo
					.save(new CalificacionProducto(null, "PROD-3", "Producto 3", 4, "Menganita", "AEIOU", "fecha 6"));
			productoRepo.save(new CalificacionProducto(null, "PROD-3", "Producto 3", 3, "Sir Archibald Bradley",
					"AEIOU", "fecha 7"));
			productoRepo.save(new CalificacionProducto(null, "PROD-5", "Producto 5", 2, "Zutanita",
					"Siete caballos vienen de bonanza", "fecha 8"));
			productoRepo.save(new CalificacionProducto(null, "PROD-5", "Producto 5", 3, "Zutanito",
					"Te digo trigo por no llamarte rodrigo", "fecha 9"));
		}

	}

}
