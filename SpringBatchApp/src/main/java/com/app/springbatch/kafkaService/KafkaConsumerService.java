package com.app.springbatch.kafkaService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.app.order.events.OrderCreatedEvent;
import com.app.springbatch.DTO.OrderDto;
import com.app.springbatch.entity.Inventory;
import com.app.springbatch.service.InventoryService;



@Component
public class KafkaConsumerService {

	@Autowired
	private InventoryService invService;
	
	private RestTemplate restTemplate=new RestTemplate();

	
    private static final String TOPIC = "demoOrder";

    @KafkaListener(topics = TOPIC, groupId = "order-consumer-group")
    public void consumeOrderEvent(OrderCreatedEvent event) {
        
    	Long lOrderId=event.getOrderId();
    	Map<Long,Integer> productQtyMap=event.getProductQtyMap();
    	
    	for(Map.Entry<Long, Integer> productQty:productQtyMap.entrySet()) {
    		
    		Long productId=productQty.getKey();
    		Integer qty= productQty.getValue();
    		
    		Inventory inv = invService.findInventory(String.valueOf(productId), String.valueOf(qty));
    		
    		if(inv!=null) {
    			
    			Integer iAvailableQty=inv.getQty();
    			if(iAvailableQty>=qty) {
    				inv.setQty(iAvailableQty-qty);
    				invService.updateInventory(inv);
    				updateOrder("Accepted",lOrderId);
    			}else {
    				updateOrder("Rejected",lOrderId);	
    			}
    		}
    		
    	}
    	
    }

	private void updateOrder(String orderStatus, Long lOrderId) {
		OrderDto orderDto = new OrderDto();
		orderDto.setOrderId(lOrderId);
		orderDto.setOrderStatus(orderStatus);
		restTemplate.put("http://localhost:8081/api/order/v1/changeOrder", orderDto);
	}
}
