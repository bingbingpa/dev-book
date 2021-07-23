package me.bingbingpa.ch06.item39.annotaionwitharrayparameter;

import java.util.ArrayList;
import java.util.List;

public class Sample3 {
    @ExceptionTest(ArithmeticException.class)
    public static void m1() {
        int i = 0;
        i = i / i;
    }
    @ExceptionTest(ArithmeticException.class)
    public static void m2() {
        int[] a = new int[0];
        int i = a[1];
    }
    @ExceptionTest(ArithmeticException.class)
    public static void m3() { }

    @ExceptionTest({ IndexOutOfBoundsException.class, NullPointerException.class })
    public static void doublyBad() {
        List<String> list = new ArrayList<>();

        list.addAll(5, null);
    }
}
