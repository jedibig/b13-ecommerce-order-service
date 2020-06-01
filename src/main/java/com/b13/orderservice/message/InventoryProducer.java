package com.b13.orderservice.message;

import com.b13.orderservice.dto.inventory.InventoryStatus;

public interface InventoryProducer {
	
	public void productUpdateStatus(String productId, InventoryStatus status);

//	public void paymentNewOrder(Order order);
//
//	public void shippingNewOrder(Order order);
}
