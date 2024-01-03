package pojo;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private int passengerNumber;
    private double balance;
    private Subscription type;
    private List<Activity> activities;

    public Passenger(String name, int passengerNumber, Subscription type) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.type = type;
        this.activities = new ArrayList<>();
    }
}
