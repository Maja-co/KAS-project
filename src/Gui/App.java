package Gui;

import application.controller.Controller;
import application.model.*;
import javafx.application.Application;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initStorage();

        Conferences renEnergiIndenforPlanetærGrænserI2024 = Controller.createConference("Ren energi indenfor planetær Grænser i 2040",LocalDate.of(2024,01,01), LocalDate.of(2024,1,5),"Svinestien",1500,"grønomstilling",500, "/Storage/resource/Picture 1.png");

        Conferences cirkulærByggerri = Controller.createConference("Cirkulært byggeri: Fra tanke til handling",LocalDate.of(2024,01,01), LocalDate.of(2024,1,5),"Svinestien",1500,"grønomstilling",2000, "/Storage/resource/Picture 2.png");

        Conferences harmoniseringAfEpder = Controller.createConference("Harmonisering af EPD'er",LocalDate.of(2024,01,01), LocalDate.of(2024,1,5),"Svinestien",1500,"grønomstilling",25, "/Storage/resource/Picture 3.png");

        Conferences cirkulærCementOgBeton = Controller.createConference("Cirkulær cement og beton",LocalDate.of(2024,01,01), LocalDate.of(2024,1,5),"Svinestien",1500,"grønomstilling",250, "/Storage/resource/Picture 4.png");

        Conferences etbæredygtigEnergisystemFremMod2040 = Controller.createConference("Ren energi indenfor planetær Grænser i 2040",LocalDate.of(2024,01,01), LocalDate.of(2024,1,5),"Svinestien",1500,"grønomstilling",2500, "/Storage/resource/Picture 5.png");

        Conferences PyrolyseOgBiokul = Controller.createConference("Pyrolyse og biokul",LocalDate.of(2024,01,01), LocalDate.of(2024,1,5),"Svinestien",1500,"grønomstilling",500, "/Storage/resource/Picture 6.png");

        Conferences EusKommendeKrav = Controller.createConference("Eu's kommende krav - en cekulær gamechanger indefor cement- og betonbranchen",LocalDate.of(2024,01,01), LocalDate.of(2024,1,5),"Svinestien",1500,"grønomstilling",500, "/Storage/resource/Picture 7.png");

        Conferences hjælpBiodiversitetOgKlima = Controller.createConference("Hjælp biodiversitet og klima gennem plantebaserede investering",LocalDate.of(2024,01,01), LocalDate.of(2024,1,5),"Svinestien",1500,"grønomstilling",500, "/Storage/resource/Picture 8.png");

        Conferences FremskrivningAfAntalletAfElektriskeLastbilerIDanmark = Controller.createConference("Fremskrivning af antallet af elektriske lastbiler i Danmark",LocalDate.of(2024,11,15),LocalDate.of(2024,11,18),"Danmark", 4000, "grønomstilling", 200, "/Storage/resource/Picture 9.png");

        Conferences GrønneOgSundeVelfærdsbygninger = Controller.createConference("Grønne og sunde velfærdsbygninger", LocalDate.of(2024, 2,14), LocalDate.of(2088,2,18), "Iran", 2800, "grønomstilling", 200, "/Storage/resource/Picture 10.png");

        Hotel denHvideSvane = Controller.createHotel("Den Hvide Svane", "Glemsomhedens sti 42", 1000, 1250);
        Event egeskov = Controller.createEvent("Egeskov", "GGWP", LocalDate.of(2024,12,19),LocalDate.of(2024,12,19),75);
        Event trapHolt = Controller.createEvent("Trapholt", "GGWP", LocalDate.of(2024,12,20),LocalDate.of(2024,12,20),200);
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
