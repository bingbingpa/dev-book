package com.bingbingpa.ch02;

public class AppleRedAndHeavyPredicate implements ApplePredicate {

    @Override
    public boolean getAppleValue(Apple apple) {
        return apple.getColor() == Color.GREEN && apple.getWeight() > 150;
    }
}