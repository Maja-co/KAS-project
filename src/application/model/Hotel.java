package application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private String address;
    private int pricePerDayDouble;
    private int pricePerDaySingle;
    private List<HotelFacilities> listOfHotelFacilities;

    public Hotel(String name, String address, int pricePerDaySingle, int pricePerDayDouble) {
        this.name = name;
        this.address = address;
        this.pricePerDayDouble = pricePerDayDouble;
        this.pricePerDaySingle = pricePerDaySingle;
        this.listOfHotelFacilities = new ArrayList<>();
    }

    public double priceForHotelSingle(LocalDate startDate, LocalDate endDate) {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        return pricePerDaySingle * days;
    }

    public double priceForHotelDouble(LocalDate startDate, LocalDate endDate) {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        return pricePerDayDouble * days;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPricePerDayDouble() {
        return pricePerDayDouble;
    }

    public int getPricePerDaySingle() {
        return pricePerDaySingle;
    }
}
