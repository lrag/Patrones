package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/*
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
*/

@EnableConfigServer
@SpringBootApplication
public class Aplicacion{

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

}
