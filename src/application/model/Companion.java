package application.model;

public class Companion {
    private String name;
    private String phoneNumber;
    private boolean wantsTrip;
    private String tripDetails;

    public Companion(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.wantsTrip = false;
        this.tripDetails = null;
    }

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