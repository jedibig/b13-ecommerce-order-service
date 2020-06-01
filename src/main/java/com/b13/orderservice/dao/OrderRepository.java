package com.b13.orderservice.dao;

import com.b13.orderservice.dto.Order;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	Optional<List<Order>> findByCustomerId(String customerId);
}
