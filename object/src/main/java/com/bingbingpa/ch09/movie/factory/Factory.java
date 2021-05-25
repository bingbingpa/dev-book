package com.bingbingpa.ch09.movie.factory;

import java.time.Duration;

import com.bingbingpa.ch09.money.Money;
import com.bingbingpa.ch09.movie.Movie;
import com.bingbingpa.ch09.movie.pricing.AmountDiscountPolicy;
import com.bingbingpa.ch09.movie.pricing.SequenceCondition;

public class Factory {
    public Movie createAvatarMovie() {
        return new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(
                    Money.wons(800),
                    new SequenceCondition(1),
                    new SequenceCondition(10)));
    }
}
