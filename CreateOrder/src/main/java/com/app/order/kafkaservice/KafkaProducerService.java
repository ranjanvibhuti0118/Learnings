package com.app.order.kafkaservice;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.app.order.entity.Order;
import com.app.order.events.OrderCreatedEvent;

@Service
public class KafkaProducerService {

	@Autowired	
    public KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    private static final String TOPIC = "demoOrder";

    public void sendMessage(Order order) {
    	
    	
    	Map<Long, Integer> productQtyMap = order.getProducts().stream().collect(Collectors.toMap(product->product.getProductId(),product->product.getQty()));
    	OrderCreatedEvent event= new OrderCreatedEvent(order.getOrderId(),productQtyMap);
    	
        CompletableFuture<SendResult<String, OrderCreatedEvent>> sent = kafkaTemplate.send(TOPIC, event);
        sent.thenAccept(result -> {
            ProducerRecord<String, OrderCreatedEvent> producerRecord = result.getProducerRecord();
            RecordMetadata metadata = result.getRecordMetadata();
            System.out.println("Message sent successfully to topic: " + metadata.topic()
                    + " partition: " + metadata.partition()
                    + " offset: " + metadata.offset());
        }).exceptionally(ex -> {
            System.err.println("Message sending failed: " + ex.getMessage());
            return null;
        });
        
        System.out.println("Order sent to Kafka: " + event);

    }	
	
}

