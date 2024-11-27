package application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

    public Enrollment(boolean isParticipantPrivate, boolean isCompanion, boolean hotelStay,
                      boolean isParticipantLecturer, LocalDate dateOfArrival, LocalDate dateOfDeparture, Participant participant) {
        this.isParticipantPrivate = isParticipantPrivate;
        this.isCompanion = isCompanion;
        this.hotelStay = hotelStay;
        this.isParticipantLecturer = isParticipantLecturer;
        this.dateOfArrival = dateOfArrival;
        this.dateOfDeparture = dateOfDeparture;
        this.participant = participant;
    }

    //Metoder tilhørende Companion (get, set) 0..1
    public Companion getCompanion() {
        return companion;
    }

    public void setCompanion(Companion companion) {
            this.companion = companion;
    }

    // Metoder tilhørende Hotelfacilities (get, add og remove) 1..*
    public ArrayList<HotelFacilities> getHotelFacilitiesList() {
        return new ArrayList<>(hotelFacilitiesList);
    }

    public void addHotelFacilities(HotelFacilities hotelFacilities) {
        if (!hotelFacilitiesList.contains(hotelFacilities)) {
            hotelFacilitiesList.add(hotelFacilities);
        }
    }

    public void removeHotelFacilities(HotelFacilities hotelFacilities) {
            hotelFacilitiesList.remove(hotelFacilities);
    }

    // Metoder tilhørende Participant (get) 1 komposition dobbelt asso
    public Participant getParticipant() {
        return participant;
    }

    public double calculateTotalPrice() {
        // Konferencepris: Hvis deltager ikke er foredragsholder, betales dagsprisen for konferencen
        double conferencePrice = isParticipantLecturer ? 0 : participant.getConference().getPricePrDay() * calculateDays();

        // Hotelpris: Hvis deltager har valgt hotelophold, betales dagsprisen for hotellet
        double hotelPrice = hotelStay ? participant.getHotel().getPricePrDay() * calculateDays() : 0;

        // Ledsagerpris: Hvis deltager har ledsager, tillægges en fast pris pr. dag
        double companionPrice = isCompanion ? calculateDays() * 80 : 0;
        return conferencePrice + hotelPrice + companionPrice;
    }

    private double calculateDays() {
        return (double) ((dateOfDeparture.toEpochDay() - dateOfArrival.toEpochDay()));
    }

}

