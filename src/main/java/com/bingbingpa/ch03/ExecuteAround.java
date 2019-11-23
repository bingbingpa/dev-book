package com.bingbingpa.ch03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {
    
    private static final String FILE = ExecuteAround.class.getResource("lambda.txt").getFile();

    public static void main(String... args) throws IOException {

        String result = processFileLimited();
        System.out.println(result);

        System.out.println("===========================");

        String oneLine = proecessFile((BufferedReader b) -> b.readLine());
        System.out.println(oneLine);

        String twoLines = proecessFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println(twoLines);

    }

    //그 동안 써왔던 형태의 메서드
    public static String processFileLimited() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            return br.readLine();
        }
    }

    public static String proecessFile(BufferedReaderProcessor p ) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            return p.process(br);
        }
    }

    public interface BufferedReaderProcessor { 
        String process(BufferedReader b ) throws IOException;
    }
}