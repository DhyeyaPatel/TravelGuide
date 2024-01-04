package org.example.entity;

import org.example.entity.passengerType.Subscription;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Passenger.
 */
public class Passenger {
    private String name;
    private int passengerNumber;
    private double balance;
    private Subscription type;
    private List<Activity> activities;

    /**
     * Instantiates a new Passenger.
     *
     * @param name            the name
     * @param passengerNumber the passenger number
     * @param balance         the balance
     * @param type            the type
     */
// Constructor
    public Passenger(String name, int passengerNumber, double balance, Subscription type) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = (type.equals(Subscription.PREMIUM) ? 0.0 : balance);
        this.type = type;
        this.activities = new ArrayList<>();
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
     * Gets passenger number.
     *
     * @return the passenger number
     */
    public int getPassengerNumber() {
        return passengerNumber;
    }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets activities.
     *
     * @return the activities
     */
    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public Subscription getType() {
        return type;
    }

    /**
     * Sign up for activity.
     *
     * @param activity the activity
     */
    public void signUpForActivity(Activity activity) {
        if (activity.getCapacity() > 0) {
            activities.add(activity);
            activity.getDestination().getActivities().remove(activity);
            activity.getDestination().getActivities().add(new Activity(activity.getName(),
                    activity.getDescription(), activity.getCost(), activity.getCapacity() - 1, activity.getDestination()));
            if (this.getType().equals(Subscription.GOLD)) {
                double discountedCost = activity.getCost() * 0.9;
                balance -= discountedCost;
            } else if (this.getType().equals(Subscription.STANDARD)) {
                balance -= activity.getCost();
            }
        }
    }
}