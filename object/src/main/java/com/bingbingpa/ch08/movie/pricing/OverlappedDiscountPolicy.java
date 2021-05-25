package com.bingbingpa.ch08.movie.pricing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bingbingpa.ch08.money.Money;
import com.bingbingpa.ch08.movie.DiscountPolicy;
import com.bingbingpa.ch08.movie.Screening;

public class OverlappedDiscountPolicy extends DiscountPolicy {
    private List<DiscountPolicy> discountPolicies = new ArrayList<>();

    public OverlappedDiscountPolicy(DiscountPolicy ... discountPolicies) {
        this. discountPolicies = Arrays.asList(discountPolicies);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        Money result = Money.ZERO;
        for(DiscountPolicy each : discountPolicies) {
            result = result.plus(each.calculateDiscountAmount(screening));
        }
        return result;
    }
}
