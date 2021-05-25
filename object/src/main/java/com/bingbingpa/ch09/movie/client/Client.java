package com.bingbingpa.ch09.movie.client;

import java.time.Duration;

import com.bingbingpa.ch09.money.Money;
import com.bingbingpa.ch09.movie.Movie;
import com.bingbingpa.ch09.movie.pricing.AmountDiscountPolicy;
import com.bingbingpa.ch09.movie.pricing.SequenceCondition;

/**
 * 클라이언트로 컨텍스트에 대한 지식을 옮긴다. 
 * @author shpark
 *
 */
public class Client {
    public Money getAvatarFee() {
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(
                    Money.wons(800),
                    new SequenceCondition(1),
                    new SequenceCondition(10)));
        return avatar.getFee();
    }
}

