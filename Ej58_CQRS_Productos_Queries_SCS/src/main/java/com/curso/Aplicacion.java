package com.curso;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*

docker run -d --name broker apache/kafka:latest
docker exec --workdir /opt/kafka/bin/ -it broker sh

*/

@SpringBootApplication
public class Aplicacion implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
