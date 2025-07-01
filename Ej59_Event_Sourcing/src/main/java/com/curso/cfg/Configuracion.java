package com.curso.cfg;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.curso.modelo.evento.EventoProducto;

@Configuration
public class Configuracion {

	@Value("${kafka.direccion}") 
	private String direccionKafka;
	@Value("${kafka.topic.grupo}") 
	private String idGrupo;
	@Value("${kafka.topic.nombre}") 
	private String nombreTopic;
	
	@Bean
	NewTopic topic() {
		System.out.println("Topic:"+nombreTopic);
		return TopicBuilder.name(nombreTopic).partitions(4).replicas(1).build();
	}
	
    @Bean
    ConsumerFactory<String, EventoProducto> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, direccionKafka);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, idGrupo);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(EventoProducto.class));
    }
    
    @Bean
    ConcurrentKafkaListenerContainerFactory<String, EventoProducto> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, EventoProducto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
