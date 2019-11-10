package com.ch07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("PSH");
        coll.add("Opensesame");
        coll.add("binbingpa");
        Iterator<String> iter = coll.iterator();
        while(iter.hasNext()) {
            String element= iter.next();
            System.out.println("iter =================== "+ element);
        }

        iter = coll.iterator();
        while(iter.hasNext()) {
            String element = iter.next();
            if(element.startsWith("O")) {
                iter.remove();
            }
        }
        coll.removeIf(e -> e.endsWith("a"));

        for(String element : coll) {
            System.out.println("element ======================== " + element);
        }
    }
}