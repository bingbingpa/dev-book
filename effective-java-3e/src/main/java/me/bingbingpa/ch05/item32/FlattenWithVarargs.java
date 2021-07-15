package me.bingbingpa.ch05.item32;

import java.util.ArrayList;
import java.util.List;

public class FlattenWithVarargs {

    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = flatten(List.of(1, 2), List.of(3, 4, 5), List.of(6, 7));
        System.out.println(list);
    }
}
