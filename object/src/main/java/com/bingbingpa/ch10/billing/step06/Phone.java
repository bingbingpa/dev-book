package com.bingbingpa.ch10.billing.step06;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import com.bingbingpa.ch10.money.Money;

public class Phone extends AbstractPhone {
    private Money amount;
    private Duration seconds;

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
