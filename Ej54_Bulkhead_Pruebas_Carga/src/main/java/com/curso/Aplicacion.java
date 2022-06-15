package com.curso;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.endpoint.proxy.ProductosRestProxy;

@SpringBootApplication
public class Aplicacion implements CommandLineRunner{

	@Autowired
	private ProductosRestProxy productosRestProxy;

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("=====================================");

        ExecutorService servicio = Executors.newFixedThreadPool(6);
        Future<Integer> contadorListar = servicio.submit(new PruebaListar(productosRestProxy));
        Future<Integer> contadorBuscar = servicio.submit(new PruebaBuscar(productosRestProxy));

        Integer listar = contadorListar.get();
        Integer buscar = contadorBuscar.get();
        System.out.println("=====================================");
		System.out.println("LISTAR:"+listar);
		System.out.println("BUSCAR:"+buscar);

		Thread.sleep(30_000);				
		
		System.out.println("FIN del hilo main");
		System.exit(0);
	}
}

//////////////////////
// LISTAR PRODUCTOS //
//////////////////////

class PruebaListar implements Callable<Integer> {

	private AtomicInteger contador = new AtomicInteger(0);
	private ProductosRestProxy productosRestProxy;
	
	public PruebaListar(ProductosRestProxy productosRestProxy) {
		super();
		this.productosRestProxy = productosRestProxy;
	}

	@Override
	public Integer call() throws Exception {		
		Long fin = System.currentTimeMillis()+10_000; 
		while(System.currentTimeMillis()<fin) {		
			Thread.sleep(100);			
			System.out.println("Listando los productos");
			productosRestProxy
				.listar()
				.collect(Collectors.toList())
				.subscribe( lista -> {
					System.out.println(lista);
					contador.incrementAndGet();
				});			
		}
		return contador.get();		
	}	
}

/////////////////////
// BUSCAR PRODUCTO //
/////////////////////

class PruebaBuscar implements Callable<Integer> {

	private AtomicInteger contador = new AtomicInteger(0);
	private ProductosRestProxy productosRestProxy;
	
	public PruebaBuscar(ProductosRestProxy productosRestProxy) {
		super();
		this.productosRestProxy = productosRestProxy;
	}

	@Override
	public Integer call() throws Exception {		
		Long fin = System.currentTimeMillis()+10_000; 
		while(System.currentTimeMillis()<fin) {		
			Thread.sleep(100);			
			System.out.println("Buscando el producto 1");
			
			productosRestProxy
				.buscarConCalificaciones("PROD-1")
				.subscribe( 
					p -> {
						System.out.println(p);
						contador.incrementAndGet();
					},
					e -> System.out.println(e.getMessage())
				);			
		}
		return contador.get();		
	}	
}
