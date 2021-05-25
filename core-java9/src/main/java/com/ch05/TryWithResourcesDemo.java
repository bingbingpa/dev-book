package com.ch05;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TryWithResourcesDemo {
    public static void print(Scanner input, PrintWriter output) {
        // 리소스는 초기화의 역순으로 닫는다. 즉. out.close() 가 in.close()보다 먼저 호출된다. 
        try (Scanner in = input; PrintWriter out = output) { 
            while (in.hasNext())
                out.println(in.next().toLowerCase());            
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        List<String> lines = Arrays.asList("Mary had a little lamb. Its fleece was white as snow.".split(" "));
        try (PrintWriter out = new PrintWriter("/tmp/output1.txt")) {
            for (String line : lines) {
                out.println(line.toLowerCase());
            }
        }
        try (Scanner in = new Scanner(Paths.get("/usr/share/dict/words"));
                PrintWriter out = new PrintWriter("/tmp/output2.txt")) {
            while (in.hasNext())
                out.println(in.next().toLowerCase());
        }
        
        try (PrintWriter out3 = new PrintWriter("/tmp/output3.txt")) {
            for (String line : lines) {
                out3.println(line.toLowerCase());
            }
        }                
    }
}