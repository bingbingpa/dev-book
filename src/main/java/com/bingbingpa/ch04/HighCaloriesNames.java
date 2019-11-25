package com.bingbingpa.ch04;

import static java.util.stream.Collectors.toList;
import static com.bingbingpa.ch04.Dish.menu;

import java.util.List;

public class HighCaloriesNames {

    public static void main(String... args) {
        List<String> names = menu.stream()
            .filter(dish -> {
                System.out.println("filtering " + dish.getName());
                return dish.getCalories() > 300;
            })
            .map(dish -> {
                System.out.println("mapping " + dish.getName());
                return dish.getName();
            })
            .limit(3)
            .collect(toList());
        System.out.println(names);
    }
}