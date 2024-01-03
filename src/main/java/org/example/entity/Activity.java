package org.example.entity;

import java.util.List;

public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private List<Destination> destinations;

    // Constructor
    public Activity(String name, String description, double cost, int capacity, List<Destination> destinations) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destinations = destinations;
    }

    public boolean isAvailable() {
        return capacity > 0;
    }

    public boolean signUp(Passenger passenger) {
        if (isAvailable() && passenger.canSignUpForActivity(this)) {
            passenger.addActivity(this);
            capacity--;
            return true;
        }
        return false;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public String getActivityDetails() {
        return String.format("Activity: %s, Cost: $%.2f, Capacity: %d, Description: %s",
                name, cost, capacity, description);
    }
}