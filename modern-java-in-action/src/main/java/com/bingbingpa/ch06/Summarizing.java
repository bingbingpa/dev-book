package com.bingbingpa.ch06;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.function.BinaryOperator;

import static com.bingbingpa.ch06.Dish.menu;
import static java.util.stream.Collectors.*;

public class Summarizing {

    public static void main(String... args) {
        System.out.println("Nr. of dishes: " + howManyDishes());
        System.out.println("The most caloric dish is: " + findMostCaloricDish());
        System.out.println("The most caloric dish is: " + findMostCaloricDishUsingComparator());
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Average calories in menu: " + calculateAverageCalories());
        System.out.println("Menu statistics: " + calculateMenuStatistics());
        System.out.println("Short menu: " + getShortMenu());
        System.out.println("Short menu comma separated: " + getShortMenuCommaSeparated());
    }

    private static long howManyDishes() {
        return menu.size();
    }

    private static Dish findMostCaloricDish() {
        return menu.stream().reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2).get();
    }

    private static Dish findMostCaloricDishUsingComparator() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        BinaryOperator<Dish> moreCaloricOf = BinaryOperator.maxBy(dishCaloriesComparator);
        return menu.stream().reduce(moreCaloricOf).get();
    }

    private static int calculateTotalCalories() {
        return menu.stream().mapToInt(Dish::getCalories).sum();
    }

    private static Double calculateAverageCalories() {
        return menu.stream().collect(averagingInt(Dish::getCalories));
    }

    private static IntSummaryStatistics calculateMenuStatistics() {
        return menu.stream().collect(summarizingInt(Dish::getCalories));
    }

    private static String getShortMenu() {
        return menu.stream().map(Dish::getName).collect(joining());
    }

    private static String getShortMenuCommaSeparated() {
        return menu.stream().map(Dish::getName).collect(joining(","));
    }
}
