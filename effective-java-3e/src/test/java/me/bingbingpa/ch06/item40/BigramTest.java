package me.bingbingpa.ch06.item40;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BigramTest {

    @DisplayName("hashCode(), equals() 메소드에 @Override 를 쓰지 않은 경우 테스트")
    @Test
    void not_override_annotation() {
        Set<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                s.add(new Bigram(ch, ch));
            }
        }
        assertThat(s.size()).isEqualTo(260);
    }
}