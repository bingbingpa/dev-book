package com.ch04;

import java.util.Objects;

public class DiscountedItem extends Item {
    private double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    public boolean equals(Object otherObject) {
        if(!super.equals(otherObject)) return false;
        DiscountedItem other = (DiscountedItem) otherObject;
        return discount == other.discount;
    }

    /**
     * 가변 인수 메서드 Objects.hash는 인수들의 해시 코드를 계산해 결합하고 널에 안전하다. 
     * 클래스에 배열 인스턴스 변수가 있으면 먼저 정적 메서드 Arrays.hashCode로 해당 배열의 해시코드를 계산한다. 
     */
    public int hasCode() {
        return Objects.hash(super.hasCode(), discount);
    }
}