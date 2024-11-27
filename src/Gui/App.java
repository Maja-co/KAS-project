package Gui;

import Storage.Storage;
import application.controller.Controller;
import application.model.Enrollment;
import application.model.Participant;
import javafx.application.Application;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(MainWindow.class);

        // Udskriv alle tilmeldinger fra Storage
        for (Enrollment enrollment : Storage.getEnrollments()) {
            System.out.println("Tilmelding oprettet for: " + enrollment.getParticipant().getName());
        }
    }

    private static void initStorage() {
        // Opret Konference og Hotel
        Controller.createConference("Grøn energi", LocalDate.of(2025, 2, 10), LocalDate.of(2025, 2, 13), "Aarhus", 1500, "Vedvarende energi", 200);
        Controller.createHotel("Den hvide svane", "Karrebækvej 741, 4736 Karrebæksminde", 1050, "Danmark");
    }
}
