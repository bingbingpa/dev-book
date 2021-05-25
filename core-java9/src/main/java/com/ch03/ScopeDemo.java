package com.ch03;

public class ScopeDemo {
    public static void main(String[] args) {
        repeatMessage("Hello", 10);
        
        /**
         * 람다 표현식에서는 값이 변하지 않는 변수만 참조할 수 있다. 
         * 향상된 for 루프의 변수는 유효 범위가 단일 반복이므로 사실상 최종으로 변하지 않기 때문에 람다 표현식에서 참조 할 수 있다.
         */
        for (String a : args) 
            new Thread(() -> System.out.println(a));
    }

    public static void repeatMessage(String text, int count) {
        Runnable r = () -> {
           for (int i = 0; i < count; i++) {
              System.out.println(text);
           }
        };
        new Thread(r).start();                  
     }
}