package com.bingbingpa.ch05;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Transaction {

    private Trader trader;
    private int year;
    private int value;
}