package com.bingbingpa.ch10.billing.step06;

import java.util.ArrayList;
import java.util.List;

import com.bingbingpa.ch10.money.Money;

public abstract class AbstractPhone {
    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for(Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    abstract protected Money calculateCallFee(Call call);
}
