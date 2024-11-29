package Gui;

import application.controller.Controller;
import application.model.*;
import javafx.application.Application;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(MainWindow.class);

// Test 01
        /*
        System.out.println("Test 01 ");
        Participant finnMadsen = Controller.createParticipant("Finn Madsen", "Bysmedvej 24","Denmark", "31313131");

        Conferences havOgHimmel = Controller.createConference("Hav og Himmel", LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 13), "Island Brygge", 1500);

        Hotel denHvideSvane = Controller.createHotel("Den Hvide Svane","Glemsomhedens sti 42",1050, 1250);

        Enrollment enrollment1 = Controller.createEnrollment(true,false,false,false,LocalDate.of(2024,1,10), LocalDate.of(2024,1,13), "Finn Madsen",havOgHimmel, denHvideSvane);


        System.out.println(enrollment1.calculateTotalPrice(enrollment1));
        */
        //Test 02
        /*
        System.out.println("Test 02 ");

        Participant nielsPetersen = Controller.createParticipant("Niels Petersen", "Fuldstændig ligegyldigt", "Afrikaaaaa", "31313131");
        Enrollment enrollment2 = Controller.createEnrollment(false,false,true,false,LocalDate.of(2024,1,10), LocalDate.of(2024,1,13),"Niels Petersen",havOgHimmel,denHvideSvane);

        System.out.println(enrollment2.calculateTotalPrice(enrollment2));
        */

        //Test 03
        /*
        System.out.println("Test 03 ");

        Participant peterSommer = Controller.createParticipant("Peter Sommer","Bumsestræde 666","Mælkevejen", "31313131");
        HotelFacilities wifi = Controller.createHotelFacilities("Wifi",50);
        Event egeskov = Controller.createEvent("Egeskov", "GGWP", LocalDate.of(2024,12,19),LocalDate.of(2024,12,19),75);
        Event trapHolt = Controller.createEvent("Trapholt", "GGWP", LocalDate.of(2024,12,20),LocalDate.of(2024,12,20),200);

        Enrollment enrollment3 = Controller.createEnrollment(true,true,true,false,LocalDate.of(2024,12,10), LocalDate.of(2024,12,13),"Peter Sommer",havOgHimmel,denHvideSvane);
        System.out.println(enrollment3.calculateTotalPrice(enrollment3));
        */

        //Test 04
//        System.out.println("Test 04");
//        Participant loneJensen = Controller.createParticipant("Lone Jensen", "ÅåååhGud", "Polen", "31313131");
//        Conferences havOgHimmel = Controller.createConference("Hav og Himmel", LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 13), "Island Brygge", 1500, "Business", 200);
//
//        Hotel denHvideSvane = Controller.createHotel("Den Hvide Svane", "Glemsomhedens sti 42", 1000, 1250);
//        HotelFacilities wifi = Controller.createHotelFacilities("Wifi", 50);
//        Event egeskov = Controller.createEvent("Egeskov", "GGWP", LocalDate.of(2024, 12, 19), LocalDate.of(2024, 12, 19), 75);
//        Event trapHolt = Controller.createEvent("byrundtur i Odense", "GGWP", LocalDate.of(2024, 12, 20), LocalDate.of(2024, 12, 20), 125);
//
//        Enrollment enrollment04 = Controller.createEnrollment(
//                true, true, true, true,
//                LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 13),
//                loneJensen, havOgHimmel, denHvideSvane);
//        System.out.println(enrollment04.calculateTotalPrice());
    }


    private static void initStorage() {
    }
}
