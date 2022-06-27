package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    @DisplayName("Test proper view name is returned for Index")
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong View Returned");
        assertEquals("index", controller.index(), () -> "Another Expensive message, use me only if you have to");
    }

    @Test
    @DisplayName("Old Test exception")
    @Disabled("Because of new implementation")
    void oupsHandler() {
        assertEquals("notimplemented", controller.oupsHandler(),
            "This is some expensive Message to build for my test");
    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler1() {
        assertThrows(ValueNotFoundException.class, () -> controller.oupsHandler(), "Wrong or no exception thrown");
    }

    @Test
    void testAssumptionTrue() {

        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNMTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {

        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }
}
