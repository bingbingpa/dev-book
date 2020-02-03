package com.bingbingpa.ch08.movie.pricing;

import com.bingbingpa.ch08.money.Money;
import com.bingbingpa.ch08.movie.DiscountCondition;
import com.bingbingpa.ch08.movie.DiscountPolicy;
import com.bingbingpa.ch08.movie.Screening;

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
