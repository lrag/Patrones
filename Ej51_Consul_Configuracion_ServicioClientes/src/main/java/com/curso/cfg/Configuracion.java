package com.curso.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import com.curso.modelo.negocio.GestorClientes;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class Configuracion {
	
	@Value("${arsa.tocoto}")
	private String movida;
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	//@Scope("singleton")
	@RefreshScope
	DataSource dataSource(
					@Value("${bbdd.url}") String url, 
			        @Value("${bbdd.username:sa}") String username, 
			        @Value("${bbdd.password:}") String password 
				) {
		
		System.out.println("MOVIDA: "+movida);
		
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(url);
		ds.setDriverClassName("org.h2.Driver");
		ds.setUsername(username);
		ds.setPassword(password);		
		return ds;
	}
	
}






