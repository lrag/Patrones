package com.curso.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class Configuracion {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	//no es necesario registrar aqui esta bean
	@Bean
	@RefreshScope
	public DataSource dataSource(@Value("${spring.datasource.url}") String url, 
			                     @Value("${spring.datasource.username}") String username, 
			                     @Value("${spring.datasource.password}") String password ) {
		
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
