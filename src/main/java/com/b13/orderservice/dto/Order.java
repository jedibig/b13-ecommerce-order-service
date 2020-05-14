package com.b13.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Map;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "b13_order_table")
public class Order {
    @Id @Column(name = "order_id")
    private long id;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "shippingId")
    private String shippingId;

    @Enumerated(EnumType.STRING)
    @Embedded
    private Status status;

    @NotNull
    @ElementCollection
    @MapKeyColumn(name="productId")
    @Column(name="imageUrl")
    @CollectionTable(name="b13_order_product_table", joinColumns=@JoinColumn(name="order_id"))
    private Map<String, String> products; // productId + imageUrl

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

    @Embeddable
    public enum Status {
        NEW, AWAIT_PAYMENT, PAID, MODIFIED, CANCELED, CANCELED_REQUEST, RETURNED_REQUEST;

        private String note;

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }
    }
}
