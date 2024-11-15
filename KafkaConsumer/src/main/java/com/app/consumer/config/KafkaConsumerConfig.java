package com.app.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.app.consumer.events.OrderCreatedEvent;

@Configuration
@EnableKafka
class KafkaConsumerConfig {


	@Bean
	ConsumerFactory<String, OrderCreatedEvent> consumerFactory() 
	{ 

		// Creating a map of string-object type 
		Map<String, Object> config = new HashMap<>(); 

		// Adding the Configuration 
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, 
				"localhost:9092");
	   
		
	    // Configure the ErrorHandlingDeserializer
	    return new DefaultKafkaConsumerFactory<>(config,
	        new ErrorHandlingDeserializer<>(new StringDeserializer()),  // For the key deserializer
	        new ErrorHandlingDeserializer<>(jsonDeserializer()));        // For the value deserializer
	}

	private JsonDeserializer<OrderCreatedEvent> jsonDeserializer() {
	    JsonDeserializer<OrderCreatedEvent> deserializer = new JsonDeserializer<>(OrderCreatedEvent.class);
	    deserializer.setRemoveTypeHeaders(false);
	    deserializer.addTrustedPackages("events");
	    deserializer.setUseTypeMapperForKey(false);
	    return deserializer;
	}

	@Bean
	ConcurrentKafkaListenerContainerFactory<String,OrderCreatedEvent> OrderCreatedEvent() 
	{ 
		ConcurrentKafkaListenerContainerFactory< 
		String, OrderCreatedEvent> factory 
		= new ConcurrentKafkaListenerContainerFactory<>(); 
		factory.setConsumerFactory(consumerFactory()); 

		return factory; 
	}
}
