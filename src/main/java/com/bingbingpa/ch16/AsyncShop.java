package com.bingbingpa.ch16;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static com.bingbingpa.ch16.Util.delay;
import static com.bingbingpa.ch16.Util.format;

public class AsyncShop {

    private final String name;
    private final Random random;

    public AsyncShop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public Future<Double> getPrice(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
//        if (true) {
//            throw new RuntimeException("product not available");
//        }
        return format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }

}
