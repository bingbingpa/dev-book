package me.bingbingpa.ch05.item32;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class PickTwoTest {

    @Test
    void 자신의_제네릭_매개변수_배열의_참조를_노출하는_경우_테스트() {
        assertThatExceptionOfType(ClassCastException.class)
                .isThrownBy(() -> {
                    String[] attributes = PickTwo.pickTwo("좋은", "빠른", "저렴한");
                });
    }

}