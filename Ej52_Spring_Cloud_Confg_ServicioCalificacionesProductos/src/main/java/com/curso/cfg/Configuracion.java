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

	/*
	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="org.h2.Driver"/>
		<property name="url"             value="jdbc:h2:file:c:/h2/bbdd"/>
		<property name="username"        value="sa"/>
		<property name="password"        value=""/>	
	</bean>		
	*/
	
	@Bean
	@RefreshScope
	public DataSource dataSource(@Value("${bbdd.url}") String url, 
			                     @Value("${bbdd.username}") String username, 
			                     @Value("${bbdd.password}") String password ) {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(url);
		ds.setDriverClassName("org.h2.Driver");
		ds.setUsername(username);
		ds.setPassword(password);		
		return ds;
	}
	
	
}
