package me.bingbingpa.ch09.item60;

public class IntChange {
    public static void main(String[] args) {
        int itemsBought = 0;
        int funds = 100;
        for (int price = 10; funds >= price; price += 10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + "개 구입");
        System.out.println("잔돈(센트): " + funds);
    }
}
