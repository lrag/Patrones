package com.curso.cfg;

import javax.sql.DataSource;

import org.apache.activemq.artemis.jms.client.ActiveMQJMSConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.client.RestTemplate;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Session;

@Configuration
public class Configuracion {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	@RefreshScope
	DataSource dataSource(@Value("${bbdd.url:jdbc:h2:file:c:/h2/bbdd_cloud_pedidos_3}") String url, 
			                     @Value("${bbdd.username:sa}") String username, 
			                     @Value("${bbdd.password:}") String password ) {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(url);
		ds.setDriverClassName("org.h2.Driver");
		ds.setUsername(username);
		ds.setPassword(password);		
		return ds;
	}
	
	//@Bean
    ConnectionFactory jmsConnectionFactory() {
        ActiveMQJMSConnectionFactory factory = new ActiveMQJMSConnectionFactory(
            "url", 
            "usuario", 
            "password"
        );
        // factory.setConnectionTTL(60000); 
        // factory.setBlockOnDurableSend(true);

        return factory;
    }
    
    //@Bean
    JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
        JmsTemplate template = new JmsTemplate(connectionFactory);
        //template.setMessageConverter(msgConverter);
        return template;
    }    
	
    //@Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrency("5-10"); // Mínimo 5, Máximo 10 hilos procesando mensajes
        factory.setSessionTransacted(true); 
        factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE); 
        factory.setReceiveTimeout(5000L); 
        return factory;
    }  	
	
}
