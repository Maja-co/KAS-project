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
    private String imagePath;

    private ArrayList<Enrollment> enrollments = new ArrayList<>();
    private ArrayList<Event> events = new ArrayList<>();
    private ArrayList<Hotel> hotels = new ArrayList<>();

    public Conferences(String name, LocalDate startDate, LocalDate endDate, String location, double pricePrDay, String category, int numberOfSeats, String imagePath) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.pricePrDay = pricePrDay;
        this.category = category;
        this.numberOfSeats = numberOfSeats;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }

    public double getPricePrDay() {
        return pricePrDay;
    }

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

    public ArrayList<Enrollment> getEnrollments() {
        return new ArrayList<>(enrollments);
    }

    public void addEnrollment(Enrollment enrollment) {
        if (!enrollments.contains(enrollment)) {
            enrollments.add(enrollment);
        }
    }

    public void removeEnrollment(Enrollment enrollment) {
        enrollments.remove(enrollment);
    }

    public double calculateConferencePrice() {
        return pricePrDay * (endDate.toEpochDay() - startDate.toEpochDay());
    }
    public String getImagePath() {
        return imagePath;
    }
}
