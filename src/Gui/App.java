package Gui;

import application.controller.Controller;
import application.model.*;
import javafx.application.Application;
import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        initStorage();

        //Konferencer data:
        Conferences renEnergiIndenforPlanetærGrænserI2024 = Controller.createConference("Ren energi indenfor planetær Grænser i 2040", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), "Svinestien", 1500, "grønomstilling", 500, "/Storage/resource/Picture 1.png");
        Conferences cirkulærByggerri = Controller.createConference("Cirkulært byggeri: Fra tanke til handling", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), "Svinestien", 1500, "grønomstilling", 2000, "/Storage/resource/Picture 2.png");
        Conferences harmoniseringAfEpder = Controller.createConference("Harmonisering af EPD'er", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), "Svinestien", 1500, "grønomstilling", 25, "/Storage/resource/Picture 3.png");
        Conferences cirkulærCementOgBeton = Controller.createConference("Cirkulær cement og beton", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), "Svinestien", 1500, "grønomstilling", 250, "/Storage/resource/Picture 4.png");
        Conferences etbæredygtigEnergisystemFremMod2040 = Controller.createConference("Ren energi indenfor planetær Grænser i 2040", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), "Svinestien", 1500, "grønomstilling", 2500, "/Storage/resource/Picture 5.png");
        Conferences PyrolyseOgBiokul = Controller.createConference("Pyrolyse og biokul", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), "Svinestien", 1500, "grønomstilling", 500, "/Storage/resource/Picture 6.png");
        Conferences EusKommendeKrav = Controller.createConference("Eu's kommende krav - en cekulær gamechanger indefor cement- og betonbranchen", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), "Svinestien", 1500, "grønomstilling", 500, "/Storage/resource/Picture 7.png");
        Conferences hjælpBiodiversitetOgKlima = Controller.createConference("Hjælp biodiversitet og klima gennem plantebaserede investering", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), "Svinestien", 1500, "grønomstilling", 500, "/Storage/resource/Picture 8.png");
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
        List<Event> events = List.of(egeskov, trapHolt);

        //Deltager data:
        Participant mikkelAndersen = Controller.createParticipant("Mikkel Andersen", "Jyllandsgade 8 7100 Vejle", "Danmark ", "+45 70731584");
        Companion mikkelCompanion = new Companion("Lise Andersen", "+45 12345678", true, List.of(egeskov));
        Enrollment mikkelEnrollment = Controller.createEnrollment(true, true, true, true, LocalDate.of(2024, 5, 12), LocalDate.of(2024, 5, 15), mikkelAndersen, GrønneOgSundeVelfærdsbygninger, transylvania, mikkelCompanion);

        Participant emmaJensen = Controller.createParticipant("Emma Jensen", "Østergade 25, 8000 Aarhus", "Danmark", "+45 12345678");
        Companion emmaCompanion = new Companion("Lise Jensen", "+45 87654321", false, List.of(egeskov));
        Enrollment emmaJensenEnrollment = Controller.createEnrollment(true, true, false, false, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), emmaJensen, cirkulærByggerri, denHvideSvane, emmaCompanion);

        Participant lucasHansen = Controller.createParticipant("Lucas Hansen", "Vestergade 45, 9000 Aalborg", "Danmark", "+45 87654321");
        Companion lucasCompanion = new Companion("Mette Hansen", "+45 23456789", true, List.of(egeskov));
        Enrollment lucasHansenEnrollment = Controller.createEnrollment(false, false, true, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), lucasHansen, renEnergiIndenforPlanetærGrænserI2024, tipTon, lucasCompanion);

        Participant frejaSørensen = Controller.createParticipant("Freja Sørensen", "Nørregade 10, 5000 Odense", "Danmark", "+45 99887766");
        Companion frejaCompanion = new Companion("Mette Sørensen", "+45 23456789", true, List.of(egeskov));
        Enrollment frejaSørensenEnrollment = Controller.createEnrollment(true, false, true, false, LocalDate.of(2024, 2, 14), LocalDate.of(2024, 2, 18), frejaSørensen, GrønneOgSundeVelfærdsbygninger, transylvania, frejaCompanion);

        Participant madsNielsen = Controller.createParticipant("Mads Nielsen", "Søndergade 30, 6000 Kolding", "Danmark", "+45 11223344");
        Companion madsCompanion = new Companion("Lise Nielsen", "+45 99887765", false, List.of(egeskov));
        Enrollment madsNielsenEnrollment = Controller.createEnrollment(false, true, true, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), madsNielsen, PyrolyseOgBiokul, denHvideSvane, madsCompanion);

        Participant sofieKristensen = Controller.createParticipant("Sofie Kristensen", "Hovedgaden 50, 4000 Roskilde", "Danmark", "+45 44332211");
        Companion sofieCompanion = new Companion("Jakob Kristensen", "+45 98765432", true, List.of(egeskov));
        Enrollment sofieKristensenEnrollment = Controller.createEnrollment(true, true, false, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), sofieKristensen, harmoniseringAfEpder, tipTon, sofieCompanion);

        Participant williamPetersen = Controller.createParticipant("William Petersen", "Lundgade 12, 7100 Vejle", "Danmark", "+45 55667788");
        Companion williamCompanion = new Companion("Anna Petersen", "+45 22334455", false, List.of(egeskov));
        Enrollment williamPetersenEnrollment = Controller.createEnrollment(false, false, false, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), williamPetersen, GrønneOgSundeVelfærdsbygninger, transylvania, williamCompanion);

        Participant claraMikkelsen = Controller.createParticipant("Clara Mikkelsen", "Parkvej 55, 2400 København", "Danmark", "+45 88990011");
        Companion claraCompanion = new Companion("Morten Mikkelsen", "+45 66778899", true, List.of(egeskov));
        Enrollment claraMikkelsenEnrollment = Controller.createEnrollment(true, false, false, false, LocalDate.of(2024, 11, 15), LocalDate.of(2024, 11, 18), claraMikkelsen, FremskrivningAfAntalletAfElektriskeLastbilerIDanmark, tipTon, claraCompanion);

        Participant oscarChristensen = Controller.createParticipant("Oscar Christensen", "Kirkegade 9, 8000 Aarhus", "Danmark", "+45 66778899");
        Companion oscarCompanion = new Companion("Lene Christensen", "+45 22335566", false, List.of(egeskov));
        Enrollment oscarChristensenEnrollment = Controller.createEnrollment(false, true, true, false, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), oscarChristensen, EusKommendeKrav, denHvideSvane, oscarCompanion);

        Participant idaThomsen = Controller.createParticipant("Ida Thomsen", "Vejgade 15, 3000 Helsingør", "Danmark", "+45 99880077");
        Companion idaCompanion = new Companion("Sara Thomsen", "+45 11223344", true, List.of(egeskov));
        Enrollment idaThomsenEnrollment = Controller.createEnrollment(true, false, false, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), idaThomsen, hjælpBiodiversitetOgKlima, transylvania, idaCompanion);

        Participant noahAndersen = Controller.createParticipant("Noah Andersen", "Søgade 4, 6000 Kolding", "Danmark", "+45 77441122");
        Companion noahCompanion = new Companion("Marie Andersen", "+45 33445566", false, List.of(egeskov));
        Enrollment noahAndersenEnrollment = Controller.createEnrollment(false, true, true, true, LocalDate.of(2024, 2, 14), LocalDate.of(2024, 2, 18), noahAndersen, GrønneOgSundeVelfærdsbygninger, denHvideSvane, noahCompanion);

        Participant livaJacobsen = Controller.createParticipant("Liva Jacobsen", "Strandvej 44, 8700 Horsens", "Danmark", "+45 33225577");
        Companion livaCompanion = new Companion("Søren Jacobsen", "+45 55667788", true, List.of(egeskov));
        Enrollment livaJacobsenEnrollment = Controller.createEnrollment(true, false, true, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), livaJacobsen, cirkulærCementOgBeton, tipTon, livaCompanion);

        Participant elliotMathisen = Controller.createParticipant("Elliot Mathisen", "Bakkegade 33, 2200 København", "Danmark", "+45 11225588");
        Companion elliotCompanion = new Companion("Pernille Mathisen", "+45 99881122", true, List.of(egeskov));
        Enrollment elliotMathisenEnrollment = Controller.createEnrollment(false, true, false, false, LocalDate.of(2024, 11, 15), LocalDate.of(2024, 11, 18), elliotMathisen, FremskrivningAfAntalletAfElektriskeLastbilerIDanmark, transylvania, elliotCompanion);

        Participant almaRasmussen = Controller.createParticipant("Alma Rasmussen", "Viborgvej 2, 8500 Grenaa", "Danmark", "+45 55221100");
        Companion almaCompanion = new Companion("Rasmus Rasmussen", "+45 33445566", false, List.of(egeskov));
        Enrollment almaRasmussenEnrollment = Controller.createEnrollment(true, false, true, false, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), almaRasmussen, harmoniseringAfEpder, denHvideSvane, almaCompanion);

        Participant victorKnudsen = Controller.createParticipant("Victor Knudsen", "Skolegade 8, 7100 Vejle", "Danmark", "+45 22334455");
        Companion victorCompanion = new Companion("Mette Knudsen", "+45 66778899", true, List.of(egeskov));
        Enrollment victorKnudsenEnrollment = Controller.createEnrollment(false, false, true, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), victorKnudsen, renEnergiIndenforPlanetærGrænserI2024, tipTon, victorCompanion);

        Participant karlaMortensen = Controller.createParticipant("Karla Mortensen", "Lillegade 10, 2900 Hellerup", "Danmark", "+45 99887744");
        Companion karlaCompanion = new Companion("Anders Mortensen", "+45 55667788", false, List.of(egeskov));
        Enrollment karlaMortensenEnrollment = Controller.createEnrollment(true, true, false, false, LocalDate.of(2024, 2, 14), LocalDate.of(2024, 2, 18), karlaMortensen, GrønneOgSundeVelfærdsbygninger, transylvania, karlaCompanion);

        Participant malteLarsen = Controller.createParticipant("Malte Larsen", "Engvej 60, 4800 Nykøbing", "Danmark", "+45 55668822");
        Companion malteCompanion = new Companion("Julie Larsen", "+45 99887766", true, List.of(egeskov));
        Enrollment malteLarsenEnrollment = Controller.createEnrollment(false, true, false, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), malteLarsen, hjælpBiodiversitetOgKlima, denHvideSvane, malteCompanion);

        Participant agnesØstergaard = Controller.createParticipant("Agnes Østergaard", "Markvej 1, 8600 Silkeborg", "Danmark", "+45 22331144");
        Companion agnesCompanion = new Companion("Kasper Østergaard", "+45 11223344", false, List.of(egeskov));
        Enrollment agnesØstergaardEnrollment = Controller.createEnrollment(true, false, true, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), agnesØstergaard, EusKommendeKrav, tipTon, agnesCompanion);

        Participant felixAndersen = Controller.createParticipant("Felix Andersen", "Kystvej 20, 3700 Rønne", "Danmark", "+45 66332244");
        Companion felixCompanion = new Companion("Nina Andersen", "+45 33445566", true, List.of(egeskov));
        Enrollment felixAndersenEnrollment = Controller.createEnrollment(false, true, true, false, LocalDate.of(2024, 11, 15), LocalDate.of(2024, 11, 18), felixAndersen, FremskrivningAfAntalletAfElektriskeLastbilerIDanmark, transylvania, felixCompanion);

        Participant lærkeChristiansen = Controller.createParticipant("Lærke Christiansen", "Søborgvej 5, 2800 Kongens Lyngby", "Danmark", "+45 33447788");
        Companion lærkeCompanion = new Companion("Thomas Christiansen", "+45 22334455", false, List.of(egeskov));
        Enrollment lærkeChristiansenEnrollment = Controller.createEnrollment(true, false, false, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), lærkeChristiansen, GrønneOgSundeVelfærdsbygninger, denHvideSvane, lærkeCompanion);

        Participant stormNørgaard = Controller.createParticipant("Storm Nørgaard", "Vesterbrogade 99, 1620 København", "Danmark", "+45 22990011");
        Companion stormCompanion = new Companion("Rikke Nørgaard", "+45 44336688", true, List.of(egeskov));
        Enrollment stormNørgaardEnrollment = Controller.createEnrollment(false, false, true, true, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), stormNørgaard, harmoniseringAfEpder, tipTon, stormCompanion);

        Application.launch(MainWindow.class);
    }

    private static void initStorage() {
    }
}
