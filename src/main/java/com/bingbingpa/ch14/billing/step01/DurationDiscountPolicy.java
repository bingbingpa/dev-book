package com.bingbingpa.ch14.billing.step01;

import java.util.ArrayList;
import java.util.List;

import com.bingbingpa.ch14.money.Money;

public class DurationDiscountPolicy extends BasicRatePolicy {
    private List<DurationDiscountRule> rules = new ArrayList<>();

    public DurationDiscountPolicy(List<DurationDiscountRule> rules) {
        this.rules = rules;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        Money result = Money.ZERO;
        for(DurationDiscountRule rule: rules) {
            result.plus(rule.calculate(call));
        }
        return result;
    }
}
