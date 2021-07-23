package me.bingbingpa.ch06.item40;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class Bigram2Test {

    @DisplayName("@Override 를 쓰면 컴파일 오류가 발생하고 잘못 정의하는것을 방지 할 수 있다.")
    @Test
    void override_annotation() {
        Set<Bigram2> s = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                s.add(new Bigram2(ch, ch));
            }
        }
        assertThat(s.size()).isEqualTo(26);
    }

}