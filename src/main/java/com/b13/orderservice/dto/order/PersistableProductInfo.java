package com.b13.orderservice.dto.order;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersistableProductInfo {
	@Id
	private String product_id;
	private int quantity;
	private BigDecimal price;
	private String productImageUrl;
	private String sku;
}
