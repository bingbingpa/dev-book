package me.bingbingpa.ch09.item59;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Curl {
    public static void main(String[] args) throws IOException {
        try (InputStream in = new URL("https://google.com").openStream()) {
            in.transferTo(System.out);
        }
    }
}
