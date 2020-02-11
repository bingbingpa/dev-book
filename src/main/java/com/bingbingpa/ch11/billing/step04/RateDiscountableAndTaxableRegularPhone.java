package com.bingbingpa.ch11.billing.step04;

import java.time.Duration;

import com.bingbingpa.ch11.money.Money;

public class RateDiscountableAndTaxableRegularPhone extends RateDiscountableRegularPhone {
	private double taxRate;

	public RateDiscountableAndTaxableRegularPhone(Money amount, Duration seconds, Money discountAmount,
			double taxRate) {
		super(amount, seconds, discountAmount);
		this.taxRate = taxRate;
	}

	@Override
	protected Money afterCalculated(Money fee) {
		return super.afterCalculated(fee).plus(fee.times(taxRate));
	}
}