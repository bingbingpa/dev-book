package com.bingbingpa.ch09.movie.locator;

import com.bingbingpa.ch09.movie.DiscountPolicy;

public class ServiceLocator {
	// 숨겨진 의존성은 지양하자! 
    private static ServiceLocator soleInstance = new ServiceLocator();
    private DiscountPolicy discountPolicy;

    public static DiscountPolicy discountPolicy() {
        return soleInstance.discountPolicy;
    }

    public static void provide(DiscountPolicy discountPolicy) {
        soleInstance.discountPolicy = discountPolicy;
    }

    private ServiceLocator() {
    }
}
