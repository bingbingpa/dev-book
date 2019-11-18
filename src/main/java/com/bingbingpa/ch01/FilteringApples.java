package com.bingbingpa.ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
            new Apple(80, "green"),
            new Apple(155, "green"),
            new Apple(120, "red")
        );

        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);

        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);

        // 한 번만 사용하거나 간단한 메서드는 따로 정의를 구현할 필요없이 간결하게 익명 람다를 사용하자.
        // 하지만 람다가 몇 줄 이상으로 길어진다면 익명 람다보다는 코드가 수행하는 일을 잘 설명하는 이름을 가진 
        // 메서드를 정의하고 메서드 참조를 활용하는 것이 바람직하다. 코드의 명확성이 우선시되어야 한다.   
        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);

        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);

        List<Apple> weirdApples = filterApples(inventory, (Apple a ) -> a.getWeight() <= 80 || "red".equals(a.getColor()));
        System.out.println(weirdApples);
    }

    //지금까지 일반적으로 내가 사용하던 형태의 메소드
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
    
    /**
     * 수학에서는 인수로 값을 받아 true 나 false를 반환하는 함수를 프레디케이트라고 한다. 
     * @param inventory
     * @param p
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple :inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}