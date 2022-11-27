package ch3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class EmailAddressTests {

    @Test
    public void parsing() {
        assertThat(new EmailAddress("fred", "example.com"))
                .isEqualTo(EmailAddress.parse("fred@example.com"));
    }

    @Test
    public void parsingFailures() {
        assertThatThrownBy(
                () -> EmailAddress.parse("@")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
