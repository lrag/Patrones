package com.curso.cfg;

import javax.sql.DataSource;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
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
	DataSource dataSource(@Value("${bbdd.url:jdbc:h2:file:c:/h2/bbdd_cloud_pedidos_OTRA}") String url, 
			                     @Value("${bbdd.username:sa}") String username, 
			                     @Value("${bbdd.password:}") String password ) {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(url);
		ds.setDriverClassName("org.h2.Driver");
		ds.setUsername(username);
		ds.setPassword(password);		
		return ds;
	}

	//Esto lo ponemos solo para que la aplicación solicite al arrancar la creación de una cola 'durable'
	//en rabbitMQ
	//Sin esta bean funciona igual pero se crea una cola temporal
	@Bean
	Queue colaOrdenesDeCompra() {
        // name: colaPedidosCreados
        // durable: true
        // exclusive: false
        // auto_delete: false
        return new Queue("colaOrdenesDeCompra", true, false, false);
	}
	
	/*
	@Bean
	Queue colaIncidenciasPedidos() {
		// name: colaPedidosCreados
		// durable: true
		// exclusive: false
		// auto_delete: false
		return new Queue("colaIncidenciasPedidos", true, false, false);
	}
	*/	
	
    @Bean
    DirectExchange exchangeColas() {
        return new DirectExchange("exchangeColas", true, false);
    }	
    
    @Bean
    Binding bindingOrdenesDeCompra(Queue colaOrdenesDeCompra, DirectExchange exchangeColas) {
        return BindingBuilder
                .bind(colaOrdenesDeCompra)
                .to(exchangeColas) 
                .with("nuevaOrdenDeCompra"); 
    }
    
    /*
    @Bean
    Binding bindingIncidenciasPedidos(Queue colaIncidenciasPedidos, DirectExchange exchangeColas) {
    	return BindingBuilder
    			.bind(colaIncidenciasPedidos)
    			.to(exchangeColas) 
    			.with("nuevaIncidenciaPedido"); 
    }
    */    
	
	//Esta necesitamos tenerla
	//Spring Boot registra una RabbitTemplate, pero que recibe un string (json) como payload del mensaje
	//Aprovechamos para asociar a la rabbitTemplate un conversor de obj a json 
    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    	final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    	rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
    	rabbitTemplate.setChannelTransacted(true);
        return rabbitTemplate;
    }

    //El conversor...
    @Bean
    Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }	
    
	
}
