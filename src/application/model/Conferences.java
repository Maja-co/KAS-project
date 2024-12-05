package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Conferences {
    private String name;
    private static LocalDate startDate;
    private static LocalDate endDate;
    private String location;
    private double pricePrDay;
    private String category;
    private int numberOfSeats;
    private String imagePath;

    public Conferences(String name, LocalDate startDate, LocalDate endDate, String location, double pricePrDay, String category, int numberOfSeats, String imagePath) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.pricePrDay = pricePrDay;
        this.category = category;
        this.numberOfSeats = numberOfSeats;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public double calculateConferencePrice(LocalDate startDate, LocalDate endDate) {
        long days = endDate.toEpochDay() - startDate.toEpochDay();
        if (days <= 0) {
            return pricePrDay;
        } else {
            return pricePrDay * (days + 1);
        }
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return name;
    }
}
