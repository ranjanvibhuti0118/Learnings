package com.app.consumer.config;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.app.consumer.events.OrderCreatedEvent;

@Service
public class KafkaConsumerService {

    private static final String TOPIC = "demoOrder";

    @KafkaListener(topics = TOPIC, groupId = "order-consumer-group")
    public void consumeOrderEvent(OrderCreatedEvent event) {
        

    	List<Long> productIDs= event.getProductIds();
    	
        
    }
}
