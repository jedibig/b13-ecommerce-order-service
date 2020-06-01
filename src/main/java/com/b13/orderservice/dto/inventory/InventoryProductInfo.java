package com.b13.orderservice.dto.inventory;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

import com.b13.orderservice.dto.ProductInformation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class InventoryProductInfo {
	private BigDecimal price;
	private String productImageUrl;
}
