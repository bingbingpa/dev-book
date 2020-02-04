package com.bingbingpa.ch09.movie.pricing;

import com.bingbingpa.ch09.money.Money;
import com.bingbingpa.ch09.movie.DiscountPolicy;
import com.bingbingpa.ch09.movie.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
