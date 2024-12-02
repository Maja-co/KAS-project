package application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private String address;
    private int pricePrDayDobbel;
    private int priceprDaySingle;
    private List<HotelFacilities> listOfHotelFacilities;

    public Hotel(String name, String address, int priceprDaySingle, int pricePrDayDobbel) {
        this.name = name;
        this.address = address;
        this.pricePrDayDobbel = pricePrDayDobbel;
        this.priceprDaySingle = priceprDaySingle;
        this.listOfHotelFacilities = new ArrayList<>();
    }

    public double priceForHotelSingle(LocalDate startDate, LocalDate endDate){
        double priceForHotelSingle = 0;
        priceForHotelSingle += priceprDaySingle * (endDate.toEpochDay() -startDate.toEpochDay()-1);
        for (HotelFacilities listOfHotelFacility : listOfHotelFacilities) {
            if (listOfHotelFacility != null){
                priceForHotelSingle += listOfHotelFacility.getPricePerFacility();
            }

        }
        return priceForHotelSingle;
    }
    public double priceForHotelDobbel(LocalDate startDate, LocalDate endDate){
        double priceForHotelDobbel = 0;
        priceForHotelDobbel += pricePrDayDobbel * (endDate.toEpochDay() -startDate.toEpochDay()-1);
        for (HotelFacilities listOfHotelFacility : listOfHotelFacilities) {
            if (listOfHotelFacility != null){
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

}
