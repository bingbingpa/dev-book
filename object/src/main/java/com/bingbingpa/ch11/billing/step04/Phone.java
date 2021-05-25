package com.bingbingpa.ch11.billing.step04;

import java.util.ArrayList;
import java.util.List;

import com.bingbingpa.ch11.money.Money;

public abstract class Phone {
    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for(Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return afterCalculated(result);
    }

    protected Money afterCalculated(Money fee) {
        return fee;
    }

    protected abstract Money calculateCallFee(Call call);
}
