package com.bingbingpa.ch02.movie.pricing;

import com.bingbingpa.ch02.money.Money;
import com.bingbingpa.ch02.movie.DiscountPolicy;
import com.bingbingpa.ch02.movie.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
