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
	@RefreshScope //Es un singleton que se volverá a crear si cambia la configuracion
	public DataSource dataSource(@Value("${bbdd.url:jdbc:h2:file:c:/h2/bbdd_cloud_clientes}") String url, 
			                     @Value("${bbdd.username:sa}") String username, 
			                     @Value("${bbdd.password:}") String password ) {
		
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
