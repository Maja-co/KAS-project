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
        double priceForHotelSingle = 0;
        priceForHotelSingle += pricePrDaySingle * (endDate.toEpochDay() - startDate.toEpochDay() - 1);
        for (HotelFacilities listOfHotelFacility : listOfHotelFacilities) {
            if (listOfHotelFacility != null) {
                priceForHotelSingle += listOfHotelFacility.getPricePerFacility();
            }
        }
        return priceForHotelSingle;
    }

    public double priceForHotelDobbel(LocalDate startDate, LocalDate endDate) {
        double priceForHotelDobbel = 0;
        priceForHotelDobbel += pricePrDayDobbel * (endDate.toEpochDay() - startDate.toEpochDay() - 1);
        for (HotelFacilities listOfHotelFacility : listOfHotelFacilities) {
            if (listOfHotelFacility != null) {
                priceForHotelDobbel += listOfHotelFacility.getPricePerFacility();
            }

        }
        return priceForHotelDobbel;
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
}