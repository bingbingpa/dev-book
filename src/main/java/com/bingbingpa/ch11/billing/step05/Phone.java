package com.bingbingpa.ch11.billing.step05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bingbingpa.ch11.money.Money;

public class Phone {
    private RatePolicy ratePolicy;
    private List<Call> calls = new ArrayList<>();

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public List<Call> getCalls() {
        return Collections.unmodifiableList(calls);
    }

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }
}
