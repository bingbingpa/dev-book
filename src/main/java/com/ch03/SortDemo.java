package com.ch03;

import java.util.Arrays;
import java.util.Comparator;

public class SortDemo {
    public static void main(String[] args) {
        String[] friends = { "Peter", "Paul", "Mary" };
        Arrays.sort(friends); // friends가 ["Mary", "Paul", "Peter"]로 정렬된다.
        System.out.println(Arrays.toString(friends));
        
        friends = new String[] { "Peter", "Paul", "Mary" };
        //Arrays.sort 메서드는 Comparable 객체로 구성된 배열을 정렬한다.
        Arrays.sort(friends, new LengthComparator());
        System.out.println(Arrays.toString(friends));
    }
}

class LengthComparator implements Comparator<String> {
    public int compare(String first, String second) {
        return first.length() - second.length();
    }
}