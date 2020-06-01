package com.b13.orderservice.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

import lombok.Data;

@Embeddable
@Data
@Table(name = "b13_order_product_table")
public class OrderSumary {
    @Column(name = "subtotal")
    private double subtotal;

    @Column(name = "tax")
    private double tax;

//    @Column(name = "priceAdjustment")
//    @Digits(integer = 10, fraction = 2, message = "digits out of bounds")
//    private BigDecimal adjustment;

    @Column(name = "shippingCost")
    private double shipping;

    @Column(name = "paid")
    private double paid;

//    @Column(name = "refunded")
//    @Min(value = 0, message = "negative value unacceptable")
//    @Digits(integer = 10, fraction = 2, message = "digits out of bounds")
//    private BigDecimal refunded;

    @Column(name = "total")
    private double grandtotal;

	public void calculateTotal() {
		grandtotal = subtotal + tax + shipping;
		
	}
    
    
}
