package com.bingbingpa.ch02;

public class AppleColorPredicate implements ApplePredicate {

    @Override
    public boolean getAppleValue(Apple apple) { 
        return apple.getColor() == Color.RED;
    }
}