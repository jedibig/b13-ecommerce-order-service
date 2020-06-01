package com.b13.orderservice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Service;

import com.b13.orderservice.dao.InventoryRepository;
import com.b13.orderservice.dto.ProductInformation;
import com.b13.orderservice.dto.inventory.Inventory;
import com.b13.orderservice.message.InventoryProducer;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {
	
	final InventoryRepository repository;
	final InventoryProducer producer;

	@Override
	public Optional<Inventory> getInventoryById(String sku) {
		return repository.findById(sku);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public Optional<Inventory> addToInventory(String sku, int quantity) {
		Optional<Inventory> invOptional = repository.findById(sku);
		if (!invOptional.isPresent())
			return Optional.empty();
		else {
			Inventory inventory = invOptional.get();
			producer.productUpdateStatus(sku, inventory.addQuantity(quantity));
			repository.save(inventory);	
		}
		return invOptional;
	}

	@Override
	public Optional<Inventory> addProduct(String sku, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public boolean removeFromInventory(String sku, int quantity) {
		Optional<Inventory> invOptional = repository.findById(sku);
		
		if (!invOptional.isPresent())
			return false;
		else {
			Inventory inventory = invOptional.get();
			producer.productUpdateStatus(sku, inventory.removeQuantity(quantity));
			repository.save(inventory);	
		}
		
		return true;
	}

	@Override
	public boolean holdItem(List<ProductInformation> products) {
		// TODO Auto-generated method stub
		return false;
	}

}
