package com.curso.cfg;

import org.apache.activemq.artemis.jms.client.ActiveMQJMSConnectionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Session;

@Configuration
public class Configuracion {

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



