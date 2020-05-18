package com.b13.orderservice.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Service;

import com.b13.orderservice.dao.OrderRepository;
import com.b13.orderservice.dto.NewOrder;
import com.b13.orderservice.dto.Order;
import com.b13.orderservice.dto.OrderStatus;
import com.b13.orderservice.dto.ProductInformation;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

	final OrderRepository repository;
	final InventoryService inventory;
//	final RabbitTemplate rabbitTemplate;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public Optional<Order> insertNewOrder(NewOrder newOrder) {
		Order order = new Order();
		order.setCustomerId(newOrder.getCustomerId());
		order.setShipper(newOrder.getShipper());
		order.setProducts(new LinkedList<ProductInformation>());
		newOrder.getProducts().forEach(product -> {
			order.getProducts().add(ProductInformation.builder()
							  .product_id(product.productId)
							  .quantity(product.quantity)
							  .sku(product.sku).build());
//			rabbitTemplate.convertAndSend("order-product", product.productId);
			
			inventory.removeFromInventory(product.sku, product.quantity);
			
			});
		order.setOrderPlaced(new Date());
		order.setTimestamp(new Date());
		order.setStatus(OrderStatus.NEW);
		
		//TODO invoiceUrl, Order summary
		
		repository.save(order);
		
		
		return Optional.of(order);
	}

	@Override
	public Optional<Order> getOrderById(long id) {
		return repository.findById(id);
	}

	@Override
	public boolean modifyOrder(Order order) {
		// TODO modify order with event sourcing maybe
		return false;
	}

	@Override
	public Optional<List<Order>> getOrdersByCustomerId(String customerId) {
		return repository.findByCustomerId();
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public boolean requestCancelation(long id) {
		// TODO request cancellation
		return false;
	}

}
