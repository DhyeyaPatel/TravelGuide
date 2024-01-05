package org.example.entity;

import org.example.entity.passengerType.Subscription;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Travel pack.
 */
public class TravelPack {
    private String name;
    private int passengerCapacity;
    private List<Destination> destinations;
    private List<Passenger> passengers;

    /**
     * Instantiates a new Travel pack.
     *
     * @param name              the name
     * @param passengerCapacity the passenger capacity
     */
// Constructor
    public TravelPack(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.destinations = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    /**
     * Add destination.
     *
     * @param destination the destination
     */
    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    /**
     * Add passenger.
     *
     * @param passenger the passenger
     */
    public void addPassenger(List<Passenger> passenger) {
        if (passengers.size() < passengerCapacity) {
            for (Passenger p : passenger)
                this.passengers.add(p);
        }
    }

    /**
     * Print itinerary.
     */
    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : destinations) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName() +
                        ", Cost: " + activity.getCost() +
                        ", Capacity: " + activity.getCapacity() +
                        ", Description: " + activity.getDescription());
            }
        }
    }

    /**
     * Print passenger list.
     */
    public void printPassengerList() {
        System.out.println("Passenger List for Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("Passenger: " + passenger.getName() +
                    ", Passenger Number: " + passenger.getPassengerNumber());
        }
    }

    /**
     * Print passenger details.
     *
     * @param passengerList the passenger list
     */
    public void printPassengerDetails(List<Passenger> passengerList) {
        for (Passenger passenger : passengerList) {
            System.out.println("Passenger Details:");
            System.out.println("Name: " + passenger.getName());
            System.out.println("Number: " + passenger.getPassengerNumber());
            if (passenger.getType().equals(Subscription.STANDARD) || passenger.getType().equals(Subscription.GOLD)) {
                System.out.println("Balance: " + passenger.getBalance());
            }
            System.out.println("Activities Signed Up:");
            for (Activity activity : passenger.getActivities()) {
                System.out.println("Activity: " + activity.getName() +
                        ", Destination: " + activity.getDestination().getName() +
                        ", Price Paid: " + calculatePrice(passenger, activity));
            }
        }
    }

    /**
     * Calculate price double.
     *
     * @param passenger the passenger
     * @param activity  the activity
     * @return the double
     */
    public double calculatePrice(Passenger passenger, Activity activity) {
        if (passenger.getType().equals(Subscription.GOLD))
            return activity.getCost() * 0.9;
        else if (passenger.getType().equals(Subscription.STANDARD)) {
            return activity.getCost();
        }
        return 0.0;
    }

    /**
     * Print available activities.
     */
    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : destinations) {
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName() +
                        ", Destination: " + destination.getName() +
                        ", Capacity: " + activity.getCapacity());
            }
        }
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets passenger capacity.
     *
     * @return the passenger capacity
     */
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    /**
     * Gets destinations.
     *
     * @return the destinations
     */
    public List<Destination> getDestinations() {
        return destinations;
    }

    /**
     * Gets passengers.
     *
     * @return the passengers
     */
    public List<Passenger> getPassengers() {
        return passengers;
    }
}