package com.bingbingpa.ch02.movie.pricing;

import com.bingbingpa.ch02.movie.DiscountCondition;
import com.bingbingpa.ch02.movie.Screening;

public class SequenceCondition implements DiscountCondition {
	private int sequence;
	
	public SequenceCondition(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public boolean isSatisfiedBy(Screening screening) {
		return screening.isSequence(sequence);
	}
	
	
}
