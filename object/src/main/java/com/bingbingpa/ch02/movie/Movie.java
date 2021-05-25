package com.bingbingpa.ch02.movie;

import com.bingbingpa.ch02.money.Money;

import ch.qos.logback.core.util.Duration;

public class Movie {
	private String title;
	private Duration runningTime;
	private Money fee;
	private DefaultDiscountPolicy discountPolicy;
	
	public Movie(String title, Duration runningTime, Money fee, DefaultDiscountPolicy discountPolicy) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountPolicy = discountPolicy;
	}
	
	public Money getFee() {
		return fee;
	}
	
	public Money calculateMovieFee(Screening screening) {
		return fee.minus(discountPolicy.calculateDiscountAmount(screening));
	}
}