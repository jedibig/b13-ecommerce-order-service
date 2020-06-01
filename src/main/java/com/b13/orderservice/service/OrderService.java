package com.b13.orderservice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.b13.orderservice.dto.Order;
import com.b13.orderservice.dto.cart.Cart;

@Transactional(value = Transactional.TxType.REQUIRES_NEW)
public interface OrderService {

    Order insertNewOrder(Cart cart);

    Optional<Order> getOrderById(long id);
    
    
    Optional<Order>  updatePayment(long id, String payment);


    boolean modifyOrder(Order order);

    Optional<List<Order>> getOrdersByCustomerId(String customerId);


	Optional<Order> updateShipment(String shipping, long orderId);

	Optional<Order> settle(long id);

}
