package com.ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class LambdaDemo {
    public static void main(String[] args) {
        String[] friends = {"peter", "paul", "mary"};
        Arrays.sort(friends,
                (frist, second) -> frist.length() - second.length());
        System.out.println(Arrays.toString(friends));
        ArrayList<String> enemies = new ArrayList<>(Arrays.asList("Malfoy", "Crabbe", "goyle", null));
        // enemies.removeIf(e-enemies>e==null);
        enemies.removeIf(Objects::isNull);
        System.out.println(enemies);
    }
}