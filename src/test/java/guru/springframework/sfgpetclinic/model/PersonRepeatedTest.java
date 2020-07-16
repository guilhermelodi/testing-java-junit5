package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelRepeatedTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class PersonRepeatedTest implements ModelRepeatedTests {

    @DisplayName("My Repeated Test")
    @RepeatedTest(value = 10, name = "{currentRepetition} of {totalRepetitions}")
    void myRepeatedTest() {
        //todo
    }

    @RepeatedTest(value = 5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }

    @DisplayName("My Assignment Repeated Test")
    @RepeatedTest(value = 5, name = "{currentRepetition} of {totalRepetitions}")
    void myAssignmentRepeated() {
        // todo
    }
}
