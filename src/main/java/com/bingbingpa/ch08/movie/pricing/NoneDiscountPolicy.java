package com.bingbingpa.ch08.movie.pricing;

import com.bingbingpa.ch08.money.Money;
import com.bingbingpa.ch08.movie.DiscountPolicy;
import com.bingbingpa.ch08.movie.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
