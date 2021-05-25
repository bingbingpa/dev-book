package com.bingbingpa.ch14.billing.step02;

import java.util.List;

import com.bingbingpa.ch14.time.DateTimeInterval;

public interface FeeCondition {
    List<DateTimeInterval> findTimeIntervals(Call call);
}
