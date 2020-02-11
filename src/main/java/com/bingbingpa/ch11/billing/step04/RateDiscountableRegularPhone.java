package com.bingbingpa.ch11.billing.step04;

import java.time.Duration;

import com.bingbingpa.ch11.money.Money;

public class RateDiscountableRegularPhone extends RegularPhone {
    private Money discountAmount;

    public RateDiscountableRegularPhone(Money amount, Duration seconds, Money discountAmount) {
        super(amount, seconds);
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
