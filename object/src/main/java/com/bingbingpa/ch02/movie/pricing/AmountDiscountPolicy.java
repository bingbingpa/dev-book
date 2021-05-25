package com.bingbingpa.ch02.movie.pricing;

import com.bingbingpa.ch02.money.Money;
import com.bingbingpa.ch02.movie.DiscountCondition;
import com.bingbingpa.ch02.movie.DefaultDiscountPolicy;
import com.bingbingpa.ch02.movie.Screening;

public class AmountDiscountPolicy extends DefaultDiscountPolicy{
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
