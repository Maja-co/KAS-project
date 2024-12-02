package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Event {
    String name;
    String adress;
    LocalDate startDate;
    LocalDate endDate;
    double pricePerEvent;
    ArrayList<Event> events = new ArrayList<>();

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

    public String getName() {
        return name;
    }

public void addEvent (Event event) {
        if (!events.contains(event)){
            events.add(event);
        }

}
}
