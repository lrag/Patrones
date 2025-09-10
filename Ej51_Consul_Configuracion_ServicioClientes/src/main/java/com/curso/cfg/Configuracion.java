package com.curso.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class Configuracion {
	
	@Bean
	//@Scope("singleton")
	@RefreshScope
	//public DataSource dataSource(@Value("${spring.datasource.url}") String url, 
	DataSource dataSource(@Value("${bbdd.url}") String url, 
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




