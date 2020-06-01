package com.b13.orderservice.dto.order;

import java.util.List;

import com.b13.orderservice.dto.OrderStatus;
import com.b13.orderservice.dto.OrderSumary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReadableOrder {
	private long id;
    private String customerId;

    private String shippingId;
    
    private String shipper;
    
    private String creditCardNumber;

    private OrderStatus status;

    private List<PersistableProductInfo> products;

    private String invoiceUrl;

    private OrderSumary summary;
}
