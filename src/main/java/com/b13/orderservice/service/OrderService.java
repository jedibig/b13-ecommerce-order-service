package com.b13.orderservice.service;

import com.b13.orderservice.dto.Order;
import org.springframework.cache.annotation.CachePut;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional(value = Transactional.TxType.REQUIRES_NEW)
public interface OrderService {

    Order newOrder(Order order);

    @CachePut
    Optional<Order> getOrderById(long id);

    @CachePut
    Order modifyOrder(Order order);

    Optional<Order> getOrderByCustomerId(String customerId);

}
