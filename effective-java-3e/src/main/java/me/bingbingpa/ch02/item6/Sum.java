package me.bingbingpa.ch02.item6;

public class Sum {
    private static long sum() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            long start = System.nanoTime();
            sum();
            long end = System.nanoTime();
            System.out.println((end - start) / 1_000_000. + " ms.");
        }
    }
}
