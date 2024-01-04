package org.example.entity;

/**
 * The type Activity.
 */
public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;

    /**
     * Instantiates a new Activity.
     *
     * @param name        the name
     * @param description the description
     * @param cost        the cost
     * @param capacity    the capacity
     * @param destination the destination
     */
// Constructor
    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
// Getters
    public String getName() {
        return name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Gets capacity.
     *
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets destination.
     *
     * @return the destination
     */
    public Destination getDestination() {
        return destination;
    }
}