package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1L, "Guilherme", "Lodi");

        // then
        assertAll("Test props set",
                () -> assertEquals(person.getFirstName(), "Guilherme"),
                () -> assertEquals(person.getLastName(), "Lodi"));
    }

    @Test
    void groupedAssertionMsgs() {
        // given
        Person person = new Person(1L, "Guilherme", "Lodi");

        // then
        assertAll("Test props set",
                () -> assertEquals(person.getFirstName(), "Guilherme", "First name failed"),
                () -> assertEquals(person.getLastName(), "Lodi", "Last name failed"));
    }
}