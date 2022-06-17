package com.curso.cfg;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configuracion {

	@Value("localhost")
	private String host;

	@Value("5672")
	private int port;

	@Value("guest")
	private String username;

	@Value("guest")
	private String password;
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	/////////////////////////////////////////////////
	// TODAS ESTAS BEANS LAS REGISTRA EL STARTER   //
	// AQUI LAS VEMOS POR EL INTERÉS DE LA CIENCIA //
	/////////////////////////////////////////////////
	
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host, port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        System.out.println("Creando la factoria de conexiones con: " + username + "@" + host + ":" + port);
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public Queue colaOrdenesDeCompra() {
        // name: colaOrdenesDeCompra
        // durable    : true  <--
        // exclusive  : false
        // auto_delete: false
        return new Queue("colaOrdenesDeCompra", true, false, false);
    }	
	
    @Bean
    public MessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();
        messageHandlerMethodFactory.setMessageConverter(consumerJackson2MessageConverter());
        return messageHandlerMethodFactory;
    }

    @Bean
    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }	
	
}
