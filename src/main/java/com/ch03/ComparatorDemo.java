package com.ch03;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        Person[] people = {
            new Person("George", "Washington"),
            new Person("Thomas", "Jefferson"),
            new Person("Johin", "Adams")
        };

        Arrays.sort(people, Comparator.comparing(Person::getName));
        System.out.println(Arrays.toString(people));
    }
}