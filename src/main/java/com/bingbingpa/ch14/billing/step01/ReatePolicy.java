package com.bingbingpa.ch14.billing.step01;

import com.bingbingpa.ch10.billing.step01.Phone;
import com.bingbingpa.ch10.money.Money;

public interface ReatePolicy {
	Money calculateFee(Phone phone);
}
