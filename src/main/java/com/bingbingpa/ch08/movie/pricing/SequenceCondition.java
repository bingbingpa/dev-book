package com.bingbingpa.ch08.movie.pricing;

import com.bingbingpa.ch08.movie.DiscountCondition;
import com.bingbingpa.ch08.movie.Screening;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
