package com.curso;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.modelo.persistencia.FacturaRepositorio;

/*

config/ServicioProductos/

bbdd.url      = jdbc:h2:file:c:/h2/bbdd_cloud_productos;DB_CLOSE_DELAY=-1
bbdd.user     = sa
bbdd.password = 

*/

@SpringBootApplication
public class Aplicacion implements CommandLineRunner{

	@Autowired private FacturaRepositorio productoRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("========================================");
		
	}

}

/*
class Movida implements Consumer<String> {
	public void accept(String t) {
	}
}

class Movidon implements Function<String, String>{
	public String apply(String t) {
		return null;
	}
}

class Movidote implements Supplier<String>{
	public String get() {
		return null;
	}
}
*/

