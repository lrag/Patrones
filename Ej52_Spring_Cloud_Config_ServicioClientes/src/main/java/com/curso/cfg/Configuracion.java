package com.curso.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class Configuracion {
	
	//no es necesario registrar aquí esta bean
	@Bean
	@RefreshScope
	public DataSource dataSource(@Value("${spring.datasource.url}") String url, 
			                     @Value("${spring.datasource.username:sa}") String username, 
			                     @Value("${spring.datasource.password:}") String password ) {
		
		System.out.println("=====================================================");
		System.out.println("Creando el datasource:"+url);
		
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(url);
		ds.setDriverClassName("org.h2.Driver");
		ds.setUsername(username);
		ds.setPassword(password);		
		return ds;
	}
	
}




@Component
class Clase1 {
	
	@Value("${cfg.prefijo:valor por defecto}")
	private String prefijo;

	public void actualizar() {
		//leer el valor 'cfg.prefijo' del application
		//prefijo = nuevoValor;
	}
	
	public void imrimir(String valor) {
		System.out.println(prefijo+valor);
	}	
	
}


@Component
@RefreshScope
class Clase2 {
	
	@Value("${cfg.prefijo")
	private String prefijo;

	public void actualizar() {
		//leer el valor 'cfg.prefijo' del aaplication
		//prefijo = nuevoValor;
	}
	
	public void imrimir(String valor) {
		System.out.println(prefijo+valor);
	}	
	
}


















