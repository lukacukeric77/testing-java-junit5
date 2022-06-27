package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1L, "Joe", "Buck");
        // then
        assertAll("Test Props Set",
            () -> assertEquals("Joe", person.getFirstName()),
            () -> assertEquals("Buck", person.getLastName())
            );
    }

    @Test
    void groupedAssertionsMsgs() {
        // given
        Person person = new Person(1L, "Joe", "Buck");
        // then
        assertAll("Test Props Set",
            () -> assertEquals("Joe", person.getFirstName(), "First name failed"),
            () -> assertEquals("Buck", person.getLastName(), "Last name failed")
        );
    }

}
