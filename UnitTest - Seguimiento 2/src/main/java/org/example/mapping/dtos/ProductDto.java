package org.example.mapping.dtos;

public record ProductDto(long id, String name, String category, Double price) {

    public ProductDto(long id, String name, String category, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public long id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    public String category() {
        return this.category;
    }

    public Double price() {
        return this.price;
    }

}