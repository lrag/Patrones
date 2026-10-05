package com.curso.aplicacion.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.aplicacion.ServicioClientesImpl;
import com.curso.aplicacion.puerto.persistencia.ClienteRepositorio;
import com.curso.aplicacion.puerto.servicios.ServicioClientes;

@Configuration
public class Configuracion {
	
	@Bean
	ServicioClientes servicioClientes(ClienteRepositorio clienteRepositorio) {
		//PA KE KEREMOS ESTA INTERFAZ
		return new ServicioClientesImpl(clienteRepositorio);
	}
	
}
