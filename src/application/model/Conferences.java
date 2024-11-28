package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Conferences {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private double pricePrDay;
    private String category;
    private int numberOfSeats;

    // Link attributes:
    private final ArrayList<Enrollment> enrollments = new ArrayList<>();
    private final ArrayList<Event> events = new ArrayList<>();
    private final ArrayList<Hotel> hotels = new ArrayList<>();

    public Conferences(String name, LocalDate startDate, LocalDate endDate, String location, double pricePrDay, String category, int numberOfSeats) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.pricePrDay = pricePrDay;
        this.category = category;
        this.numberOfSeats = numberOfSeats;
    }

    public String getName() {
        return name;
    }

    public double getPricePrDay() {
        return pricePrDay;
    }

    //Metoder for Event-klassen ( 0..*)
    public ArrayList<Event> getEvents() {
        return new ArrayList<>(events);
    }

    public void addEvent(Event event) {
        if (!events.contains(event)) {
            events.add(event);
        }
    }

    public void removeEvent(Event event) {
        events.remove(event);
    }

    //Metoder for Hotel-klassen (0...*)
    public ArrayList<Hotel> getHotels() {
        return new ArrayList<>(hotels);
    }

    public void addHotel(Hotel hotel) {
        if (!hotels.contains(hotel)) {
            hotels.add(hotel);
        }
    }

    public void removeHotel(Hotel hotel) {
        hotels.remove(hotel);
    }

    //Metoder for Enrollment-klassen (0...*)
    public ArrayList<Enrollment> getEnrollments() {
        return new ArrayList<>(enrollments);
    }

    public void addEnrollments(Enrollment enrollment) {
        if (!enrollments.contains(enrollment)) {
            enrollments.add(enrollment);
        }
    }

    public void removeEnrollment(Enrollment enrollment) {
        enrollments.remove(enrollment);
    }

    public int calculateTotalRevenue() {
        int total = 0;
        for (Enrollment enrollment : enrollments) {
            total += enrollment.calculateTotalPrice();
        }
        return total;
    }
}