package Gui;

import application.controller.Controller;
import application.model.Conferences;
import javafx.application.Application;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(MainWindow.class);
    }

    private static void initStorage() {
        Controller.createConference("Grøn energi", LocalDate.of(2025, 2, 10), LocalDate.of(2025, 2, 13), "Aarhus", 1500, "Vedvarende energi", 200);
        Controller.CreateHotel("Den hvide svane", "Karrebækvej 741, 4736 Karrebæksminde", 1050, "Danmark");
    }
}

