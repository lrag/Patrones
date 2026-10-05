package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
//Para arrancar Consul

//consul agent -dev (no guarda las configuraciones)

consul-config.json:

{
	  "retry_join" : ["127.0.0.1"],
	  "data_dir": "c:/consul",
	  "log_level": "INFO",
	  "server": true,
	  "node_name": "master",
	  "addresses": {
	    "https": "127.0.0.1"
	  },
	  "bind_addr": "127.0.0.1",
	  "ui": true,
	  "bootstrap_expect": 1
}

consul agent -config-file=consul-config.json
*/

@SpringBootApplication
public class Aplicacion {

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

}
