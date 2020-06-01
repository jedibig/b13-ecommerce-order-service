package com.b13.orderservice.dto.util;

import java.util.Date;

import com.b13.orderservice.OrderServiceApplication;
import com.b13.orderservice.dto.Order;
import com.b13.orderservice.dto.OrderStatus;
import com.b13.orderservice.dto.cart.Cart;

public class CartToOrderMapper extends OrderServiceApplication {

	public static Order mapCart(Cart cart) {
		Order order = new Order();
		order.setProducts(cart.getProducts());
		order.setStatus(OrderStatus.NEW);
		order.generateSummary();
		order.setTimestamp(new Date());
		return order;
	}
}
