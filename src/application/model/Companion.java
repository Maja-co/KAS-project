package application.model;

public class Companion {
    private String name;
    private String phoneNumber; // Ændret til String for at håndtere telefonnumre korrekt
    private boolean wantsTrip; // For at indikere, om ledsageren ønsker en ledsagerudflugt
    private String tripDetails; // Valgfrit: detaljer om ledsagerens tur

    public Companion(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.wantsTrip = false; // Default: ledsager ønsker ikke udflugt
        this.tripDetails = null; // Default: ingen detaljer
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean wantsTrip() {
        return wantsTrip;
    }

    public String getTripDetails() {
        return tripDetails != null ? tripDetails : "Ingen ledsagerudflugt valgt";
    }

}