package Storage;

import application.model.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final ArrayList<Enrollment> enrollments = new ArrayList<>();
    private static final ArrayList<Hotel> hotels = new ArrayList<>();
    private static final ArrayList<Event> events = new ArrayList<>();
    private static ArrayList<Conferences> conferences = new ArrayList<>();
    private static final ArrayList<Participant> participants = new ArrayList<>();

    // Methods for Enrollment-class
    public static ArrayList<Enrollment> getEnrollments() {
        System.out.println("Enrollment" + enrollments);
        return new ArrayList<>(enrollments);
    }

    public static void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    // Methods for Hotels
    public static ArrayList<Hotel> getHotels() {
        return new ArrayList<>(hotels);
    }

    public static void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    // Methods for Events
    public static ArrayList<Event> getEvents() {
        return new ArrayList<>(events);
    }

    public static void addEvent(Event event) {
        events.add(event);
    }

    // Methods for Conferences
    public static List<Conferences> getConferences() {
        if (conferences == null) {
            System.out.println("Fejl: conferences listen er null.");
            return new ArrayList<>();
        }
        return conferences;
    }

    public static void addConference(Conferences conference) {
        if (!conferences.contains(conference)) {
            conferences.add(conference);
        }
    }

    public static void addParticipant(Participant participant) {
        participants.add(participant);
    }

}
