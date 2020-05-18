package com.b13.orderservice.controller;

import com.b13.orderservice.dto.NewOrder;
import com.b13.orderservice.dto.Order;
import com.b13.orderservice.dto.StringResponse;
import com.b13.orderservice.exception.OrderIdNotFoundException;
import com.b13.orderservice.service.OrderService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

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
    public ResponseEntity<?> SubmitNewOrder(@RequestBody NewOrder newOrder, HttpServletRequest request) throws URISyntaxException{
    	return orderService.insertNewOrder(newOrder).map(o -> 
    				ResponseEntity.created( URI.create(request.getRequestURI()+"/"+ o.getId())).build() )
    			.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build());
    	
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> cancelOrderById(@PathVariable("id") long id){
        if (orderService.requestCancelation(id)) {
        	return ResponseEntity.accepted().body("Cancellation request accepted");
        } else {
        	return ResponseEntity.badRequest().build(); 
        }
    }
    
    @ExceptionHandler(OrderIdNotFoundException.class)
    public ResponseEntity<StringResponse> idNotFoundHandler(){
    	return ResponseEntity.badRequest().body(StringResponse.of("Order not found"));
    }
}
