package com.bingbingpa.ch09.movie.pricing;

import com.bingbingpa.ch09.money.Money;
import com.bingbingpa.ch09.movie.DiscountCondition;
import com.bingbingpa.ch09.movie.DiscountPolicy;
import com.bingbingpa.ch09.movie.Screening;

public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}