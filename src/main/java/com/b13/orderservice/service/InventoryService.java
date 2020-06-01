package com.b13.orderservice.service;

import java.util.List;
import java.util.Optional;

import com.b13.orderservice.dto.ProductInformation;
import com.b13.orderservice.dto.inventory.Inventory;


public interface InventoryService {

	Optional<Inventory> getInventoryById(String sku);
	
	Optional<Inventory> addToInventory(String sku, int quantity);
	
	Optional<Inventory> addProduct(String sku, int quantity);
	
	boolean removeFromInventory(String sku, int quantity);
	
	boolean holdItem(List<ProductInformation> products);
	
}
