package application.controller;

import Storage.Storage;
import application.model.*;

import java.time.LocalDate;

public class Controller {

    public static Conferences createConference(String name, LocalDate startDate, LocalDate endDate, String location, double pricePrDay, String category, int numberOfSeats) {
        Conferences conference = new Conferences(name, startDate, endDate, location, pricePrDay, category, numberOfSeats);
        Storage.addConference(conference);
        return conference;
    }

    public static Hotel createHotel(String name, String address, int pricePrDay, String location) {
        Hotel hotel = new Hotel(name, address, pricePrDay, location);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static Enrollment createEnrollment(String name, String address, String country, String mobile, LocalDate startDate, LocalDate endDate, boolean isSpeaker, boolean hasCompanion, String companionName, boolean needsAccommodation, String selectedHotel, boolean companionEvents, String selectedEvent) {
        // Opret en Participant instans
        Participant participant = new Participant(name, address, country, mobile); // Sørg for korrekt konstruktion af Participant

        // Hvis der er en ledsager, opret Companion
        Companion companion = null;
        if (hasCompanion) {
            companion = new Companion(companionName); // Sørg for korrekt konstruktion af Companion
        }

        // Opret Enrollment
        Enrollment enrollment = new Enrollment(false, hasCompanion, needsAccommodation, isSpeaker, startDate, endDate, participant);

        // Hvis der er en ledsager, tilknyt denne til enrollment
        if (companion != null) {
            enrollment.setCompanion(companion);
        }
        Storage.addEnrollment(enrollment);

        return enrollment;

    }
}
