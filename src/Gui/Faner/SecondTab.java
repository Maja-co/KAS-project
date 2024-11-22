package Gui.Faner;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

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
            // Simpel validering
            if (validateInputs(subjectField, conferenceField, adresseField, seatsField, priceField, startDatePicker, endDatePicker)) {
                // Håndter oprettelsen af konferencen
                System.out.println("Konference oprettet:");
                System.out.println("Emne: " + subjectField.getText());
                System.out.println("Navn: " + conferenceField.getText());
                System.out.println("Adresse: " + adresseField.getText());
                System.out.println("Antal pladser: " + seatsField.getText());
                System.out.println("Pris: " + priceField.getText());
                System.out.println("Startdato: " + startDatePicker.getValue());
                System.out.println("Slutdato: " + endDatePicker.getValue());
            } else {
                showAlert("Fejl", "Alle felter skal udfyldes korrekt!");
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

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }
}
