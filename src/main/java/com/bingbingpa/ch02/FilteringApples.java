package com.bingbingpa.ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {

    public static void main(String... args) {
        /**
         * 기억 할 것들!
         * 파라미터로 메서드 참조를 넘길 수 있다 . Apple::test 같은 형태로(Apple 클래스의 test 함수를 파라미터로 사용)
         * 인터페이스를 구현한 클래스를 파라미터로 사용. ApplePredicate 인터페이스를 구현한 클래스를 new 형태로 해서 넘긴다. 
         * 익명 클래스를 구현하는 객체를 만들어 사용. 
         * 람다를 사용. 
         */
        List<Apple> inventory = Arrays.asList(
            new Apple(80, Color.GREEN),
            new Apple(155, Color.GREEN),
            new Apple(120, Color.RED)
        );

        //ApplePredicate를 구현한 클래스를 동작 파라미터로 사용 
        List<Apple> greenApples = filter(inventory, new AppleColorPredicate());
        System.out.println(greenApples);

        List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
        System.out.println(heavyApples);

        List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
        System.out.println(redAndHeavyApples);

        // 익명 클래스를 이용해서 ApplePredicate를 구현하는 객체를 만드는 방법으로 필터링 
        List<Apple> redApples2 = filter(inventory, new ApplePredicate(){
            @Override
            public boolean getAppleValue(Apple a) {
                return a.getColor() == Color.RED;
            }
        });
        System.out.println(redApples2);

        List<Apple> redApples3 = filter(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
        System.out.println(redApples3);
        
    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(p.getAppleValue(apple)) {
                result.add(apple);
            }
        }
        return result;  
      }
}