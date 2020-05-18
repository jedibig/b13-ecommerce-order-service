package com.b13.orderservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductInformation {
	private String product_id;
	private int quantity;
	private BigDecimal price;
	private String productImageUrl;
	private String sku;
}
