package me.bingbingpa.ch02.item9.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        }
    }
}