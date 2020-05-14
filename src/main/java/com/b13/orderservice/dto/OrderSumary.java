package com.b13.orderservice.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Embeddable
@Data
@Table(name = "b13_order_product_table")
public class OrderSumary {
    @Column(name = "subtotal")
    @Min(value = 0, message = "negative value unacceptable")
    @Digits(integer = 10, fraction = 2, message = "digits out of bounds")
    private BigDecimal subtotal;

    @Column(name = "tax")
    @Min(value = 0, message = "negative value unacceptable")
    @Digits(integer = 10, fraction = 2, message = "digits out of bounds")
    private BigDecimal tax;

    @Column(name = "priceAdjustment")
    @Digits(integer = 10, fraction = 2, message = "digits out of bounds")
    private BigDecimal adjustment;

    @Column(name = "shippingCost")
    @Min(value = 0, message = "negative value unacceptable")
    @Digits(integer = 10, fraction = 2, message = "digits out of bounds")
    private BigDecimal shipping;

    @Column(name = "paid")
    @Min(value = 0, message = "negative value unacceptable")
    @Digits(integer = 10, fraction = 2, message = "digits out of bounds")
    private BigDecimal paid;

    @Column(name = "refunded")
    @Min(value = 0, message = "negative value unacceptable")
    @Digits(integer = 10, fraction = 2, message = "digits out of bounds")
    private BigDecimal refunded;

    @Column(name = "total")
    @Min(value = 0, message = "negative value unacceptable")
    @Digits(integer = 10, fraction = 2, message = "digits out of bounds")
    private BigDecimal grandtotal;
}
