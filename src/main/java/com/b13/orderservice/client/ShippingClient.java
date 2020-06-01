package com.b13.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.b13.orderservice.dto.ShippingInformation;

import feign.Headers;

//@FeignClient("shipping-service")
public interface ShippingClient {
	
	@PostMapping("/shipping")
	@Headers(HttpHeaders.CONTENT_TYPE+ ": "+ MediaType.APPLICATION_JSON_VALUE)
	public ShippingInformation getShippingQuote(@RequestBody String shipping); 
}
