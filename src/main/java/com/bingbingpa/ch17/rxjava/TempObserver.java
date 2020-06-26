package com.bingbingpa.ch17.rxjava;

import com.bingbingpa.ch17.TempInfo;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class TempObserver implements Observer<TempInfo> {

    @Override
    public void onComplete() {
        System.out.println("Done!");
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Got problem: " + throwable.getMessage());
    }

    @Override
    public void onSubscribe(Disposable disposable) {}

    @Override
    public void onNext(TempInfo tempInfo) {
        System.out.println(tempInfo);
    }

}
