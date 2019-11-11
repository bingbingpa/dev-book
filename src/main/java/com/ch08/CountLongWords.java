package com.ch08;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CountLongWords {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("src/main/resources/alice.txt")), StandardCharsets.UTF_8);
        // 단어로 분리한다(비문자(글자가 아닌 문자)를 구분자로 사용한다.)
        List<String> words = List.of(contents.split("\\PL+"));

        long count = 0;
        for(String w: words) {
            if(w.length() > 12){
                count++;
            }
        }
        System.out.println(count);

        count = words.stream().filter(w-> w.length() >12).count();
        System.out.println(count);

        //stream만 parallelStream으로 바꾸어 주면 스트림 라이브러리에서 필터링과 카운팅을 병렬로 수행한다. 
        count = words.parallelStream().filter(w->w.length() > 12).count();
        System.out.println(count);

    }
}