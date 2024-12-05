package Gui.Faner;

import application.controller.Controller;
import application.model.Conferences;
import Storage.Storage;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


import java.time.LocalDate;

/*
Følgende klasse er anden fane i guien.
Her har man mulighed for at oprette en konference til systemet
 */

public class ConferencesCreationSecondTab {
    private ParticipantViewThirdTab participantViewThirdTab;

    public ConferencesCreationSecondTab(ParticipantViewThirdTab participantViewThirdTab) {
        this.participantViewThirdTab = participantViewThirdTab;
    }

    public Tab createSecondTab() {
        // Opret fane
        Tab tab = new Tab("Opret konferencer");
        tab.setClosable(false);

        // Layout
        VBox content = new VBox(15);
        content.setPadding(new Insets(15));
        content.setBackground(new Background(new BackgroundFill(Color.rgb(36, 74, 54, 0.6), null, null)));
        content.setStyle("-fx-font-family: Georgia; -fx-font-size: 14px;");

        // Overskriften
        Label label = new Label("Opret en ny konference:");
        label.setStyle("-fx-font-family: Georgia; -fx-font-size: 24px; -fx-font-weight: normal; -fx-text-fill: #FFFFFF;");
        HBox titleBox = new HBox(label);
        titleBox.setAlignment(javafx.geometry.Pos.CENTER);
        titleBox.setPadding(new Insets(10));

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
        Button addConferenceButton = new Button("Opret konferencen");
        addConferenceButton.setPrefWidth(500);
        addConferenceButton.setOnAction(e -> {
            if (validateInputs(subjectField, conferenceField, adresseField, seatsField, priceField, startDatePicker, endDatePicker)) {
                String category = subjectField.getText();
                String name = conferenceField.getText();
                String location = adresseField.getText();
                int numberOfSeats = Integer.parseInt(seatsField.getText());
                double pricePrDay = Double.parseDouble(priceField.getText());
                LocalDate startDate = startDatePicker.getValue();
                LocalDate endDate = endDatePicker.getValue();
                String imagePath = "/path/to/default/image.png";
                Conferences newConference = new Conferences(name, startDate, endDate, location, pricePrDay, category, numberOfSeats, imagePath);
                Storage.addConference(newConference);
                participantViewThirdTab.updateConferences();
                showSuccess("Konferencen blev oprettet succesfuldt!");
            } else {
                showError("Alle felter skal udfyldes korrekt!");
            }
        });

        content.getChildren().addAll(
                label,
                subjectField,
                conferenceField,
                adresseField,
                seatsField,
                priceField,
                startDatePicker,
                endDatePicker,
                new VBox(10, addConferenceButton)
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
