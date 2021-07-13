package me.bingbingpa.ch05.item28;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayChooser<T> {
    
    private final T[] choiceArray;

    public ArrayChooser(Collection<T> choices) {
        choiceArray = (T[]) choices.toArray();
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }

    public static void main(String[] args) {
        ArrayChooser<String> arrayChooser = new ArrayChooser<>(List.of("1", "2", "3"));
        String choose = (String)arrayChooser.choose();
        System.out.println("choose = " + choose);

    }
}
