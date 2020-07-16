package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1l, "Guilherme", "Lodi");
        owner.setCity("Rio Preto");
        owner.setTelephone("17998765432");

        assertAll("Properties test",
                () -> assertAll("Person properties",
                        () -> assertEquals(owner.getFirstName(), "Guilherme", "First name failed"),
                        () -> assertEquals(owner.getLastName(), "Lodi", "Last name failed")),
                () -> assertAll("Owner properties",
                        () -> assertEquals(owner.getCity(), "Rio Preto", "City failed"),
                        () -> assertEquals(owner.getTelephone(), "17998765432", "Telephone failed"))
        );
    }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String value) {
        System.out.println(value);
    }

}