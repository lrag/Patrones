package com.curso;

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

docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.13-management

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
public class Aplicacion {

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

}
