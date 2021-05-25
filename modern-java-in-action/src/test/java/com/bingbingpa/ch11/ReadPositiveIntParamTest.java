package com.bingbingpa.ch11;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Properties;

import static java.util.Optional.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReadPositiveIntParamTest {

    public static int readDurationImperative(Properties properties, String name) {
        String value = properties.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) {
            }
        }

        return 0;
    }

    public static int readDurationWithOptional(Properties properties, String name) {
        return ofNullable(properties.getProperty(name))
                .flatMap(ReadPositiveIntParamTest::s2i)
                .filter(i -> i > 0).orElse(0);
    }

    public static Optional<Integer> s2i(String s) {
        try {
            return of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return empty();
        }
    }

    @Test
    public void testMap() {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        assertEquals(5, readDurationImperative(props, "a"));
        assertEquals(0, readDurationImperative(props, "b"));
        assertEquals(0, readDurationImperative(props, "c"));
        assertEquals(0, readDurationImperative(props, "d"));

        assertEquals(5, readDurationWithOptional(props, "a"));
        assertEquals(0, readDurationWithOptional(props, "b"));
        assertEquals(0, readDurationWithOptional(props, "c"));
        assertEquals(0, readDurationWithOptional(props, "d"));
    }

}