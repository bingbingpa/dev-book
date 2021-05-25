package com.ch08;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterMapDemo {
    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> firstElements = stream.limit(SIZE + 1 ).collect(Collectors.toList());
        System.out.print(title + ": ");
        if(firstElements.size() <=SIZE) {
            System.out.println(firstElements);
        } else {
            firstElements.remove(SIZE);
            String out = firstElements.toString();
            System.out.println(out.substring(0, out.length()-1) + ",.....]");
        }
    }

    public static Stream<String> codePoints(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i< s.length()) {
            // offsetByCodePoints : argument로 지정한 index위치부터 codePointOffset만큼 code point단위로 이동한 위치의 index를 리턴한다.
            int j = s.offsetByCodePoints(i, 1);
            result.add(s.substring(i,j));
            i = j;
        }
        return result.stream();
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/alice.txt"); 
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        List<String> words = List.of(contents.split("\\PL+"));
        Stream<String> longWords = words.stream().filter(w->w.length()> 12);
        show("longWords", longWords);

        Stream<String> lowercaseWords = words.stream()
                                .filter(w->w.length()> 12)
                                .map(String::toLowerCase);
        // System.out.println("stream to list -------- "+ lowercaseWords.collect(Collectors.toList()));
        show("lowercaseWords", lowercaseWords);

        String[] song = { "row", "row", "row", "your", "boat", "gently", "down", "the", "stream" };
        Stream<String> firstChars = Stream.of(song).filter(w->w.length() > 0)
                                                    .map(s->s.substring(0,1));
        show("firstChars", firstChars);

        // 스트림으로 구성된 스트림을 펼칠 때 flatMap 사용
        Stream<String> letters = Stream.of(song).flatMap(w -> codePoints(w));
        show("letters", letters);
    }

}