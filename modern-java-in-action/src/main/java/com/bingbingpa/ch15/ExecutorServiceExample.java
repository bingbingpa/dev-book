package com.bingbingpa.ch15;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.bingbingpa.ch15.Functions.fo;
import static com.bingbingpa.ch15.Functions.go;

public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int x = 1337;

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> y = executorService.submit(() -> fo(x));
        Future<Integer> z = executorService.submit(() -> go(x));
        System.out.println(y.get() + z.get());

        executorService.shutdown();
    }
}
