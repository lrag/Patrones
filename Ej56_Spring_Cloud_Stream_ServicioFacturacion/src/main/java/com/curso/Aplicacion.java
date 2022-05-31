package com.curso;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.modelo.entidad.Factura;
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
