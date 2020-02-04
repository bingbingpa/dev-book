package com.bingbingpa.ch09.movie.pricing;

import com.bingbingpa.ch09.money.Money;
import com.bingbingpa.ch09.movie.DiscountCondition;
import com.bingbingpa.ch09.movie.DiscountPolicy;
import com.bingbingpa.ch09.movie.Screening;

public class PercentDiscountPolicy extends DiscountPolicy {
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
