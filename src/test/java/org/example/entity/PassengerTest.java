package org.example.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.example.entity.passengerType.Subscription;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PassengerTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Passenger#Passenger(String, int, double, Subscription)}
     *   <li>{@link Passenger#getBalance()}
     *   <li>{@link Passenger#getName()}
     *   <li>{@link Passenger#getPassengerNumber()}
     *   <li>{@link Passenger#getType()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Passenger actualPassenger = new Passenger("Name", 10, 10.0d, Subscription.GOLD);

        assertEquals(10.0d, actualPassenger.getBalance());
        assertEquals("Name", actualPassenger.getName());
        assertEquals(10, actualPassenger.getPassengerNumber());
        assertEquals(Subscription.GOLD, actualPassenger.getType());
    }

    /**
     * Method under test: {@link Passenger#Passenger(String, int, double, Subscription)}
     */
    @Test
    void testConstructor2() {
        Passenger actualPassenger = new Passenger("Name", 10, 10.0d, Subscription.GOLD);

        assertTrue(actualPassenger.getActivities().isEmpty());
        assertEquals(Subscription.GOLD, actualPassenger.getType());
        assertEquals(10, actualPassenger.getPassengerNumber());
        assertEquals("Name", actualPassenger.getName());
        assertEquals(10.0d, actualPassenger.getBalance());
    }

    /**
     * Method under test: {@link Passenger#Passenger(String, int, double, Subscription)}
     */
    @Test
    void testConstructor3() {
        Passenger actualPassenger = new Passenger("Name", 10, 10.0d, Subscription.STANDARD);

        assertTrue(actualPassenger.getActivities().isEmpty());
        assertEquals(Subscription.STANDARD, actualPassenger.getType());
        assertEquals(10, actualPassenger.getPassengerNumber());
        assertEquals("Name", actualPassenger.getName());
        assertEquals(10.0d, actualPassenger.getBalance());
    }

    /**
     * Method under test: {@link Passenger#Passenger(String, int, double, Subscription)}
     */
    @Test
    void testConstructor4() {
        Passenger actualPassenger = new Passenger("Name", 10, 10.0d, Subscription.PREMIUM);

        assertTrue(actualPassenger.getActivities().isEmpty());
        assertEquals(Subscription.PREMIUM, actualPassenger.getType());
        assertEquals(10, actualPassenger.getPassengerNumber());
        assertEquals("Name", actualPassenger.getName());
        assertEquals(0.0d, actualPassenger.getBalance());
    }

    /**
     * Method under test: {@link Passenger#signUpForActivity(Activity)}
     */
    @Test
    void testSignUpForActivity() {
        Passenger passenger = new Passenger("Name", 10, 10.0d, Subscription.GOLD);
        Activity activity = new Activity("Name", "The characteristics of someone or something", 10.0d, 3,
                new Destination("Name"));

        passenger.signUpForActivity(activity);
        Destination destination = activity.getDestination();
        List<Activity> activities = destination.getActivities();
        assertEquals(1, activities.size());
        Activity getResult = activities.get(0);
        assertEquals(2, getResult.getCapacity());
        assertEquals("Name", getResult.getName());
        assertSame(destination, getResult.getDestination());
        assertEquals("The characteristics of someone or something", getResult.getDescription());
        assertEquals(10.0d, getResult.getCost());
        assertEquals(1, passenger.getActivities().size());
        assertEquals(1.0d, passenger.getBalance());
    }

    /**
     * Method under test: {@link Passenger#signUpForActivity(Activity)}
     */
    @Test
    void testSignUpForActivity2() {
        Passenger passenger = new Passenger("Name", 10, 10.0d, Subscription.STANDARD);
        Activity activity = new Activity("Name", "The characteristics of someone or something", 10.0d, 3,
                new Destination("Name"));

        passenger.signUpForActivity(activity);
        Destination destination = activity.getDestination();
        List<Activity> activities = destination.getActivities();
        assertEquals(1, activities.size());
        Activity getResult = activities.get(0);
        assertEquals(2, getResult.getCapacity());
        assertEquals("Name", getResult.getName());
        assertSame(destination, getResult.getDestination());
        assertEquals("The characteristics of someone or something", getResult.getDescription());
        assertEquals(10.0d, getResult.getCost());
        assertEquals(1, passenger.getActivities().size());
        assertEquals(0.0d, passenger.getBalance());
    }

    /**
     * Method under test: {@link Passenger#signUpForActivity(Activity)}
     */
    @Test
    void testSignUpForActivity3() {
        Passenger passenger = new Passenger("Name", 10, 10.0d, Subscription.PREMIUM);
        Activity activity = new Activity("Name", "The characteristics of someone or something", 10.0d, 3,
                new Destination("Name"));

        passenger.signUpForActivity(activity);
        Destination destination = activity.getDestination();
        List<Activity> activities = destination.getActivities();
        assertEquals(1, activities.size());
        Activity getResult = activities.get(0);
        assertEquals(2, getResult.getCapacity());
        assertEquals("Name", getResult.getName());
        assertSame(destination, getResult.getDestination());
        assertEquals("The characteristics of someone or something", getResult.getDescription());
        assertEquals(10.0d, getResult.getCost());
        assertEquals(1, passenger.getActivities().size());
    }

    /**
     * Method under test: {@link Passenger#signUpForActivity(Activity)}
     */
    @Test
    void testSignUpForActivity4() {
        Passenger passenger = new Passenger("Name", 10, 10.0d, Subscription.GOLD);
        Destination destination = new Destination("Name");
        Activity activity = new Activity("Name", "The characteristics of someone or something", 10.0d, 0, destination);

        passenger.signUpForActivity(activity);
        assertEquals(0, activity.getCapacity());
        assertEquals("Name", activity.getName());
        Destination destination1 = activity.getDestination();
        assertSame(destination, destination1);
        assertEquals("The characteristics of someone or something", activity.getDescription());
        assertEquals(10.0d, activity.getCost());
        List<Activity> expectedActivities = destination1.getActivities();
        assertEquals(expectedActivities, passenger.getActivities());
        assertEquals(Subscription.GOLD, passenger.getType());
        assertEquals(10, passenger.getPassengerNumber());
        assertEquals("Name", passenger.getName());
        assertEquals(10.0d, passenger.getBalance());
    }
}