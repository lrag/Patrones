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
	
	@Bean
	@RefreshScope
	public DataSource dataSource(@Value("${bbdd.url:jdbc:h2:file:c:/h2/bbdd_cloud_productos_3}") String url, 
			                     @Value("${bbdd.username:sa}") String username, 
			                     @Value("${bbdd.password:}") String password ) {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(url);
		ds.setDriverClassName("org.h2.Driver");
		ds.setUsername(username);
		ds.setPassword(password);		
		return ds;
	}
	
}
