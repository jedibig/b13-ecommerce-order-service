package com.b13.orderservice.controller;

import com.b13.orderservice.dto.Order;
import com.b13.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    final OrderService orderService;

    @GetMapping("/{id}")
    public Optional<Order> retrieveOrderById(@PathVariable("id") long id){
        return orderService.getOrderById(id);
    }
}
