package me.bingbingpa.ch05.item32;

import java.util.List;

public class Dangerous {

    static void dangerous(List<String>... stringLists) {
        List<Integer> list = List.of(42);
        Object[] objects = stringLists;
        objects[0] = list;
        String s = stringLists[0].get(0);
    }
}
