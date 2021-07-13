package me.bingbingpa.ch05.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ListChooser<T> {
    private final List<T> choiceList;

    public ListChooser(Collection<T> choices) {
        this.choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        ListChooser<String> listChooser = new ListChooser<>(List.of("1", "2", "3"));
        String choose = listChooser.choose();
        System.out.println("choose = " + choose);
    }
}
