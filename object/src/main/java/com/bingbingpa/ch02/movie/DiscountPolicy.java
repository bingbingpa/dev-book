package com.bingbingpa.ch02.movie;

import com.bingbingpa.ch02.money.Money;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
