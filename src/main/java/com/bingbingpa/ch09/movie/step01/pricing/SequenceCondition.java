package com.bingbingpa.ch09.movie.step01.pricing;

import com.bingbingpa.ch09.movie.step01.DiscountCondition;
import com.bingbingpa.ch09.movie.step01.Screening;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
