package com.b13.orderservice.service;

import com.b13.orderservice.dto.NewOrder;
import com.b13.orderservice.dto.Order;



import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(value = Transactional.TxType.REQUIRES_NEW)
public interface OrderService {

    Optional<Order> insertNewOrder(NewOrder order);

    Optional<Order> getOrderById(long id);

    boolean modifyOrder(Order order);

    Optional<List<Order>> getOrdersByCustomerId(String customerId);

	boolean requestCancelation(long id);
}
