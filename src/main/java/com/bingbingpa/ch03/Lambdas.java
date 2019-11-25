package com.bingbingpa.ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambdas {

    public static void main(String... args) {

        List<Apple> inventory = Arrays.asList(
            new Apple(80, Color.GREEN),
            new Apple(155, Color.GREEN),
            new Apple(120, Color.RED)
        );

        List<Apple> greenApples = filter(inventory, (Apple a ) -> a.getColor() == Color.GREEN);
        System.out.println(greenApples);

        Comparator<Apple> c= (Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight();

        inventory.sort(c);
        System.out.println(inventory);
    }

    public static List<Apple> filter(List<Apple> inventory, AppleProdicate p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(p.getValue(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
    interface AppleProdicate {
        boolean getValue(Apple a);
    }
}