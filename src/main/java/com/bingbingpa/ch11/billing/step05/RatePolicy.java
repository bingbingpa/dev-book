package com.bingbingpa.ch11.billing.step05;

import com.bingbingpa.ch11.money.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
