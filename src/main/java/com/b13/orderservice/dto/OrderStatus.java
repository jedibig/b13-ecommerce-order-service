package com.b13.orderservice.dto;

import javax.persistence.Embeddable;

@Embeddable
public enum OrderStatus {
    NEW, AWAIT_PAYMENT, PAID, MODIFIED, CANCELED, CANCELED_REQUEST, RETURNED_REQUEST;

    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
