package com.b13.orderservice.dto;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "b13_order_table")
public class NewOrder {

    @Column(name = "customer_id")
    @NotNull @NotEmpty
    private String customerId;

    @Column(name = "shipper")
    @NotNull @NotEmpty
    private String shipper;

    @NotNull
    @ElementCollection
    private List<Product> products;
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Product{
    	public String productId;
    	public int quantity;
    	public String sku;
    }
}
