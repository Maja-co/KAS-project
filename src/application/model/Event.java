package application.model;

import java.time.LocalDate;

public class Event {
    String name;
    String adress;
    LocalDate startDate;
    LocalDate endDate;

    public Event(String name, String adress, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.adress = adress;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

