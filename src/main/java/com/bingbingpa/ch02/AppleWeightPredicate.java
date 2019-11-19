package com.bingbingpa.ch02;

public class AppleWeightPredicate implements ApplePredicate {

    @Override
    public boolean getAppleValue(Apple apple) {
        return apple.getWeight() > 150;
    }
}