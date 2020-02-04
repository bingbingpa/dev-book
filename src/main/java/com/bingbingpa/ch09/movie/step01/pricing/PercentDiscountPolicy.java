package com.bingbingpa.ch09.movie.step01.pricing;

import com.bingbingpa.ch09.money.Money;
import com.bingbingpa.ch09.movie.step01.DiscountCondition;
import com.bingbingpa.ch09.movie.step01.DiscountPolicy;
import com.bingbingpa.ch09.movie.step01.Screening;

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
