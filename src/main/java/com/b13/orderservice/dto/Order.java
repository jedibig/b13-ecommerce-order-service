package com.b13.orderservice.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "b13_order_table")
@JsonInclude(Include.NON_DEFAULT)
public class Order {
    @Id @Column(name = "order_id")
    @GeneratedValue
    private long id;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "shippingId")
    private String shippingId;
    
    @Column(name = "shipper")
    private String shipper;
    
    private String creditCardNumber;

    @Enumerated(EnumType.STRING)
    @Embedded
    private OrderStatus status;

    @NotNull
    @OneToMany
    private List<ProductInformation> products;
    
    @DateTimeFormat(pattern = "dd-MM-yy")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp")
    private Date timestamp;

    @DateTimeFormat(pattern = "dd-MM-yy")
    @Temporal(TemporalType.DATE)
    @Column(name = "orderPlaced")
    private Date orderPlaced;

    @Column(name = "invoiceUrl")
    private String invoiceUrl;

    @Embedded
    private OrderSumary summary;

	public void generateSummary() {
		if (summary == null)
			summary = new OrderSumary();
		summary.setTax(0.9);
		summary.setSubtotal(products.stream().mapToDouble(products -> products.getPrice().doubleValue()).sum());
		summary.calculateTotal();
	}
      
}
