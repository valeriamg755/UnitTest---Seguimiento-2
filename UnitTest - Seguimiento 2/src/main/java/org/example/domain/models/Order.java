package org.example.domain.models;

import org.example.domain.enums.OrderType;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Order {

    private long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Client client;

    public Order(long id, OrderType cancelled, LocalDate orderDate, LocalDate deliveryDate, List<Product> productsB, Client client) {
    }

    public Order(long id) {
        this.id = id;
    }

    public Order(long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Client client) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.client = client;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return this.deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Order) {
            Order order = (Order)o;
            return this.getId() == order.getId();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.getId()});
    }

    public String toString() {
        return "Order{id=" + this.id + ", status='" + this.status + "', orderDate=" + this.orderDate + ", deliveryDate=" + this.deliveryDate + ", products=" + this.products + ", client=" + this.client + "}";
    }

}
