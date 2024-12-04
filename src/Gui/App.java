package Gui;

import application.controller.Controller;
import application.model.*;
import javafx.application.Application;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initStorage();

        //Konferencer data:
        Conferences renEnergiIndenforPlanetærGrænserI2024 = Controller.createConference("Ren energi indenfor planetær Grænser i 2040", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), "Svinestien", 1500, "grønomstilling", 500, "/Storage/resource/Picture 1.png");
        Conferences cirkulærByggerri = Controller.createConference("Cirkulært byggeri: Fra tanke til handling", LocalDate.of(2024, 01, 01), LocalDate.of(2024, 1, 5), "Svinestien", 1500, "grønomstilling", 2000, "/Storage/resource/Picture 2.png");
        Conferences harmoniseringAfEpder = Controller.createConference("Harmonisering af EPD'er", LocalDate.of(2024, 01, 01), LocalDate.of(2024, 1, 5), "Svinestien", 1500, "grønomstilling", 25, "/Storage/resource/Picture 3.png");
        Conferences cirkulærCementOgBeton = Controller.createConference("Cirkulær cement og beton", LocalDate.of(2024, 01, 01), LocalDate.of(2024, 1, 5), "Svinestien", 1500, "grønomstilling", 250, "/Storage/resource/Picture 4.png");
        Conferences etbæredygtigEnergisystemFremMod2040 = Controller.createConference("Ren energi indenfor planetær Grænser i 2040", LocalDate.of(2024, 01, 01), LocalDate.of(2024, 1, 5), "Svinestien", 1500, "grønomstilling", 2500, "/Storage/resource/Picture 5.png");
        Conferences PyrolyseOgBiokul = Controller.createConference("Pyrolyse og biokul", LocalDate.of(2024, 01, 01), LocalDate.of(2024, 1, 5), "Svinestien", 1500, "grønomstilling", 500, "/Storage/resource/Picture 6.png");
        Conferences EusKommendeKrav = Controller.createConference("Eu's kommende krav - en cekulær gamechanger indefor cement- og betonbranchen", LocalDate.of(2024, 01, 01), LocalDate.of(2024, 1, 5), "Svinestien", 1500, "grønomstilling", 500, "/Storage/resource/Picture 7.png");
        Conferences hjælpBiodiversitetOgKlima = Controller.createConference("Hjælp biodiversitet og klima gennem plantebaserede investering", LocalDate.of(2024, 01, 01), LocalDate.of(2024, 1, 5), "Svinestien", 1500, "grønomstilling", 500, "/Storage/resource/Picture 8.png");
        Conferences FremskrivningAfAntalletAfElektriskeLastbilerIDanmark = Controller.createConference("Fremskrivning af antallet af elektriske lastbiler i Danmark", LocalDate.of(2024, 11, 15), LocalDate.of(2024, 11, 18), "Danmark", 4000, "grønomstilling", 200, "/Storage/resource/Picture 9.png");
        Conferences GrønneOgSundeVelfærdsbygninger = Controller.createConference("Grønne og sunde velfærdsbygninger", LocalDate.of(2024, 2, 14), LocalDate.of(2088, 2, 18), "Iran", 2800, "grønomstilling", 200, "/Storage/resource/Picture 10.png");

        //Hotelle data:
        Hotel denHvideSvane = Controller.createHotel("Den Hvide Svane", "Glemsomhedens sti 42", 1050, 1250);
        Hotel tipTon = Controller.createHotel("The Tipton Hotel", "138 St. James Street near Fenway Park in Boston, Massachusetts", 1000, 1500);
        Hotel transylvania = Controller.createHotel("Hotel Transylvania", "666 Transylvania Lane, Umbre, Romania", 230, 280);

        //Hotel faciliteter data
        HotelFacilities wifi = Controller.createHotelFacilities("WiFi", 20);
        HotelFacilities bathtub = Controller.createHotelFacilities("Badekar", 20);
        HotelFacilities elevator = Controller.createHotelFacilities("Elevator", 20);
        HotelFacilities roomService = Controller.createHotelFacilities("Roomservice", 50);
        HotelFacilities poolAccess = Controller.createHotelFacilities("Pooladgang", 40);
        HotelFacilities sauna = Controller.createHotelFacilities("Sauna", 30);
        HotelFacilities fitnessCenter = Controller.createHotelFacilities("Fitnesscenter", 30);
        HotelFacilities parking = Controller.createHotelFacilities("Parkering", 25);
        HotelFacilities breakfast = Controller.createHotelFacilities("Morgenmad", 60);
        HotelFacilities tvStreaming = Controller.createHotelFacilities("TV med streamingtjenester", 35);
        HotelFacilities petFriendlyRoom = Controller.createHotelFacilities("Kæledyrsvenligt værelse", 50);
        HotelFacilities minibar = Controller.createHotelFacilities("Minibar", 40);
        HotelFacilities airConditioning = Controller.createHotelFacilities("Aircondition", 15);
        HotelFacilities fastCheckInOut = Controller.createHotelFacilities("Hurtig check-in/check-out", 10);
        HotelFacilities childCare = Controller.createHotelFacilities("Børnepasning", 75);

        // Tilføj faciliteter til Den Hvide Svane
        Controller.addHotelFacilityToHotel(denHvideSvane, wifi);
        Controller.addHotelFacilityToHotel(denHvideSvane, breakfast);
        Controller.addHotelFacilityToHotel(denHvideSvane, parking);

        // Tilføj faciliteter til The Tipton Hotel
        Controller.addHotelFacilityToHotel(tipTon, roomService);
        Controller.addHotelFacilityToHotel(tipTon, poolAccess);
        Controller.addHotelFacilityToHotel(tipTon, sauna);

        // Tilføj faciliteter til Hotel Transylvania
        Controller.addHotelFacilityToHotel(transylvania, minibar);
        Controller.addHotelFacilityToHotel(transylvania, airConditioning);
        Controller.addHotelFacilityToHotel(transylvania, childCare);

        //Udflugter/events data:
        Event egeskov = Controller.createEvent("Egeskov", "GGWP", LocalDate.of(2024, 12, 19), LocalDate.of(2024, 12, 19), 75);
        Event trapHolt = Controller.createEvent("Trapholt", "GGWP", LocalDate.of(2024, 12, 20), LocalDate.of(2024, 12, 20), 200);

        //Deltager data:
        Participant mikkelAndersen = Controller.createParticipant("Mikkel Andersen", "Jyllandsgade 8 7100 Vejle", "Danmark ", "+45 70731584");
        Enrollment mikkelEnrollment = Controller.createEnrollment(true, false, true, true, LocalDate.of(2024, 5, 12), LocalDate.of(2024, 5, 15), mikkelAndersen, GrønneOgSundeVelfærdsbygninger, transylvania);

        Participant emmaJensen = Controller.createParticipant("Emma Jensen", "Østergade 25, 8000 Aarhus", "Danmark", "+45 12345678");
        Enrollment emmaJensenEnrollment = Controller.createEnrollment(true, true, false, false, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), emmaJensen, cirkulærByggerri, denHvideSvane);

        Participant lucasHansen = Controller.createParticipant("Lucas Hansen", "Vestergade 45, 9000 Aalborg", "Danmark", "+45 87654321");
        Enrollment lucasHansenEnrollment = Controller.createEnrollment(false, false, true, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), lucasHansen, renEnergiIndenforPlanetærGrænserI2024, tipTon);

        Participant frejaSørensen = Controller.createParticipant("Freja Sørensen", "Nørregade 10, 5000 Odense", "Danmark", "+45 99887766");
        Enrollment frejaSørensenEnrollment = Controller.createEnrollment(true, false, true, false, LocalDate.of(2024, 2, 14), LocalDate.of(2024, 2, 18), frejaSørensen, GrønneOgSundeVelfærdsbygninger, transylvania);

        Participant madsNielsen = Controller.createParticipant("Mads Nielsen", "Søndergade 30, 6000 Kolding", "Danmark", "+45 11223344");
        Enrollment madsNielsenEnrollment = Controller.createEnrollment(false, true, true, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), madsNielsen, PyrolyseOgBiokul, denHvideSvane);

        Participant sofieKristensen = Controller.createParticipant("Sofie Kristensen", "Hovedgaden 50, 4000 Roskilde", "Danmark", "+45 44332211");
        Enrollment sofieKristensenEnrollment = Controller.createEnrollment(true, true, false, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), sofieKristensen, harmoniseringAfEpder, tipTon);

        Participant williamPetersen = Controller.createParticipant("William Petersen", "Lundgade 12, 7100 Vejle", "Danmark", "+45 55667788");
        Enrollment williamPetersenEnrollment = Controller.createEnrollment(false, false, false, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), williamPetersen, GrønneOgSundeVelfærdsbygninger, transylvania);

        Participant claraMikkelsen = Controller.createParticipant("Clara Mikkelsen", "Parkvej 55, 2400 København", "Danmark", "+45 88990011");
        Enrollment claraMikkelsenEnrollment = Controller.createEnrollment(true, false, false, false, LocalDate.of(2024, 11, 15), LocalDate.of(2024, 11, 18), claraMikkelsen, FremskrivningAfAntalletAfElektriskeLastbilerIDanmark, tipTon);

        Participant oscarChristensen = Controller.createParticipant("Oscar Christensen", "Kirkegade 9, 8000 Aarhus", "Danmark", "+45 66778899");
        Enrollment oscarChristensenEnrollment = Controller.createEnrollment(false, true, true, false, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), oscarChristensen, EusKommendeKrav, denHvideSvane);

        Participant idaThomsen = Controller.createParticipant("Ida Thomsen", "Vejgade 15, 3000 Helsingør", "Danmark", "+45 99880077");
        Enrollment idaThomsenEnrollment = Controller.createEnrollment(true, false, false, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), idaThomsen, hjælpBiodiversitetOgKlima, transylvania);

        Participant noahAndersen = Controller.createParticipant("Noah Andersen", "Søgade 4, 6000 Kolding", "Danmark", "+45 77441122");
        Enrollment noahAndersenEnrollment = Controller.createEnrollment(false, true, true, true, LocalDate.of(2024, 2, 14), LocalDate.of(2024, 2, 18), noahAndersen, GrønneOgSundeVelfærdsbygninger, denHvideSvane);

        Participant livaJacobsen = Controller.createParticipant("Liva Jacobsen", "Strandvej 44, 8700 Horsens", "Danmark", "+45 33225577");
        Enrollment livaJacobsenEnrollment = Controller.createEnrollment(true, false, true, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), livaJacobsen, cirkulærCementOgBeton, tipTon);

        Participant elliotMathisen = Controller.createParticipant("Elliot Mathisen", "Bakkegade 33, 2200 København", "Danmark", "+45 11225588");
        Enrollment elliotMathisenEnrollment = Controller.createEnrollment(false, true, false, false, LocalDate.of(2024, 11, 15), LocalDate.of(2024, 11, 18), elliotMathisen, FremskrivningAfAntalletAfElektriskeLastbilerIDanmark, transylvania);

        Participant almaRasmussen = Controller.createParticipant("Alma Rasmussen", "Viborgvej 2, 8500 Grenaa", "Danmark", "+45 55221100");
        Enrollment almaRasmussenEnrollment = Controller.createEnrollment(true, false, true, false, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), almaRasmussen, harmoniseringAfEpder, denHvideSvane);

        Participant victorKnudsen = Controller.createParticipant("Victor Knudsen", "Skolegade 8, 7100 Vejle", "Danmark", "+45 22334455");
        Enrollment victorKnudsenEnrollment = Controller.createEnrollment(false, false, true, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), victorKnudsen, renEnergiIndenforPlanetærGrænserI2024, tipTon);

        Participant karlaMortensen = Controller.createParticipant("Karla Mortensen", "Lillegade 10, 2900 Hellerup", "Danmark", "+45 99887744");
        Enrollment karlaMortensenEnrollment = Controller.createEnrollment(true, true, false, false, LocalDate.of(2024, 2, 14), LocalDate.of(2024, 2, 18), karlaMortensen, GrønneOgSundeVelfærdsbygninger, transylvania);

        Participant malteLarsen = Controller.createParticipant("Malte Larsen", "Engvej 60, 4800 Nykøbing", "Danmark", "+45 55668822");
        Enrollment malteLarsenEnrollment = Controller.createEnrollment(false, true, false, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), malteLarsen, hjælpBiodiversitetOgKlima, denHvideSvane);

        Participant agnesØstergaard = Controller.createParticipant("Agnes Østergaard", "Markvej 1, 8600 Silkeborg", "Danmark", "+45 22331144");
        Enrollment agnesØstergaardEnrollment = Controller.createEnrollment(true, false, true, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), agnesØstergaard, EusKommendeKrav, tipTon);

        Participant felixAndersen = Controller.createParticipant("Felix Andersen", "Kystvej 20, 3700 Rønne", "Danmark", "+45 66332244");
        Enrollment felixAndersenEnrollment = Controller.createEnrollment(false, true, true, false, LocalDate.of(2024, 11, 15), LocalDate.of(2024, 11, 18), felixAndersen, FremskrivningAfAntalletAfElektriskeLastbilerIDanmark, transylvania);

        Participant lærkeChristiansen = Controller.createParticipant("Lærke Christiansen", "Søborgvej 5, 2800 Kongens Lyngby", "Danmark", "+45 33447788");
        Enrollment lærkeChristiansenEnrollment = Controller.createEnrollment(true, false, false, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), lærkeChristiansen, GrønneOgSundeVelfærdsbygninger, denHvideSvane);

        Participant stormNørgaard = Controller.createParticipant("Storm Nørgaard", "Vesterbrogade 99, 1620 København", "Danmark", "+45 22990011");
        Enrollment stormNørgaardEnrollment = Controller.createEnrollment(false, false, true, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), stormNørgaard, harmoniseringAfEpder, tipTon);


        //Vores test af de udleveret data
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
