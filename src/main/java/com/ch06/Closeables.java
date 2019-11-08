package com.ch06;

import java.util.ArrayList;

public class Closeables {
    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) throws Exception {
        for(T el : elems) el.close();
    }
}