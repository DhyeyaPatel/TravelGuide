package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private int passengerNumber;
    private double balance;
    private Subscription type;
    private List<Activity> activities;

    // Constructor
    public Passenger(String name, int passengerNumber, Subscription type) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.type = type;
        this.activities = new ArrayList<>();
    }

    public boolean canSignUpForActivity(Activity activity) {
        return type.canSignUpForActivity(this, activity);
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
        type.deductCostFromBalance(this, activity.getCost());
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Subscription getType() {
        return type;
    }

    public void setType(Subscription type) {
        this.type = type;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}


