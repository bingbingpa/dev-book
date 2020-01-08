package com.bingbingpa.ch02.movie.pricing;

import com.bingbingpa.ch02.money.Money;
import com.bingbingpa.ch02.movie.DiscountCondition;
import com.bingbingpa.ch02.movie.DefaultDiscountPolicy;
import com.bingbingpa.ch02.movie.Screening;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
