package com.bingbingpa.ch05;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreams {

    public static void main(String... args) throws Exception {

        Stream<String> stream = Stream.of("Java8", "Lamdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        int[] numbers = {2,3,5,9,11,113};
        System.out.println(Arrays.stream(numbers).sum());

        Stream.iterate(0, n -> n+2)
            .limit(10)
            .forEach(System.out::println);
        
        // itereate를 이용한 피보나치
        Stream.iterate(new int[] {0,1}, t -> new int[] { t[1], t[0]+t[1]})
            .limit(10)
            .forEach(t -> System.out.printf("(%d, %d)", t[0], t[1]));
        
        Stream.iterate(new int[] {0,1}, t -> new int[] {t[1], t[0] + t[1]})
            .limit(10)
            .map(t -> t[0]) // 맵으로 각 집합의 첫번째 요소만 추출
            .forEach(System.out::println);
        
        // Stream.generate를 이용한 임의의 dobule 스트림
        Stream.generate(Math::random)
            .limit(10)
            .forEach(System.out::println);

        // Stream.generate를 이용한 요소 1을 갖는 스트림
        IntStream.generate(() -> 1)
            .limit(5)
            .forEach(System.out::println);

        IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        }).limit(5).forEach(System.out::println);

        IntSupplier fib = new IntSupplier(){
            
            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int nextValue = previous + current;
                previous = current;
                current = nextValue;
                return previous;
            }
        };
        IntStream.generate(fib)
            .limit(10)
            .forEach(System.out::println);

        long uniqueWords = Files.lines(Paths.get("src/main/java/com/bingbingpa/ch05/data.txt"), Charset.defaultCharset())
            .flatMap(line -> Arrays.stream(line.split("")))
            .distinct()
            .count();
        
        System.out.println("There are " + uniqueWords + " unique words in data.txt");
    }
}