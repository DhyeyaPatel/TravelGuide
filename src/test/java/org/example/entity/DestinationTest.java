package org.example.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DestinationTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Destination#Destination(String)}
     *   <li>{@link Destination#getName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertEquals("Name", (new Destination("Name")).getName());
    }

    /**
     * Method under test: {@link Destination#addActivity(Activity)}
     */
    @Test
    void testAddActivity() {
        Destination destination = new Destination("Name");
        destination.addActivity(
                new Activity("Name", "The characteristics of someone or something", 10.0d, 3, new Destination("Name")));
        assertEquals(1, destination.getActivities().size());
    }
}