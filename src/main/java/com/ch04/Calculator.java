package com.ch04;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("First operand: ");
        int a = in.nextInt();
        System.out.print("Operator: ");
        String opSymbol = in.next();
        System.out.print("Second operand: ");
        int b= in.nextInt();
        for(Operation op : Operation.values()) {
            if(op.getSymbol().equals(opSymbol)) {
                int result = op.eval(a, b);
                System.out.println(result);
            }
        }
    }
}