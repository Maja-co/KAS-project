package Storage;

import application.model.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final List<Conferences> conferences = new ArrayList<>();
    private static final List<Hotel> hotels = new ArrayList<>();
    private static final List<Enrollment> enrollments = new ArrayList<>();

    public static void addConference(Conferences conference) {
        conferences.add(conference);
    }

    public static List<Conferences> getConferences() {
        return new ArrayList<>(conferences);
    }

    public static void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public static List<Hotel> getHotels() {
        return new ArrayList<>(hotels);
    }

    public static void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
        // Debugging output to verify the enrollment addition
        System.out.println("Enrollment added: " + (enrollment.getParticipant() != null
                ? enrollment.getParticipant().getName()
                : "Participant is null"));
    }

    public static List<Enrollment> getEnrollments() {
        return new ArrayList<>(enrollments);
    }
}
