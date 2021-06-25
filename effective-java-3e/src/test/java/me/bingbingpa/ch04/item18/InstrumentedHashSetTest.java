package me.bingbingpa.ch04.item18;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class InstrumentedHashSetTest {

    @Test
    void HashSet_을_상속한_클래스의_오동작_테스트() {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("틱", "탁탁", "펑"));

        assertThat(s.getAddCount()).isNotEqualTo(3);
    }

    @Test
    void 컴포지션을_사용한_전달_클래스_테스트() {
        Set<String> set = new HashSet<>();
        InstrumentedSet<String> s = new InstrumentedSet<>(set);
        s.addAll(List.of("틱", "탁탁", "펑"));

        assertThat(s.getAddCount()).isEqualTo(3);
    }

}