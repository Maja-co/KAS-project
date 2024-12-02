package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

import Storage.Storage;

public class Enrollment {
    private boolean isParticipantPrivate;
    private boolean isCompanion;
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

    public Enrollment(boolean isParticipantPrivate, boolean isCompanion, boolean hotelStay,
                      boolean isParticipantLecturer, LocalDate dateOfArrival, LocalDate dateOfDeparture,
                      Participant participant, Conferences conference, Hotel hotel) {

        this.conference = conference;
        this.isParticipantPrivate = isParticipantPrivate;
        this.isCompanion = isCompanion;
        this.hotelStay = hotelStay;
        this.isParticipantLecturer = isParticipantLecturer;
        this.dateOfArrival = dateOfArrival;
        this.dateOfDeparture = dateOfDeparture;
        this.participant = participant;
        this.hotel = hotel;
    }

    public ArrayList<HotelFacilities> getHotelFacilitiesList() {
        return hotelFacilitiesList;
    }

    public void addHotelFacilities(HotelFacilities hotelFacility) {
        if(!hotelFacilitiesList.contains(hotelFacility)) {
            hotelFacilitiesList.add(hotelFacility);
        }
    }

    public void addEvent(Event event) {
        if (!events.contains(event)) {
            events.add(event);
        }
    }

    public boolean hasCompanion() {
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

    public LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    public LocalDate getDateOfArrival() {
        return dateOfArrival;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;

        if (!isParticipantLecturer) {
            totalPrice += conference.calculateConferencePrice(dateOfArrival, dateOfDeparture);
        }

        if (hotelStay && hotel != null) {
            if (isCompanion) {
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
}
