package Storage;

import application.model.*;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Enrollment> enrollments = new ArrayList<>();
    private static final ArrayList<HotelFacilities> hotelFacilitiesList = new ArrayList<>();
    private static final ArrayList<Hotel> hotels = new ArrayList<>();
    private static final ArrayList<Event> events = new ArrayList<>();
    private static final ArrayList<Conferences> CONFERENCES_ARRAY_LIST = new ArrayList<>();

    // Methods for Enrollment
    public static ArrayList<Enrollment> getEnrollments() {
        return new ArrayList<>(enrollments);
    }

    public static void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public static void removeEnrollment(Enrollment enrollment) {
        enrollments.remove(enrollment);
    }

    // Methods for HotelFacilities
    public static ArrayList<HotelFacilities> getHotelFacilitiesArrayList() {
        return new ArrayList<>(hotelFacilitiesList);
    }

    public static void addHotelFacility(HotelFacilities hotelFacilities) {
        hotelFacilitiesList.add(hotelFacilities);
    }

    public static void removeHotelFacility(HotelFacilities hotelFacilities) {
        hotelFacilitiesList.remove(hotelFacilities);
    }

    // Methods for Hotels
    public static ArrayList<Hotel> getHotels() {
        return new ArrayList<>(hotels);
    }

    public static void addHotel(Hotel hotel) {
        if (!hotels.contains(hotel)) {
            hotels.add(hotel);
        }
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
        return new ArrayList<>(CONFERENCES_ARRAY_LIST);
    }

    public static void addConference(Conferences conference) {
        CONFERENCES_ARRAY_LIST.add(conference);
    }

    public static void removeConference(Conferences conference) {
        CONFERENCES_ARRAY_LIST.remove(conference);
    }
}
