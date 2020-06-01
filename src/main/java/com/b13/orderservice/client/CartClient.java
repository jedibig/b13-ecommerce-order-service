package com.b13.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.b13.orderservice.dto.cart.Cart;

@FeignClient("order-service")
public interface CartClient {
	
	@GetMapping("/cart/{id}")
	public Cart getCart(@PathVariable String id);

}
