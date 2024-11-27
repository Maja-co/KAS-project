package application.model;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private String address;
    private double pricePrDay;
    private String country;
    private ArrayList<HotelFacilities> listOfHotelFacilities = new ArrayList<>();

    public Hotel(String name, String address, int pricePrDay, String country) {
        this.name = name;
        this.address = address;
        this.pricePrDay = pricePrDay;
        this.country = country;
    }
    //Metode for HotelFacilities klassen ( get(), add() og remove().), 0..* enkelt rettet
    public ArrayList<HotelFacilities> getHotelFacilities() {
        return new ArrayList<>(listOfHotelFacilities);
    }

    public void addHotelFacilities( HotelFacilities hotelFacility){
        if (!listOfHotelFacilities.contains(hotelFacility)){
            listOfHotelFacilities.add(hotelFacility);
        }
    }

    public void removeHotelFacilities(HotelFacilities hotelFacility){
          listOfHotelFacilities.remove(hotelFacility);
    }



    public double getPricePrDay() {
        return pricePrDay;
    }
}
