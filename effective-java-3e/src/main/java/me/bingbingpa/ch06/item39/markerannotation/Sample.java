package me.bingbingpa.ch06.item39.markerannotation;

public class Sample {
    @Test
    public static void m1() {
    }

    public static void m2() {
    }

    @Test
    public static void m3() {
        throw new RuntimeException("실패");
    }

    public static void m4() {
    }

    public static void m6() {
    }

    @Test
    public static void m7() {
        throw new RuntimeException("실패");
    }

    public static void m8() {
    }

    @Test
    public void m5() {
    }
}
