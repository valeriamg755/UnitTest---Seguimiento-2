package org.example.mapping.dtos;

public record ClientDto(long id, String name, int tier) {

    public ClientDto(long id, String name, int tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    public long id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    public int tier() {
        return this.tier;
    }

}
