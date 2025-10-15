package com.curso.cfg;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.curso.modelo.evento.EventoProducto;

@Configuration
public class Configuracion {
	
	@Value("${kafka.direccion}") 
	private String direccionKafka;
	@Value("${kafka.topic.nombre}") 
	private String nombreTopic;
	
	@Bean
	public NewTopic topic() {
		System.out.println("Topic:"+nombreTopic);
		return TopicBuilder.name(nombreTopic).partitions(4).replicas(1).build();
	}

	@Bean
	ProducerFactory<String, EventoProducto> producerFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfigs(), new StringSerializer(), new JsonSerializer<EventoProducto>());
	}

	//@Bean
	Map<String, Object> producerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, direccionKafka);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return props;
	}

	@Bean
	KafkaTemplate<String, EventoProducto> kafkaTemplateProductos() {
		return new KafkaTemplate<>(producerFactory());
	}

}
