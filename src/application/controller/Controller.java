package application.controller;

import Storage.Storage;
import application.model.*;

import java.time.LocalDate;

public class Controller {
    public static Conferences createConference(String name, LocalDate startDate, LocalDate endDate, String location, double pricePrDay, String category, int numberOfSeats, String imagePath) {
        Conferences conference = new Conferences(name, startDate, endDate, location, pricePrDay, category, numberOfSeats, imagePath);
        Storage.addConference(conference);
        return conference;
    }

    public static Hotel createHotel(String name, String address, int pricePerDaySingle, int pricePerDayDouble) {
        Hotel hotel = new Hotel(name, address, pricePerDaySingle, pricePerDayDouble);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static HotelFacilities createHotelFacilities(String name, double price) {
        return new HotelFacilities(name, price);
    }

    public static Event createEvent(String name, String description, LocalDate startDate, LocalDate endDate, double price) {
        Event event = new Event(name, description, startDate, endDate, price);
        Storage.addEvent(event);
        return event;
    }

    public static Participant createParticipant(String name, String address, String country, String phoneNumber) {
        Participant participant = new Participant(name, address, country, phoneNumber);
        Storage.addParticipant(participant);
        return participant;
    }

    public static Enrollment createEnrollment(boolean isParticipantPrivate, boolean isAccompanied, boolean hotelStay,
                                              boolean isParticipantLecturer, LocalDate dateOfArrival, LocalDate dateOfDeparture,
                                              Participant participant, Conferences conference, Hotel hotel, Companion companion) {
        Enrollment enrollment = new Enrollment(isParticipantPrivate, isAccompanied, hotelStay, isParticipantLecturer, dateOfArrival, dateOfDeparture, participant, conference, hotel, companion);
        Storage.addEnrollment(enrollment);
        return enrollment;
    }

    public static void addHotelFacilityToHotel(Hotel hotel, HotelFacilities facility) {
        hotel.addHotelFacilities(facility);
    }
}
