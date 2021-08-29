package me.bingbingpa.ch11.item81;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Intern {
    private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

    public static String intern(String s) {
        String result = map.get(s);
        if (result == null) {
            result = map.putIfAbsent(s, s);
            if (result == null) {
                result = s;
            }
        }
        return result;
    }
}
