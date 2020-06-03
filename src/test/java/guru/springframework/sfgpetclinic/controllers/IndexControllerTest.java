package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.exception.ValueNotFoundException;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), "Wrong view returned");
    }

    @Test
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            indexController.oopsHandler();
        });
    }

    @Test
    @Disabled("Disabling timeout test")
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);

            System.out.println("M=testTimeOut");
        });
    }

    @Test
    @Disabled("Disabling timeout preemptively test")
    void testTimeOutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);

            System.out.println("M=testTimeOutPrempt");
        });
    }

    @Test
    void testAssumptionTrueFail() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueSuccess() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }
}