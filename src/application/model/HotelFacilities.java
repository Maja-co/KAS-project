package application.model;

public class HotelFacilities {
    private String nameOfFacility;
    private double pricePerFacility;

    public HotelFacilities(String nameOfFacility,double pricePerFacility) {
        this.pricePerFacility = pricePerFacility;
        this.nameOfFacility = nameOfFacility;
    }
    public double getPricePerFacility() {
        return pricePerFacility;
    }

    public String getNameOfFacility() {
        return nameOfFacility;
    }
}