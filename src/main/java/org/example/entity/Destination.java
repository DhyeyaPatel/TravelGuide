package org.example.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Destination.
 */
public class Destination {
    private String name;
    private List<Activity> activities;

    /**
     * Instantiates a new Destination.
     *
     * @param name the name
     */
// Constructor
    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    /**
     * Add activity.
     *
     * @param activity the activity
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
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
     * Gets activities.
     *
     * @return the activities
     */
    public List<Activity> getActivities() {
        return activities;
    }
}