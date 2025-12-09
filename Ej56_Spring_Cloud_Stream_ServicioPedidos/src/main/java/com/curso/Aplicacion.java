package com.curso;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.GestorPedidos;
import com.curso.modelo.persistencia.ClienteRepositorio;
import com.curso.modelo.persistencia.PedidoRepositorio;

/*

RabbitMQ :
http://localhost:15672/#/connections
guest
guest

{
	"fecha" : "5/5/2021",
	"estado" : "pendiente",
	"cliente" : {
		"login" : "sam"
	},
	"detalles" : [
		{
			"producto" : {
				"codigo" : "PROD-1"
			},
			"cantidad" : 1
		},
		{
			"producto" : {
				"codigo" : "PROD-3"
			},
			"cantidad" : 2
		},
		{
			"producto" : {
				"codigo" : "PROD-5"
			},
			"cantidad" : 3
		}	
	]
}
*/

@SpringBootApplication
public class Aplicacion implements CommandLineRunner {

	@Autowired private ClienteRepositorio clienteRepo;
	@Autowired private PedidoRepositorio pedidoRepo;
	@Autowired private GestorPedidos gestorPedidos;
	
	@Value("${bbdd.url:valor_por_defecto}")
	private String url;	
	
	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("========================================");
		System.out.println("Url a la base de datos: "+url);
		if(clienteRepo.count() == 0) {
			clienteRepo.save(new Cliente(2,"philip","Philip Marlowe","banco 2"));
		}
		
		System.out.println("================================");
	}

}


/*

class Emisor implements Supplier<String> {
	@Override
	public String get() {
		return "HOLA";
	}
}

class Oyente implements Consumer<String> {
	@Override
	public void accept(String t) {
		//
	}
}

class Movida implements Function<String, String> {
	@Override
	public String apply(String t) {
		return t.toString();
	}
}

*/









