package me.bingbingpa.ch11.item79;

import java.util.HashSet;

public class Test2 {
    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

        set.addObserver(new SetObserver<>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23){
                    s.removeObserver(this);
                }
            }
        });

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}
