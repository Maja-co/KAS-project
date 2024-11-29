package application.model;

import java.time.LocalDate;

public class Event {
    String name;
    String adress;
    LocalDate startDate;
    LocalDate endDate;
    double pricePerEvent;

    public Event(String name, String adress, LocalDate startDate, LocalDate endDate, double pricePerEvent) {
        this.name = name;
        this.adress = adress;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pricePerEvent = pricePerEvent;
    }

    public double getPricePerEvent() {
        return pricePerEvent;
    }
}
