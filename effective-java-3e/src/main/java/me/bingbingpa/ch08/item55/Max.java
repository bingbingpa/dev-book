package me.bingbingpa.ch08.item55;

import java.util.*;

public class Max {
    public static <E extends Comparable<E>>
    Optional<E> max(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList(args);

        System.out.println(max(words));

        String lastWordInLexicon = max(words).orElse("단어 없음...");
        System.out.println(lastWordInLexicon);
    }
}
