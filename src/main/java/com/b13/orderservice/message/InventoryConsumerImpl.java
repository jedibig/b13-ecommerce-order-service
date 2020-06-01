package com.b13.orderservice.message;

import java.util.logging.Logger;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class InventoryConsumerImpl {
	static Logger logger = Logger.getLogger(InventoryConsumerImpl.class.getName());
	
	final ObjectMapper mapper;
	
	@KafkaListener(topics = "payment-order")
	public void paymentNotification(String payload) {
		logger.info("received payload='{}'"+ payload);
	}
	
}
