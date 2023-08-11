package org.example.domain.models;

import org.example.domain.enums.ClientType;

import java.util.Objects;

public class Client {

    private long id;
    private String name;
    private int tier;

    public Client(int id, String kimDokja, ClientType tier1) {
    }

    public Client(long id, String name, int tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
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

    public int getTier() {
        return this.tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Client) {
            Client client = (Client)o;
            return this.getId() == client.getId();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.getId()});
    }

    public String toString() {
        return "Client{id=" + this.id + ", name='" + this.name + "', tier=" + this.tier + "}";
    }

}
