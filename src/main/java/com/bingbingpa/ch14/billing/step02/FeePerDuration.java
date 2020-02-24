package com.bingbingpa.ch14.billing.step02;

import java.time.Duration;

import com.bingbingpa.ch14.money.Money;
import com.bingbingpa.ch14.time.DateTimeInterval;

public class FeePerDuration {
    private Money fee;
    private Duration duration;

    public FeePerDuration(Money fee, Duration duration) {
        this.fee = fee;
        this.duration = duration;
    }

    public Money calculate(DateTimeInterval interval) {
        return fee.times(interval.duration().getSeconds() / duration.getSeconds());
    }
}

