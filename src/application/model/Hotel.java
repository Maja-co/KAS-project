package application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private String address;
    private int pricePrDayDobbel;
    private int pricePrDaySingle;
    private List<HotelFacilities> listOfHotelFacilities;

    public Hotel(String name, String address, int pricePrDaySingle, int pricePrDayDobbel) {
        this.name = name;
        this.address = address;
        this.pricePrDayDobbel = pricePrDayDobbel;
        this.pricePrDaySingle = pricePrDaySingle;
        this.listOfHotelFacilities = new ArrayList<>();
    }

    public List<HotelFacilities> getListOfHotelFacilities() {
        return listOfHotelFacilities;
    }

    public double priceForHotelSingle(LocalDate startDate, LocalDate endDate) {
        long days = endDate.toEpochDay() - startDate.toEpochDay();
        double priceForHotelSingle = 0;
        if (days < 1) {
            return priceForHotelSingle = 0;
        }
        priceForHotelSingle += pricePrDaySingle * days;
        return priceForHotelSingle;
    }

    public double priceForHotelDobbel(LocalDate startDate, LocalDate endDate) {
        long days = endDate.toEpochDay() - startDate.toEpochDay();
        double priceForHotelDobbelRoom = 0;
        if (days < 1) {
            return priceForHotelDobbelRoom = 0;
        }
        priceForHotelDobbelRoom += pricePrDayDobbel * days;
        return priceForHotelDobbelRoom;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void addHotelFacilities(HotelFacilities facility) {
        if (!this.listOfHotelFacilities.contains(facility)) {
            this.listOfHotelFacilities.add(facility);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}