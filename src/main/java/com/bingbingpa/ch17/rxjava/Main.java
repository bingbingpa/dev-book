package com.bingbingpa.ch17.rxjava;

import com.bingbingpa.ch17.TempInfo;
import io.reactivex.rxjava3.core.Observable;

import static com.bingbingpa.ch17.rxjava.TempObservable.getTemperature;

public class Main {

    public static void main(String[] args) {
        Observable<TempInfo> observable = getTemperature("New York");
        observable.subscribe(new TempObserver());

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
