package me.bingbingpa.ch05.item32;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class DangerousTest {

    @Test
    void 제네릭과_varargs_를_혼용하면_타입_안전성이_깨진다() {
        assertThatExceptionOfType(ClassCastException.class)
                .isThrownBy(() -> Dangerous.dangerous(List.of("There be dangerous")));
    }

}