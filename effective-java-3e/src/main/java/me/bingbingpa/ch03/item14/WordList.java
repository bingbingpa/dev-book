package me.bingbingpa.ch03.item14;

import java.util.*;

public class WordList {
    public static void main(String[] args) {
//        HashSet<String> s = new HashSet<>();
//        Collections.addAll(s, "A", "B", "C", "D");
//        System.out.println(s);
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Milk");
        hashSet.add("Bread");
        hashSet.add("Butter");
        hashSet.add("Cheese");
        hashSet.add("Ham");
        hashSet.add("Ham");

        System.out.println(hashSet);
    }
}
