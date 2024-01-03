package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengersList;

    // Constructor
    public TravelPackage(String name, int passengerCapacity, List<Destination> itinerary, List<Passenger> passengersList) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengersList = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    public void addPassenger(Passenger passenger) {
        if (passengersList.size() < passengerCapacity) {
            passengersList.add(passenger);
        }
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public void setItinerary(List<Destination> itinerary) {
        this.itinerary = itinerary;
    }

    public List<Passenger> getPassengersList() {
        return passengersList;
    }

    public void setPassengersList(List<Passenger> passengersList) {
        this.passengersList = passengersList;
    }

    public String getItineraryDetails() {
        StringBuilder details = new StringBuilder("Travel Package: " + name + "\n");
        for (Destination destination : itinerary) {
            details.append(destination.getDestinationDetails()).append("\n");
        }
        return details.toString();
    }

    public String getPassengerList() {
        StringBuilder details = new StringBuilder("Passenger List for Travel Package: " + name + "\n");
        details.append("Capacity: ").append(passengerCapacity).append("\n");
        details.append("Number of Passengers: ").append(passengersList.size()).append("\n");
        for (Passenger passenger : passengersList) {
            details.append("Name: ").append(passenger.getName()).append(", Number: ").append(passenger.getPassengerNumber()).append("\n");
        }
        return details.toString();
    }
}