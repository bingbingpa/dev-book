package me.bingbingpa.ch03.item12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneNumberTest {

    @Test
    void toStringTest() {
        PhoneNumber jenny = new PhoneNumber(707, 867, 5309);
        System.out.println("제니의 번호: " + jenny);
        assertThat(jenny.toString()).isEqualTo("707-867-5309");
    }
}
