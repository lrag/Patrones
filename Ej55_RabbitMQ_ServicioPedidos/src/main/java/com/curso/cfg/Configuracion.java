package com.curso.cfg;

import javax.sql.DataSource;

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
	public DataSource dataSource(@Value("${bbdd.url:jdbc:h2:file:c:/h2/bbdd_cloud_pedidos}") String url, 
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
	public Queue colaPedidosCreados() {
        // name: colaPedidosCreados
        // durable: true
        // exclusive: false
        // auto_delete: false
        return new Queue("colaPedidosCreados", true, false, false);
	}	
	
	//Esta necesitamos tenerla
	//Aprovechamos para asociar a la rabbitTemplate un conversor de obj a json 
    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    //El conversor...
    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }	
	
}
