package org.example.mapping.dtos;

import java.time.LocalDate;

public record OrderDto(long id, String status, LocalDate orderDate, LocalDate deliveryDate) {

    public OrderDto(long id, String status, LocalDate orderDate, LocalDate deliveryDate) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }

    public long id() {
        return this.id;
    }

    public String status() {
        return this.status;
    }

    public LocalDate orderDate() {
        return this.orderDate;
    }

    public LocalDate deliveryDate() {
        return this.deliveryDate;
    }

}