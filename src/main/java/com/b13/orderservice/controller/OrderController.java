package com.b13.orderservice.controller;

import java.net.URISyntaxException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.b13.orderservice.dto.NewOrder;
import com.b13.orderservice.dto.Order;
import com.b13.orderservice.dto.StringResponse;
import com.b13.orderservice.dto.cart.Cart;
import com.b13.orderservice.exception.OrderIdNotFoundException;
import com.b13.orderservice.service.OrderService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    final OrderService orderService;

    @GetMapping("/{id}")
    public Optional<Order> retrieveOrderById(@PathVariable("id") long id){
        return orderService.getOrderById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Order SubmitNewOrder(@RequestBody Cart cart)  {
    	return orderService.insertNewOrder(cart); 
    }
    
    
    @PutMapping("/{id}/shipment")
    public ResponseEntity<Order> updateShippingInformation(@PathVariable("id") long id, @RequestBody String shipping)  {
    	return ResponseEntity.of(orderService.updateShipment(shipping, id)); 
    }
    
    @PutMapping("/{id}/payment")
    public ResponseEntity<?> updatePayment(@PathVariable("id") long id, @RequestBody String payment)  {
    	return ResponseEntity.of(orderService.updatePayment(id, payment)); 
    }
    
    @PutMapping("/{id}/final")
    public ResponseEntity<?> settleOrder(@PathVariable("id") long id)  {
    	Optional<Order> order =  orderService.settle(id); 
    	
    	return ResponseEntity.accepted().body(order.get());
    }
    
    @ExceptionHandler(OrderIdNotFoundException.class)
    public ResponseEntity<StringResponse> idNotFoundHandler(){
    	return ResponseEntity.notFound().build();
    }
}
