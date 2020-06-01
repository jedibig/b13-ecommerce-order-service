package com.b13.orderservice.message;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.b13.orderservice.dto.inventory.InventoryStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class InventoryProducerImpl implements InventoryProducer {
	static Logger logger = Logger.getLogger(InventoryProducerImpl.class.getName());

	private final KafkaTemplate<String,String> template;
	private final ObjectMapper mapper;
	
	@Override
	public void productUpdateStatus(String productId, InventoryStatus status) {
		Map<String, Object> map = new HashMap<>();
		map.put("productId", productId);
		map.put("status", status);
		try {
			template.send("", mapper.writeValueAsString(map));
		} catch (JsonProcessingException e) {
			logger.severe(e.getMessage());
		}

	}

}
