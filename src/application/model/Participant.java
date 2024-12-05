package application.model;

import java.util.ArrayList;

public class Participant {
    private String name;
    private String address;
    private String country;
    private String phoneNumber;

    public Participant(String name, String address, String country, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name + " (" + country + ")";
    }
}
