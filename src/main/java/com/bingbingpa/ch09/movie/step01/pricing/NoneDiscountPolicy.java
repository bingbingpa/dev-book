package com.bingbingpa.ch09.movie.step01.pricing;

import com.bingbingpa.ch09.money.Money;
import com.bingbingpa.ch09.movie.step01.DiscountPolicy;
import com.bingbingpa.ch09.movie.step01.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
