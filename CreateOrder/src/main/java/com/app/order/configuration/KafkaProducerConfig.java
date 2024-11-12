package com.app.order.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.app.order.events.OrderCreatedEvent;

@Configuration
class KafkaProducerConfig {

    @Bean
    KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate(){
		return new KafkaTemplate<String,OrderCreatedEvent>(producerFactory());

	}

	@Bean
	 ProducerFactory<String, OrderCreatedEvent> producerFactory() {

		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); // Serialize the OrderCreatedEvent object as JSON
		
		return new DefaultKafkaProducerFactory<>(configProps);
	}

}
