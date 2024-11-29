package Gui;

import application.controller.Controller;
import application.model.*;
import javafx.application.Application;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initStorage();

//        Conferences havOgHimmel = Controller.createConference("Hav og Himmel", LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 13), "Island Brygge", 1500, "Business", 200);
//        Hotel denHvideSvane = Controller.createHotel("Den Hvide Svane", "Glemsomhedens sti 42", 1000, 1250);
//
//// Test 01
//        System.out.println("Test 01 ");
//        Participant finnMadsen = Controller.createParticipant("Finn Madsen", "H.C. Andersens Boulevard 34, 1. th, 1553 København V","Denmark", "+45 88707270");
//        Enrollment enrollment01 = Controller.createEnrollment(
//                true, false, false, false,
//                LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 13),
//                finnMadsen, havOgHimmel, denHvideSvane);
//        System.out.println(enrollment01.calculateTotalPrice());
//
//        //Test 02
//        System.out.println("Test 02 ");
//        Participant nielsPetersen = Controller.createParticipant("Niels Petersen", "Tophøjvej 2B, Brøndum, 9500 Hobro", "Danmark", "+45 72214184");
//        Enrollment enrollment02 = Controller.createEnrollment(
//                false, false, true, false,
//                LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 13),
//                nielsPetersen, havOgHimmel, denHvideSvane);
//        System.out.println(enrollment02.calculateTotalPrice());
//
//
//        //Test 03
//        System.out.println("Test 03 ");
//        Participant peterSommer = Controller.createParticipant("Peter Sommer","Gl. Landevej 34A, Roskilde By, 4000 Roskilde", "Danmark", "+45 95568645");
//        HotelFacilities wifi = Controller.createHotelFacilities("Wifi",50);
//        Event egeskov = Controller.createEvent("Egeskov", "GGWP", LocalDate.of(2024,12,19),LocalDate.of(2024,12,19),75);
//        Event trapHolt = Controller.createEvent("Trapholt", "GGWP", LocalDate.of(2024,12,20),LocalDate.of(2024,12,20),200);
//
//        Enrollment enrollment03 = Controller.createEnrollment(
//                true, true, true, false,
//                LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 13),
//                peterSommer, havOgHimmel, denHvideSvane);
//        System.out.println(enrollment03.calculateTotalPrice());
//
//        //Test 04
//        System.out.println("Test 04");
//        Participant loneJensen = Controller.createParticipant("Lone Jensen", "Vigerslev Allé 158P, Hf. Danshøj, 2500 Valby", "Danmark", "+45 41852843");
//        HotelFacilities wifi = Controller.createHotelFacilities("Wifi", 50);
//        Event egeskov = Controller.createEvent("Egeskov", "GGWP", LocalDate.of(2024, 12, 19), LocalDate.of(2024, 12, 19), 75);
//        Event trapHolt = Controller.createEvent("byrundtur i Odense", "GGWP", LocalDate.of(2024, 12, 20), LocalDate.of(2024, 12, 20), 125);
//
//        Enrollment enrollment04 = Controller.createEnrollment(
//                true, true, true, true,
//                LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 13),
//                loneJensen, havOgHimmel, denHvideSvane);
//        System.out.println(enrollment04.calculateTotalPrice());

        Application.launch(MainWindow.class);
    }


    private static void initStorage() {
    }
}
