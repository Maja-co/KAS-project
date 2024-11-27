package application.model;

import java.util.ArrayList;

public class HotelFacilities {
    private final ArrayList<String> listOfHotelFacilities = new ArrayList<>();
    private int pricePerFacilites;

    public HotelFacilities(int pricePerFacilites){
        this.pricePerFacilites = pricePerFacilites;
    }
}
