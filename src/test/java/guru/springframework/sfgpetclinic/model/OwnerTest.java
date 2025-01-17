package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OwnerTest {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");

        assertAll("Properties Test",
            () -> assertAll("Person Properties",
                () -> assertEquals("Joe", owner.getFirstName(), "First name did not match"),
                () -> assertEquals("Buck", owner.getLastName(), "Last name did not match")),
            () -> assertAll("Owner properties",
                () -> assertEquals("Key West", owner.getCity(), "City did not match"),
                () -> assertEquals("1231231234", owner.getTelephone(), "Telephone did not match"))
            );

    }
}
