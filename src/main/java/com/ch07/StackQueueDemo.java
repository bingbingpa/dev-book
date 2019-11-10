package com.ch07;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackQueueDemo {
    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("Peter");
        stack.push("Paul");
        stack.push("Mary");
        while (!stack.isEmpty())
            System.out.println(stack.pop());
        
        System.out.println();
        
        Queue<String> queue = new ArrayDeque<>();
        queue.add("Peter");
        queue.add("Paul");
        queue.add("Mary");
        while (!queue.isEmpty())
            System.out.println(queue.remove());
        
    }
}