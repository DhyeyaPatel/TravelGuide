package org.example.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class ActivityTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Activity#Activity(String, String, double, int, Destination)}
     *   <li>{@link Activity#getCapacity()}
     *   <li>{@link Activity#getCost()}
     *   <li>{@link Activity#getDescription()}
     *   <li>{@link Activity#getDestination()}
     *   <li>{@link Activity#getName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Destination destination = new Destination("Name");
        Activity actualActivity = new Activity("Name", "The characteristics of someone or something", 10.0d, 3,
                destination);

        assertEquals(3, actualActivity.getCapacity());
        assertEquals(10.0d, actualActivity.getCost());
        assertEquals("The characteristics of someone or something", actualActivity.getDescription());
        assertSame(destination, actualActivity.getDestination());
        assertEquals("Name", actualActivity.getName());
    }

    /**
     * Method under test: {@link Activity#Activity(String, String, double, int, Destination)}
     */
    @Test
    void testConstructor2() {
        Destination destination = new Destination("Name");
        Activity actualActivity = new Activity("Name", "The characteristics of someone or something", 10.0d, 3,
                destination);

        assertEquals(3, actualActivity.getCapacity());
        assertEquals("Name", actualActivity.getName());
        assertSame(destination, actualActivity.getDestination());
        assertEquals("The characteristics of someone or something", actualActivity.getDescription());
        assertEquals(10.0d, actualActivity.getCost());
    }
}