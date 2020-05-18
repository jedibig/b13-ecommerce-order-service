package com.b13.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "b13_order_table")
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

    @Enumerated(EnumType.STRING)
    @Embedded
    private OrderStatus status;

    @NotNull
    @ElementCollection
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
      
}
