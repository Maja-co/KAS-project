package Storage;

import application.model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Enrollment> enrollments = new ArrayList<>();
    private static final ArrayList<HotelFacilities> hotelFacilitiesList = new ArrayList<>();
    private static final ArrayList<Hotel> hotels = new ArrayList<>();
    private static final ArrayList<Event> events = new ArrayList<>();
    private static final ArrayList<Conferences> conferences = new ArrayList<>();
    private static final ArrayList<Participant> participants = new ArrayList<>();

    // Methods for Enrollment-class
    public static ArrayList<Enrollment> getEnrollments() {
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
    public static ArrayList<Conferences> getConferences() {
        return new ArrayList<>(conferences);
    }

    public static void addConference(Conferences conference) {
        conferences.add(conference);
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

    public static void initSampleData() {
        // Create sample conferences
        Conferences conference1 = new Conferences("Himmel og Hav", LocalDate.now(), LocalDate.now().plusDays(2), "Copenhagen", 1500, "Havet", 200);
        addConference(conference1);

        // Create sample participants
        Participant participant1 = new Participant("John Doe", "Main St 1", "Denmark", "12345678");
        addParticipant(participant1);

        // Create sample hotels
        Hotel hotel1 = new Hotel("Grand Hotel", "City Center", 800, 1200);
        addHotel(hotel1);

        // Create sample hotel facilities
        HotelFacilities spa = new HotelFacilities("Spa", 300);
        addHotelFacilities(spa);
    }
}
