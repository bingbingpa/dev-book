package com.bingbingpa.ch10.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {

    private String customer;
    private List<Trade> trades = new ArrayList<>();

    public void addTrade(Trade trade) {
        trades.add(trade);
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getValue() {
        return trades.stream().mapToDouble(Trade::getValue).sum();
    }

    @Override
    public String toString() {
        String strTrades = trades.stream().map(t -> "  " + t).collect(Collectors.joining("\n", "[\n", "\n]"));
        return String.format("Order[customer=%s, trades=%s]", customer, strTrades);
    }

}