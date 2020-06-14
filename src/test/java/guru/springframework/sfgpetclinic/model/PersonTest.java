package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("model")
class PersonTest {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1l, "Guilherme", "Lodi");

        // then
        assertAll("Test props set",
                () -> assertEquals(person.getFirstName(), "Guilherme"),
                () -> assertEquals(person.getLastName(), "Lodi"));
    }

    @Test
    void groupedAssertionMsgs() {
        // given
        Person person = new Person(1l, "Guilherme", "Lodi");

        // then
        assertAll("Test props set",
                () -> assertEquals(person.getFirstName(), "Guilherme", "First name failed"),
                () -> assertEquals(person.getLastName(), "Lodi", "Last name failed"));
    }

}