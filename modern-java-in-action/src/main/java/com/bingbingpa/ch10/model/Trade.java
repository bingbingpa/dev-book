package com.bingbingpa.ch10.model;

public class Trade {

    private Type type;
    private Stock stock;
    private int quantity;
    private double price;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public double getValue() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return String.format("Trade[type=%s, stock=%s, quantity=%d, price=%.2f]", type, stock, quantity, price);
    }

    public enum Type {
        BUY,
        SELL
    }

}