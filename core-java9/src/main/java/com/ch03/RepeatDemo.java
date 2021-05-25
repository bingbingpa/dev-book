package com.ch03;

import java.util.function.IntConsumer;

public class RepeatDemo {

    public static void repeat(int n, Runnable action) {
        for (int i = 0; i < n; i++)
            action.run();
    }

    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++)
            action.accept(i);
    }

    public static void repeatMessage(String text, int count) {
        Runnable r = () -> {
           for (int i = 0; i < count; i++) {
              System.out.println(text);
           }
        };
        new Thread(r).start();                  
     }
    
    public static void main(String[] args) {
        repeat(10, () -> System.out.println("Hello, World!"));
        repeat(10, i -> System.out.println("Countdown: " + (9 - i)));
        repeatMessage("Hello", 10);


        /**
         * 커스텀한 함수형 인터페이스를 구현할때는 인터페이스에 @FunctionalInterface 를 붙여준다.
         */
    }
}