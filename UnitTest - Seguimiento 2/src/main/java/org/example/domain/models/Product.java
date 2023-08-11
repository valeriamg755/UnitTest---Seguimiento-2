package org.example.domain.models;

import org.example.domain.enums.ProductType;

import java.util.Objects;

public class Product {

    private long id;
    private String name;
    private String category;
    private Double price;

    public Product() {
    }

    public Product(long id, String name, ProductType book, double price) {
    }

    public Product(long id, String name, String category, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Product) {
            Product product = (Product)o;
            return Objects.equals(this.getId(), product.getId());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.getId()});
    }

    public String toString() {
        return "Product{id=" + this.id + ", name='" + this.name + "', category='" + this.category + "', price=" + this.price + "}";
    }

}
