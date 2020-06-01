package com.b13.orderservice.dto;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ProductInformation {
	@Id
	private String product_id;
	private int quantity;
	private BigDecimal price;
	private String productImageUrl;
	private String sku;
}
