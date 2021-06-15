package me.bingbingpa.ch03.item11;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneNumberTest {

    @Test
    void hashMapTest() {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(707, 867, 5309), "제니");
        String s = m.get(new PhoneNumber(707, 867, 5309));
        assertThat(s).isEqualTo("제니");
    }

}