package com.bingbingpa.ch09.movie;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
