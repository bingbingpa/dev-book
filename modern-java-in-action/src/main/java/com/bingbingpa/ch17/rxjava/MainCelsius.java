package com.bingbingpa.ch17.rxjava;

import com.bingbingpa.ch17.TempInfo;
import io.reactivex.rxjava3.core.Observable;

import static com.bingbingpa.ch17.rxjava.TempObservable.getCelsiusTemperatures;

public class MainCelsius {

    public static void main(String[] args) {
        Observable<TempInfo> observable = getCelsiusTemperatures("New York", "Chicago", "San Francisco");
        observable.subscribe(new TempObserver());

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
