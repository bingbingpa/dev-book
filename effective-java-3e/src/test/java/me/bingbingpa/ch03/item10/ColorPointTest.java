package me.bingbingpa.ch03.item10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ColorPointTest {

    @Test
    void 대칭성_위배_테스트() {
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);

        assertThat(cp).isNotEqualTo(p);
    }
}