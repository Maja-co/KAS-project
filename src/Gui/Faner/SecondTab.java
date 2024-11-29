package Gui.Faner;

import application.controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import application.controller.Controller;
import javafx.scene.paint.Color;


import java.time.LocalDate;

public class SecondTab {

    public Tab createSecondTab() {
        // Opret fane
        Tab tab = new Tab("Opret konferencer");
        tab.setClosable(false);

        // Layout
        VBox content = new VBox(15);
        content.setPadding(new Insets(15));
        content.setBackground(new Background(new BackgroundFill(Color.rgb(36, 74, 54, 0.6), null, null)));

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
        Button createButton = new Button("Opret konferencen");
        createButton.setPrefWidth(400);
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
                String imagePath = "/path/to/default/image.png";
                Controller.createConference(name, startDate, endDate, address, price, subject, seats, imagePath);


                // Feedback til brugeren
                showSuccess("Konferencen blev oprettet succesfuldt!");
            } else {
                showError("Alle felter skal udfyldes korrekt!");
            }
        });

        // Tilføj til layout
        Label label = new Label("Opret en ny konference:");
        label.setFont(javafx.scene.text.Font.font("Arial", 24));  // Sætter fonten til Arial og størrelsen til 18px
        label.setStyle("-fx-font-weight: normal; -fx-text-fill: #000000;");
        content.getChildren().addAll(
                label,
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
