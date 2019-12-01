package com.bingbingpa.ch05;

import static com.bingbingpa.ch04.Dish.menu;
import com.bingbingpa.ch04.Dish;
import java.util.Optional;

public class Finding {

    public static void main(String... args) {
        if(isVegetarianFriendLyMenu()) {
            System.out.println("Vegetaraian Friendly");
        }

        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu2());

        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(d -> System.out.println(d.getName()));
    }

    private static boolean isVegetarianFriendLyMenu() {
        return menu.stream().anyMatch(Dish::isVegetarian);
    }

    private static boolean isHealthyMenu() {
        return menu.stream().allMatch(d -> d.getCalories() < 1000); 
    }

    private static boolean isHealthyMenu2() {
        return menu.stream().noneMatch(d -> d.getCalories() >=1000); 
    }

    // findAny는 Optional을 반환한다.
    private static Optional<Dish> findVegetarianDish() {
        return menu.stream().filter(Dish::isVegetarian).findAny();
    }
}