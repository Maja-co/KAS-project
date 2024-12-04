package Storage;

import application.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final ArrayList<Enrollment> enrollments = new ArrayList<>();
    private static final ArrayList<HotelFacilities> hotelFacilitiesList = new ArrayList<>();
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

    public static void removeEnrollment(Enrollment enrollment) {
        enrollments.remove(enrollment);
    }

    // Methods for HotelFacilities-class
    public static ArrayList<HotelFacilities> getHotelFacilities() {
        return new ArrayList<>(hotelFacilitiesList);
    }

    public static void addHotelFacilities(HotelFacilities hotelFacilities) {
        hotelFacilitiesList.add(hotelFacilities);
    }

    public static void removeHotelFacilities(HotelFacilities hotelFacilities) {
        hotelFacilitiesList.remove(hotelFacilities);
    }

    public static ArrayList<HotelFacilities> getHotelFacilitiesArrayList() {
        return new ArrayList<>(hotelFacilitiesList);
    }

    // Methods for Hotels
    public static ArrayList<Hotel> getHotels() {
        return new ArrayList<>(hotels);
    }

    public static void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public static void removeHotel(Hotel hotel) {
        hotels.remove(hotel);
    }

    // Methods for Events
    public static ArrayList<Event> getEvents() {
        return new ArrayList<>(events);
    }

    public static void addEvent(Event event) {
        events.add(event);
    }

    public static void removeEvent(Event event) {
        events.remove(event);
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

    // Methods for Participants
    public static Participant getParticipant(String name) {
        for (Participant p : participants) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public static void addParticipant(Participant participant) {
        participants.add(participant);
    }

}
