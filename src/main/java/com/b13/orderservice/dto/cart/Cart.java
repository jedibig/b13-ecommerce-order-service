package com.b13.orderservice.dto.cart;

import java.util.List;

import com.b13.orderservice.dto.ProductInformation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
	private String cartId;
	private List<ProductInformation> products;
}
