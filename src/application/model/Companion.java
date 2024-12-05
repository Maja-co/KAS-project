package application.model;

import java.util.ArrayList;
import java.util.List;

public class Companion {
    private String name;
    private String phoneNumber;
    private boolean wantsTrip;
    private String tripDetails;
    private List<Event> selectedEvents;

    public Companion(String name, String phoneNumber, boolean wantsTrip, List<Event> selectedEvents) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.wantsTrip = wantsTrip;
        this.tripDetails = null;
        this.selectedEvents = selectedEvents != null ? selectedEvents : new ArrayList<>();
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
    public void addEvent(Event event) {
        if (this.selectedEvents == null) {
            this.selectedEvents = new ArrayList<>();
        }
        this.selectedEvents.add(event);
    }

    public List<Event> getSelectedEvents() {
        return selectedEvents;
    }
}