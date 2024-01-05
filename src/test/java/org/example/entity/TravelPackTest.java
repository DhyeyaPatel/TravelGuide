package org.example.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.example.entity.passengerType.Subscription;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class TravelPackTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TravelPack#TravelPack(String, int)}
     *   <li>{@link TravelPack#getName()}
     *   <li>{@link TravelPack#getPassengerCapacity()}
     *   <li>{@link TravelPack#getDestinations()}
     *   <li>{@link TravelPack#getPassengers()}
     * </ul>
     */
    @Test
    void testConstructor() {
        TravelPack actualTravelPack = new TravelPack("Name", 1);

        assertEquals("Name", actualTravelPack.getName());
        assertEquals(1, actualTravelPack.getPassengerCapacity());
        List<Destination> expectedPassengers = actualTravelPack.getDestinations();
        assertEquals(expectedPassengers, actualTravelPack.getPassengers());
    }

    /**
     * Method under test: {@link TravelPack#addDestination(Destination)}
     */
    @Test
    void testAddDestination() {
        TravelPack travelPack = new TravelPack("Name", 1);
        travelPack.addDestination(new Destination("Name"));
        assertEquals(1, travelPack.getDestinations().size());
    }

    /**
     * Method under test: {@link TravelPack#addPassenger(List)}
     */
    @Test
    void testAddPassenger() {
        TravelPack travelPack = new TravelPack("Name", 1);
        ArrayList<Passenger> passengerList = new ArrayList<>();
        travelPack.addPassenger(passengerList);
        assertEquals(passengerList, travelPack.getDestinations());
        assertEquals(passengerList, travelPack.getPassengers());
        assertEquals(1, travelPack.getPassengerCapacity());
        assertEquals("Name", travelPack.getName());
    }

    /**
     * Method under test: {@link TravelPack#addPassenger(List)}
     */
    @Test
    void testAddPassenger2() {
        TravelPack travelPack = new TravelPack("Name", 0);
        ArrayList<Passenger> passengerList = new ArrayList<>();
        travelPack.addPassenger(passengerList);
        assertEquals(passengerList, travelPack.getDestinations());
        assertEquals(passengerList, travelPack.getPassengers());
        assertEquals(0, travelPack.getPassengerCapacity());
        assertEquals("Name", travelPack.getName());
    }

    /**
     * Method under test: {@link TravelPack#addPassenger(List)}
     */
    @Test
    void testAddPassenger3() {
        TravelPack travelPack = new TravelPack("Name", 1);

        ArrayList<Passenger> passengerList = new ArrayList<>();
        passengerList.add(new Passenger("Name", 10, 10.0d, Subscription.GOLD));
        travelPack.addPassenger(passengerList);
        assertEquals(1, travelPack.getPassengers().size());
    }

    /**
     * Method under test: {@link TravelPack#printPassengerDetails(List)}
     */
    @Test
    void testPrintPassengerDetails() {
        TravelPack travelPack = new TravelPack("Name", 1);
        ArrayList<Passenger> passengerList = new ArrayList<>();
        travelPack.printPassengerDetails(passengerList);
        assertEquals(passengerList, travelPack.getDestinations());
        assertEquals(passengerList, travelPack.getPassengers());
        assertEquals(1, travelPack.getPassengerCapacity());
        assertEquals("Name", travelPack.getName());
    }

    /**
     * Method under test: {@link TravelPack#calculatePrice(Passenger, Activity)}
     */
    @Test
    void testCalculatePrice() {
        TravelPack travelPack = new TravelPack("Name", 1);
        Passenger passenger = new Passenger("Name", 10, 10.0d, Subscription.GOLD);

        assertEquals(9.0d, travelPack.calculatePrice(passenger,
                new Activity("Name", "The characteristics of someone or something", 10.0d, 3, new Destination("Name"))));
    }

    /**
     * Method under test: {@link TravelPack#calculatePrice(Passenger, Activity)}
     */
    @Test
    void testCalculatePrice2() {
        TravelPack travelPack = new TravelPack("Name", 1);
        Passenger passenger = new Passenger("Name", 10, 10.0d, Subscription.STANDARD);

        assertEquals(10.0d, travelPack.calculatePrice(passenger,
                new Activity("Name", "The characteristics of someone or something", 10.0d, 3, new Destination("Name"))));
    }

    /**
     * Method under test: {@link TravelPack#calculatePrice(Passenger, Activity)}
     */
    @Test
    void testCalculatePrice3() {
        TravelPack travelPack = new TravelPack("Name", 1);
        Passenger passenger = new Passenger("Name", 10, 10.0d, Subscription.PREMIUM);

        assertEquals(0.0d, travelPack.calculatePrice(passenger,
                new Activity("Name", "The characteristics of someone or something", 10.0d, 3, new Destination("Name"))));
    }

    /**
     * Method under test: {@link TravelPack#printAvailableActivities()}
     */
    @Test
    void testPrintAvailableActivities() {
        TravelPack travelPack = new TravelPack("Name", 1);
        travelPack.printAvailableActivities();
        List<Destination> destinations = travelPack.getDestinations();
        assertTrue(destinations.isEmpty());
        assertEquals(destinations, travelPack.getPassengers());
        assertEquals(1, travelPack.getPassengerCapacity());
        assertEquals("Name", travelPack.getName());
    }

    /**
     * Method under test: {@link TravelPack#printAvailableActivities()}
     */
    @Test
    void testPrintAvailableActivities2() {
        TravelPack travelPack = new TravelPack("Name", 1);
        travelPack.addDestination(new Destination("Available Activities:"));
        travelPack.printAvailableActivities();
        assertEquals(1, travelPack.getDestinations().size());
        assertTrue(travelPack.getPassengers().isEmpty());
        assertEquals("Name", travelPack.getName());
        assertEquals(1, travelPack.getPassengerCapacity());
    }
}