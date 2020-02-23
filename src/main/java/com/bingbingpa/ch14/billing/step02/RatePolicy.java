package com.bingbingpa.ch14.billing.step02;

import com.bingbingpa.ch14.money.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
