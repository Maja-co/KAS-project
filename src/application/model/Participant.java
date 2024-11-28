package application.model;

import java.util.ArrayList;

public class Participant {
    private String name;
    private String address;
    private String country;
    private String phoneNumber;
    private Hotel hotel;
    private final ArrayList<Enrollment> enrollments = new ArrayList<>();
    private final ArrayList<Event> events = new ArrayList<>();
    private Conferences conference;

    public Participant(String name, String address, String country, String phoneNumber, Hotel hotel, Conferences conference) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.hotel = hotel;
        this.conference = conference;
    }


    // Metoder tilhørende Enrollment (get, add og remove) 1..* dobbelt asso
    public ArrayList<Enrollment> getEnrollments() {
        return new ArrayList<>(enrollments);
    }

    public void addEnrollment(Enrollment enrollment) {
        if (!enrollments.contains(enrollment)) {
            enrollments.add(enrollment);
        }
    }

    //Might be removed, make a decision later 21.11.24
    public void removeEnrollment(Enrollment enrollment) {
        enrollments.remove(enrollment);
    }

    // Metoder tilhørende Event (get, add og remove) 0..* enkelt rettet
    public ArrayList<Event> getEvents() {
        return new ArrayList<>(events);
    }

    public void addEvent(Event event) {
        if (!events.contains(event)) {
            events.add(event);
        }
    }

    public void removeEvent(Event event) {
        if (events.contains(event)) {
            events.remove(event);
        }
    }

    // Metoder tilhørende Hotel (get, set) 0..1 enkelt rettet
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        if (this.hotel != hotel) {
            this.hotel = hotel;
        }
    }

    public Conferences getConference() {
        return conference;
    }

    public void setConference(Conferences conference) {
        this.conference = conference;
    }

    public String getName() {
        return name;
    }
}
