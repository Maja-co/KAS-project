package Gui.Faner;

import application.controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class SecondTab {

    public Tab createSecondTab() {
        // Opret fane
        Tab tab = new Tab("Opret konferencer");
        tab.setClosable(false); // Forhindre lukning af fanen

        // Layout
        VBox content = new VBox(15);
        content.setPadding(new Insets(15));

        // Felter
        TextField subjectField = new TextField();
        subjectField.setPromptText("Emne");

        TextField conferenceField = new TextField();
        conferenceField.setPromptText("Navnet på konferencen");

        TextField adresseField = new TextField();
        adresseField.setPromptText("Adresse");

        TextField seatsField = new TextField();
        seatsField.setPromptText("Antal pladser");

        TextField priceField = new TextField();
        priceField.setPromptText("Pris (DKK)");

        DatePicker startDatePicker = new DatePicker();
        startDatePicker.setPromptText("Startdato");

        DatePicker endDatePicker = new DatePicker();
        endDatePicker.setPromptText("Slutdato");

        // Knapper
        Button createButton = new Button("Opret");
        createButton.setOnAction(e -> {
            if (validateInputs(subjectField, conferenceField, adresseField, seatsField, priceField, startDatePicker, endDatePicker)) {
                String subject = subjectField.getText();
                String name = conferenceField.getText();
                String address = adresseField.getText();
                int seats = Integer.parseInt(seatsField.getText());
                double price = Double.parseDouble(priceField.getText());
                LocalDate startDate = startDatePicker.getValue();
                LocalDate endDate = endDatePicker.getValue();

                // Brug Controller til at oprette konferencen
                Controller.createConference(name, startDate, endDate, address, price, subject, seats);

                // Feedback til brugeren
                showSuccess("Konferencen blev oprettet succesfuldt!");
            } else {
                showError("Alle felter skal udfyldes korrekt!");
            }
        });

        // Tilføj til layout
        content.getChildren().addAll(
                new Label("Opret en ny konference:"),
                subjectField,
                conferenceField,
                adresseField,
                seatsField,
                priceField,
                startDatePicker,
                endDatePicker,
                new VBox(10, createButton)
        );

        tab.setContent(content);
        return tab;
    }

    private boolean validateInputs(TextField subjectField, TextField conferenceField, TextField adresseField,
                                   TextField seatsField, TextField priceField, DatePicker startDatePicker, DatePicker endDatePicker) {
        try {
            return !subjectField.getText().isEmpty() &&
                    !conferenceField.getText().isEmpty() &&
                    !adresseField.getText().isEmpty() &&
                    Integer.parseInt(seatsField.getText()) > 0 &&
                    Double.parseDouble(priceField.getText()) > 0 &&
                    startDatePicker.getValue() != null &&
                    endDatePicker.getValue() != null &&
                    !endDatePicker.getValue().isBefore(startDatePicker.getValue());
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Fejl");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succes");
        alert.setContentText(message);
        alert.showAndWait();
    }

}
