package me.bingbingpa.ch02.item2.hierarchicalbuilder;

import static me.bingbingpa.ch02.item2.hierarchicalbuilder.NyPizza.Size.*;
import static me.bingbingpa.ch02.item2.hierarchicalbuilder.Pizza.Topping.*;

public class PizzaTest {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE)
                .addTopping(ONION)
                .build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM)
                .sauceInside()
                .build();

        System.out.println("pizza = " + pizza);
        System.out.println("calzone = " + calzone);
    }
}
