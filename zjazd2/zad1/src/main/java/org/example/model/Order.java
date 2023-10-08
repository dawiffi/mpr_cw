package org.example.model;

import java.util.*;

public class Order {
    private int orderNumber;
    private List<Pizza> orderedPizzaList;
    private double price;

    public Order(int orderNumber, List<Pizza> orderedPizzaList, double price) {
        this.orderNumber = orderNumber;
        this.orderedPizzaList = orderedPizzaList;
        this.price = price;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<Pizza> getOrderedPizzaList() {
        return orderedPizzaList;
    }

    public void setOrderedPizzaList(List<Pizza> orderedPizzaList) {
        this.orderedPizzaList = orderedPizzaList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
