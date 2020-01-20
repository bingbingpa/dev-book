package com.bingbingpa.ch05.movie.step04;

import java.time.Duration;

import com.bingbingpa.ch05.money.Money;

public class NoneDiscountMovie extends Movie {
    public NoneDiscountMovie(String title, Duration runningTime, Money fee) {
        super(title, runningTime, fee);
    }

    @Override
    protected Money calculateDiscountAmount() {
        return Money.ZERO;
    }
}