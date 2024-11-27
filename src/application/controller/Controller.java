package application.controller;

import Storage.Storage;
import application.model.Conferences;
import application.model.Enrollment;
import application.model.Hotel;
import application.model.Participant;

import java.time.LocalDate;

public class Controller {

    public static Conferences createConference(String name, LocalDate startDate, LocalDate endDate, String location, double pricePrDay, String category, int numberOfSeats) {
        Conferences conference = new Conferences(name, startDate, endDate, location, pricePrDay, category, numberOfSeats);
        Storage.addConference(conference);
        return conference;
    }

    public static Hotel CreateHotel(String name, String address, int pricePrDay, String location) {
        Hotel hotel = new Hotel(name, address, pricePrDay, location);
        Storage.addHotel(hotel);
        return hotel;
    }
//    public static Enrollment CreateEnrollment(boolean isParticipantPrivate, boolean isCompanion, boolean hotelStay, boolean isParticipantLecturer,
//                                              LocalDate dateOfArrival, LocalDate dateOfDeparture, Participant participant){
//        Enrollment enrollment = new Enrollment(isParticipantPrivate, isCompanion, hotelStay, isParticipantLecturer, dateOfArrival, dateOfDeparture, participant);
//        Storage.addEnrollment(enrollment);
//        return enrollment;
//    }
//    public static Enrollment CreateEnrollment(String name, String address, String country, String mobile, LocalDate startDate, LocalDate endDate, boolean isSpeaker, boolean hasCompanion, String companionName, boolean needsAccommodation, String selectedHotel, boolean companionEvents, String selectedEvent) {
//        Enrollment enrollment = new Enrollment(name, address, country, mobile, startDate, endDate, isSpeaker, hasCompanion, companionName, needsAccommodation, selectedHotel, companionEvents, selectedEvent);
//        Storage.addEnrollment(enrollment);
//        return enrollment;
//    }

}
