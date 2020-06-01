package com.b13.orderservice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Service;

import com.b13.orderservice.client.ShippingClient;
import com.b13.orderservice.dao.OrderRepository;
import com.b13.orderservice.dto.Order;
import com.b13.orderservice.dto.ShippingInformation;
import com.b13.orderservice.dto.cart.Cart;
import com.b13.orderservice.dto.util.CartToOrderMapper;
import com.b13.orderservice.exception.NotEnoughInventoryException;
import com.b13.orderservice.exception.OrderIdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

	final OrderRepository repository;
	final InventoryService inventory;
//	final ShippingClient shippingClient;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public Order insertNewOrder(Cart cart) {
		Order order = CartToOrderMapper.mapCart(cart);
		if (!inventory.holdItem(order.getProducts()))
			throw new NotEnoughInventoryException();
		
		Order updatedOrder = repository.save(order);
		return updatedOrder;
	}
	
	@Override
	public Optional<Order> updateShipment(String shipping, long orderId) {
		Optional<Order> order = getOrderById(orderId);
		if (!order.isPresent()) {
			throw new OrderIdNotFoundException();
		}
		
		order.ifPresent(o -> {
//			ShippingInformation shipInfo = shippingClient.getShippingQuote(shipping);
//			o.setShippingId(shipInfo.getShippingId());
//			o.getSummary().setShipping(shipInfo.getCost().doubleValue());
		});
		return order;
	}




	@Override
	public Optional<Order> updatePayment(long id, String payment) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Optional<Order> getOrderById(long id) {
		return repository.findById(id);
	}


	@Override
	public Optional<Order> settle(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public boolean modifyOrder(Order order) {
		// TODO modify order with event sourcing maybe
		return false;
	}

	@Override
	public Optional<List<Order>> getOrdersByCustomerId(String customerId) {
		return repository.findByCustomerId(customerId);
	}


	
}
