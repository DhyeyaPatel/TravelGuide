package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String name;
    private List<Activity> activities;

    // Constructor
    public Destination(String name, List<Activity> activities) {
        this.name = name;
        this.activities = new ArrayList<>();
        ;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public String getDestinationDetails() {
        StringBuilder details = new StringBuilder("Destination: " + name + "\n");
        for (Activity activity : activities) {
            details.append(activity.getActivityDetails()).append("\n");
        }
        return details.toString();
    }
}