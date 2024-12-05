package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Enrollment {
    private boolean isParticipantPrivate;
    private boolean isAccompanied;
    private boolean hotelStay;
    private boolean isParticipantLecturer;
    private LocalDate dateOfArrival;
    private LocalDate dateOfDeparture;

    private Hotel hotel;
    private Companion companion;
    private Conferences conference;
    private Participant participant;
    private final ArrayList<Event> events = new ArrayList<>();
    private final ArrayList<HotelFacilities> hotelFacilitiesList = new ArrayList<>();

    public Enrollment(boolean isParticipantPrivate, boolean isAccompanied, boolean hotelStay,
                      boolean isParticipantLecturer, LocalDate dateOfArrival, LocalDate dateOfDeparture,
                      Participant participant, Conferences conference, Hotel hotel, Companion companion) {

        this.conference = conference;
        this.isParticipantPrivate = isParticipantPrivate;
        this.isAccompanied = isAccompanied;
        this.hotelStay = hotelStay;
        this.isParticipantLecturer = isParticipantLecturer;
        this.dateOfArrival = dateOfArrival;
        this.dateOfDeparture = dateOfDeparture;
        this.participant = participant;
        this.hotel = hotel;
        this.companion = companion;
    }
//
//    public ArrayList<HotelFacilities> getHotelFacilitiesList() {
//        return hotelFacilitiesList;
//    }

    public void addHotelFacilities(HotelFacilities hotelFacility) {
        if (!hotelFacilitiesList.contains(hotelFacility)) {
            hotelFacilitiesList.add(hotelFacility);
        }
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void addEvent(Event event) {
        if (!events.contains(event)) {
            events.add(event);
        }
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
        return isAccompanied() ? companion.getName() : "Ingen ledsager";
    }

    public boolean wantsAccommodation() {
        return hotelStay;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public String getHotelName() {
        return hotel != null ? hotel.getName() : "Ingen hotel valgt";
    }

//    public boolean wantsCompanionTrip() {
//        return isAccompanied() && companion != null && companion.wantsTrip();
//    }
//
//    public String getCompanionTrip() {
//        return isAccompanied() ? companion.getTripDetails() : null;
//    }

    public Participant getParticipant() {
        return participant;
    }

    public Conferences getConference() {
        return conference;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;

        if (!isParticipantLecturer) {
            totalPrice += conference.calculateConferencePrice(dateOfArrival, dateOfDeparture);
        }

        if (hotelStay && hotel != null) {
            if (isAccompanied) {
                totalPrice += hotel.priceForHotelDobbel(dateOfArrival, dateOfDeparture);
            } else {
                totalPrice += hotel.priceForHotelSingle(dateOfArrival, dateOfDeparture);
            }
        }

        for (HotelFacilities facility : hotelFacilitiesList) {
            totalPrice += facility.getPricePerFacility();
        }

        for (Event event : events) {
            totalPrice += event.getPricePerEvent();
        }

        return totalPrice;
    }

    public Companion getCompanion() {
        return companion;
    }
}
