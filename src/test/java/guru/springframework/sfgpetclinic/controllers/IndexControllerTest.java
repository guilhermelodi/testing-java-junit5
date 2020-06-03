package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.exception.ValueNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

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
        assertThrows(ValueNotFoundException.class, () -> indexController.oopsHandler());
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

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testMeOnWindowns() {
        System.out.println("M=testMeOnWindowns, I=executed");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testMeOnLinux() {
        System.out.println("M=testMeOnLinux, I=executed");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testMeOnJava8() {
        System.out.println("M=testMeOnJava8, I=executed");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "abc")
    void testIfUserAbc() {
        System.out.println("M=testMeOnUserABC, I=executed");
    }
}