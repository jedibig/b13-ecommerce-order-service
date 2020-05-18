package com.b13.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StringResponse {
	String message;
	
	public static StringResponse of(String message) {
		return new StringResponse(message);
	}
}
