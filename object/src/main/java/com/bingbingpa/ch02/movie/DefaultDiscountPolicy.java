package com.bingbingpa.ch02.movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bingbingpa.ch02.money.Money;

public abstract class DefaultDiscountPolicy {
	private List<DiscountCondition> conditions = new ArrayList<>();
	
	public DefaultDiscountPolicy(DiscountCondition...conditions ) {
		this.conditions = Arrays.asList(conditions);
	}
	
	public Money calculateDiscountAmount(Screening screening) {
		for(DiscountCondition each : conditions) {
			if(each.isSatisfiedBy(screening)) {
				return getDiscountAmount(screening);
			}
		}
		
		return Money.ZERO; 
	}
	
	abstract protected Money getDiscountAmount(Screening screening);
}
