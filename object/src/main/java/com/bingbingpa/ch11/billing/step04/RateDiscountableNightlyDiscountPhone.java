package com.bingbingpa.ch11.billing.step04;

import java.time.Duration;

import com.bingbingpa.ch11.money.Money;

public class RateDiscountableNightlyDiscountPhone extends NightlyDiscountPhone {
    private Money discountAmount;

    public RateDiscountableNightlyDiscountPhone(Money nightlyAmount,
                                                Money regularAmount, Duration seconds, Money discountAmount) {
        super(nightlyAmount, regularAmount, seconds);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
