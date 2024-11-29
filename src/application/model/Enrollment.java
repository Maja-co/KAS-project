package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Enrollment {
    private boolean isParticipantPrivate;
    private boolean isCompanion;
    private boolean hotelStay;
    private boolean isParticipantLecturer;
    private LocalDate dateOfArrival;
    private LocalDate dateOfDeparture;
    private final ArrayList<HotelFacilities> hotelFacilitiesList = new ArrayList<>();
    private Companion companion;
    private Participant participant;
    private Conferences conference;
    private Hotel hotel;
    private final ArrayList<Event> events = new ArrayList<>();

    public Enrollment(boolean isParticipantPrivate, boolean isCompanion, boolean hotelStay,
                      boolean isParticipantLecturer, LocalDate dateOfArrival, LocalDate dateOfDeparture,
                      Participant participant, Conferences conference, Hotel hotel, Companion companion) {
        this.conference = conference;
        this.isParticipantPrivate = isParticipantPrivate;
        this.isCompanion = isCompanion;
        this.hotelStay = hotelStay;
        this.isParticipantLecturer = isParticipantLecturer;
        this.dateOfArrival = dateOfArrival;
        this.dateOfDeparture = dateOfDeparture;
        this.participant = participant;
        this.hotel = hotel;
        this.companion = companion;
    }
    public boolean hasCompanion(){
        return companion != null;
    }
    public LocalDate getArrivalDate() {
        return dateOfArrival;
    }

    public LocalDate getDepartureDate() {
        return dateOfDeparture;
    }

    public boolean isSpeaker() {
        return isParticipantLecturer;
    }

    public boolean isAccompanied() {
        return companion != null;
    }

    public String getCompanionName() {
        return isAccompanied() ? companion.getName() : null;
    }

    public boolean wantsAccommodation() {
        return hotelStay;
    }

    public String getHotelName() {
        return hotel != null ? hotel.getName() : "Ingen hotel valgt";
    }

    public boolean wantsCompanionTrip() {
        return isAccompanied() && companion.wantsTrip();
    }

    public String getCompanionTrip() {
        return isAccompanied() ? companion.getTripDetails() : null;
    }

    public Participant getParticipant() {
        return participant;
    }

    public Conferences getConference() {
        return conference;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        totalPrice += calculateConferencePrice();
        totalPrice += calculateHotelPrice();
        totalPrice += calculateEventPrice();
        return totalPrice;
    }

    private double calculateConferencePrice() {
        return isParticipantLecturer ? 0 : conference.calculateConferencePrice();
    }

    private double calculateHotelPrice() {
        if (!hotelStay || hotel == null) return 0;

        double hotelPrice = isCompanion
                ? hotel.priceForHotelDouble(dateOfArrival, dateOfDeparture)
                : hotel.priceForHotelSingle(dateOfArrival, dateOfDeparture);

        for (HotelFacilities facility : hotelFacilitiesList) {
            hotelPrice += facility.getPricePerFacility();
        }

        return hotelPrice;
    }

    private double calculateEventPrice() {
        double eventPrice = 0;
        for (Event event : events) {
            eventPrice += event.getPricePerEvent();
        }
        return eventPrice;
    }
}
