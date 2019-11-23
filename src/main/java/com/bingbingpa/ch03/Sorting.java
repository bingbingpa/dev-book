package com.bingbingpa.ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.bingbingpa.ch02.Color;

public class Sorting {

    public static void main(String... args) {

        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(
            new Apple(80, Color.GREEN),
            new Apple(155, Color.RED),
            new Apple(120, Color.RED)
        ));
    }

    // inventory.sort(new AppleComparator());

    static class AppleComparator implements Comparator<Apple> {

        @Override
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight() - a2.getWeight();
        }
    }
}