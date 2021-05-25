package com.bingbingpa.ch09.movie.factory;

import com.bingbingpa.ch09.money.Money;
import com.bingbingpa.ch09.movie.Movie;

public class Client {
    private Factory factory;

    public Client(Factory factory) {
        this.factory = factory;
    }

    public Money getAvatarFee() {
        Movie avatar = factory.createAvatarMovie();
        return avatar.getFee();
    }
}
