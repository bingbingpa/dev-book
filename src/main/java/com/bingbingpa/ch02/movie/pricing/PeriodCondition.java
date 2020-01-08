package com.bingbingpa.ch02.movie.pricing;

import java.time.DayOfWeek;
import java.time.LocalTime;

import com.bingbingpa.ch02.movie.DiscountCondition;
import com.bingbingpa.ch02.movie.Screening;

public class PeriodCondition implements DiscountCondition {
	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	private LocalTime endTime;
	
	public PeriodCondition(DayOfWeek dayOfWeek, LocalTime starTime, LocalTime endTime) {
		this.dayOfWeek = dayOfWeek;
		this.startTime = starTime;
		this.endTime = endTime;
	}

	@Override
	public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
                startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 &&
                endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }
}
