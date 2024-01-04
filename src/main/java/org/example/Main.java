package org.example;

import org.example.entity.Activity;
import org.example.entity.Destination;
import org.example.entity.Passenger;
import org.example.entity.TravelPack;
import org.example.entity.passengerType.Subscription;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        TravelPack europePackage = new TravelPack("Europe Tour", 20);

        Destination paris = new Destination("Paris");
        paris.addActivity(new Activity("Eiffel Tower Tour", "Guided tour of the Eiffel Tower", 50.0, 10, paris));
        paris.addActivity(new Activity("Louvre Museum Visit", "Explore the famous Louvre Museum", 40.0, 15, paris));

        Destination rome = new Destination("Rome");
        rome.addActivity(new Activity("Colosseum Tour", "Visit the historic Colosseum", 60.0, 12, rome));
        rome.addActivity(new Activity("Vatican City Tour", "Explore Vatican City", 55.0, 8, rome));

        europePackage.addDestination(paris);
        europePackage.addDestination(rome);

        List<Passenger> passengerList = new ArrayList<>();
        Passenger p1 = new Passenger("John", 1, 100.0, Subscription.STANDARD);
        Passenger p2 = new Passenger("Alice", 2, 150.0, Subscription.GOLD);
        Passenger p3 = new Passenger("Bob", 3, 10.0, Subscription.PREMIUM);
        passengerList.add(p1);
        passengerList.add(p2);
        passengerList.add(p3);
        europePackage.addPassenger(passengerList);

        System.out.println("-----------------Itinerary of the travel package-----------------");
        europePackage.printItinerary();
        System.out.println();
        System.out.println("-----------------Passenger list of the travel package-----------------");
        europePackage.printPassengerList();
        System.out.println();
        System.out.println("-----------------Available Activities-----------------");
        europePackage.printAvailableActivities();
        System.out.println();

        // Simulating sign up for activities
        p1.signUpForActivity(paris.getActivities().get(0));
        p2.signUpForActivity(rome.getActivities().get(1));
        p3.signUpForActivity(paris.getActivities().get(1));
        System.out.println("-----------------The details of an individual passenger-----------------");
        europePackage.printPassengerDetails(passengerList);
        System.out.println();
        System.out.println("-----------------Available activities after signup-----------------");
        europePackage.printAvailableActivities();
    }
}