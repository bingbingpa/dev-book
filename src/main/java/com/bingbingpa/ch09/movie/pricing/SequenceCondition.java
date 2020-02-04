package com.bingbingpa.ch09.movie.pricing;

import com.bingbingpa.ch09.movie.DiscountCondition;
import com.bingbingpa.ch09.movie.Screening;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
