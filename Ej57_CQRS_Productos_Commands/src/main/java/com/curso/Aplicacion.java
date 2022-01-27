package com.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.modelo.entidad.Fabricante;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.repositorio.RepositorioFabricantes;
import com.curso.modelo.repositorio.RepositorioProductos;

/*
{
    "referencia": "REF-111",
    "nombre": "Fleje",
    "descripcion": "Bla bla bla",
    "fabricante": {
        "codigo": "",
    }
}
*/

@SpringBootApplication
public class Aplicacion implements CommandLineRunner{

	@Autowired private RepositorioProductos repoProductos;
	@Autowired private RepositorioFabricantes repoFabricantes;
	
	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		if(repoFabricantes.count() == 0) {
			Fabricante f1 = new Fabricante("FAB-1", "Iberica de Flejes", "C/Tal, 123", "123 456 789");
			Fabricante f2 = new Fabricante("FAB-2", "Elementos Disruptores S.A.", "C/Pascual, 123", "123 456 789");
			Fabricante f3 = new Fabricante("FAB-3", "Monolitos de la Armuña", "C/Falsa, 123", "123 456 789");
			
			repoFabricantes.save(f1);
			repoFabricantes.save(f2);
			repoFabricantes.save(f3);

			/*
			Producto p1 = new Producto("REF-111", "Fleje", "Bla bla bla",f1);
			Producto p2 = new Producto("REF-222", "Iman de buscar voltios", "Bla ble bli",f1);
			Producto p3 = new Producto("REF-333", "Escuadra de medir esquinas", "Bla bla blo",f2);
			Producto p4 = new Producto("REF-444", "Chisme electromecanico", "Blu bli bla",f2);
			Producto p5 = new Producto("REF-555", "Pendulador pirotecnico", "Blo blo bla",f3);
			Producto p6 = new Producto("REF-666", "Ringo Rango", "Bla bli blo",f3);			
			repoProductos.save(p1);
			repoProductos.save(p2);
			repoProductos.save(p3);
			repoProductos.save(p4);
			repoProductos.save(p5);
			repoProductos.save(p6);
			 */
		}
		
	}

}
