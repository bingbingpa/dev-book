package com.bingbingpa.ch11.billing.step04;

import java.time.Duration;

import com.bingbingpa.ch11.money.Money;

public class RateDiscountableAndTaxableNightlyDiscountPhone extends RateDiscountableNightlyDiscountPhone {
	private double taxRate;

	public RateDiscountableAndTaxableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds,
			Money discountAmount, double taxRate) {
		super(nightlyAmount, regularAmount, seconds, discountAmount);
		this.taxRate = taxRate;
	}

	@Override
	protected Money afterCalculated(Money fee) {
		return super.afterCalculated(fee).plus(fee.times(taxRate));
	}
}
