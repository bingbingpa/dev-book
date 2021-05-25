package com.ch06;

import java.util.ArrayList;

/**
 * T extends Runnable & AutoCloseable처럼 다중 경계를 지정할 수도 있다. 
 */
public class Closeables {
    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) throws Exception {
        for(T el : elems) el.close();
    }
}