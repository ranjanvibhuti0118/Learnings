package com.app.springbatch.kafkaConfig;

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

import com.app.order.events.OrderCreatedEvent;

@Configuration
@EnableKafka
class KafkaConsumerConfig {

		@Bean
		 ConcurrentKafkaListenerContainerFactory<String, OrderCreatedEvent> kafkaListenerContainerFactory(){
			 ConcurrentKafkaListenerContainerFactory<String, OrderCreatedEvent> factory =
		                new ConcurrentKafkaListenerContainerFactory<>();
		        factory.setConsumerFactory(consumerFactory());
		        return factory;
		}
	
		@Bean
		 ConsumerFactory<String, OrderCreatedEvent> consumerFactory() {
	
			Map<String, Object> configProps = new HashMap<>();
			configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
			configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
			configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
			
		    // Configure the ErrorHandlingDeserializer
		    return new DefaultKafkaConsumerFactory<>(configProps,
		        new ErrorHandlingDeserializer<>(new StringDeserializer()),  // For the key deserializer
		        new ErrorHandlingDeserializer<>(jsonDeserializer()));        // For the value deserializer
		}

		private JsonDeserializer<OrderCreatedEvent> jsonDeserializer() {
		    JsonDeserializer<OrderCreatedEvent> deserializer = new JsonDeserializer<>(OrderCreatedEvent.class);
		    deserializer.setRemoveTypeHeaders(false);
		    deserializer.addTrustedPackages("com.app.order.events");
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
