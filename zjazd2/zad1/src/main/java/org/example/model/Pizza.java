package org.example.model;

public class Pizza {
    private String name;
    private Boolean isAvailable;
    private double price;

    public Pizza(String name, Boolean isAvailable, double price) {
        this.name = name;
        this.isAvailable = isAvailable;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
