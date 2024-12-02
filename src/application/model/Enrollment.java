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

    public double calculateTotalPrice(Enrollment enrollment) {
        double totalprice = 0;
        if (!isParticipantLecturer) {
            totalprice += conference.calculateConferencePrice();
        }
        // if (isParticipantPrivate == true && isParticipantLecturer == false) {
        //     totalprice += conference.calculateConferencePrice();
        // }
        if (hotelStay) {
            if (isCompanion) {
                totalprice += hotel.priceForHotelDobbel(getDateOfArrival(), getDateOfDeparture());
            } else {
                totalprice += hotel.priceForHotelSingle(getDateOfArrival(), getDateOfDeparture());
            }
        }

        for (HotelFacilities hotelFacilities : Storage.getHotelFacilitiesArrayList()) {
            if (hotelFacilities != null) {
                totalprice += hotelFacilities.getPricePerFacility();
            }
        }
        //Her kommer pris metode for events***** if ()
        for (Event event : Storage.getEvents()) {

            if (event != null) {
                totalprice += event.getPricePerEvent();
            }

        }
        return totalprice;
    }
}
