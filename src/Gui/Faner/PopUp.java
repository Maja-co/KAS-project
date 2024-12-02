package Gui.Faner;

import Storage.Storage;
import application.controller.Controller;
import application.model.*;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;

public class PopUp {
    private ThirdTab thirdTab;
    private Conferences conference;

    public PopUp(ThirdTab thirdTab, Conferences conference) {
        this.thirdTab = thirdTab;
        this.conference = conference;
    }

    public void showPopup() {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        VBox popupContent = new VBox(15);
        popupContent.setPadding(new Insets(20));
        popupContent.setSpacing(10);
        popupContent.setPrefHeight(800);
        popupContent.setBackground(new Background(new BackgroundFill(Color.rgb(36, 74, 54, 0.6), null, null)));
        popupContent.setStyle("-fx-font-family: Georgia; -fx-font-size: 14px;");

        // Opret HBox til at centrere overskriften
        HBox headerBox = new HBox();
        headerBox.setAlignment(javafx.geometry.Pos.CENTER);  // Centrer overskriften
        headerBox.setPadding(new Insets(10));  // Tilføj lidt padding rundt om overskriften

        // Overskriften
        Label label = new Label("Tilmeldelse til: " + conference.getName());
        label.setStyle("-fx-font-family: Georgia; -fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #FFFFFF;");
        headerBox.getChildren().add(label);

        // Tilføj HBox med overskriften til popupContent
        popupContent.getChildren().add(headerBox);

        // Felter til input
        TextField nameField = new TextField();
        nameField.setPromptText("Navn");
        TextField addressField = new TextField();
        addressField.setPromptText("Adresse");
        TextField countryField = new TextField();
        countryField.setPromptText("Land");
        TextField mobileField = new TextField();
        mobileField.setPromptText("Mobilnummer");

        // Datovalg
        DatePicker startDatePicker = new DatePicker();
        startDatePicker.setPromptText("Ankomstdato");
        DatePicker endDatePicker = new DatePicker();
        endDatePicker.setPromptText("Afrejsedato");

        // Valgmuligheder
        CheckBox speakerCheckBox = new CheckBox("Er du foredragsholder?");
        CheckBox companionCheckBox = new CheckBox("Medbringer du ledsager?");
        TextField companionField = new TextField();
        companionField.setPromptText("Ledsagers navn");
        companionField.setDisable(true);
        companionCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
            companionField.setDisable(!newVal);
        });

        CheckBox accommodationCheckBox = new CheckBox("Ønsker du overnatning?");
        ListView<String> hotelListView = new ListView<>();
        hotelListView.getItems().addAll(Storage.getHotels().stream().map(Hotel::getName).toList());
        hotelListView.setPrefHeight(130);
        hotelListView.setDisable(true);
        accommodationCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
            hotelListView.setDisable(!newVal);
        });

        CheckBox eventCheckBox = new CheckBox("Ønsker ledsager at deltage i udflugter/events?");
        ListView<String> eventListView = new ListView<>();
        eventListView.getItems().addAll(Storage.getEvents().stream().map(Event::getName).toList());
        eventListView.setDisable(true);
        eventListView.setPrefHeight(130);
        eventCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
            eventListView.setDisable(!newVal);
        });

        // Knappen til at tilmelde sig
        Button submitButton = new Button("Tilmeld mig - Samlet pris: 0 kr");
        submitButton.setPrefWidth(300);

        // beregning af pris
        ChangeListener<Object> priceUpdater = (obs, oldVal, newVal) -> {
            double totalPrice = conference.calculateConferencePrice();
//
//            if (accommodationCheckBox.isSelected() && hotelListView.getSelectionModel().getSelectedItem() != null) {
//                Hotel selectedHotel = Storage.getHotels().stream()
//                        .filter(hotel -> hotel.getName().equals(hotelListView.getSelectionModel().getSelectedItem()))
//                        .findFirst().orElse(null);
//                if (selectedHotel != null) {
//                    totalPrice += selectedHotel.getPricePerDaySingle() * (endDatePicker.getValue().toEpochDay() - startDatePicker.getValue().toEpochDay());
//                }
//            }
//
//            if (companionCheckBox.isSelected()) {
//                totalPrice += 500;
//            }

            submitButton.setText(String.format("Tilmeld mig - Samlet pris: %.2f kr", totalPrice));
        };

        // Tilføj listeners for at opdatere prisen
        accommodationCheckBox.selectedProperty().addListener(priceUpdater);
        companionCheckBox.selectedProperty().addListener(priceUpdater);
        hotelListView.getSelectionModel().selectedItemProperty().addListener(priceUpdater);
        startDatePicker.valueProperty().addListener(priceUpdater);
        endDatePicker.valueProperty().addListener(priceUpdater);

        // Handling for tilmeldingsknappen
        submitButton.setOnAction(e -> {
            String name = nameField.getText().trim();
            String address = addressField.getText().trim();
            String country = countryField.getText().trim();
            String mobile = mobileField.getText().trim();

            if (name.isEmpty() || address.isEmpty() || country.isEmpty() || mobile.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Fejl");
                alert.setHeaderText("Udfyld venligst alle felter");
                alert.showAndWait();
                return;
            }

            boolean isLecturer = speakerCheckBox.isSelected();
            boolean hasCompanion = companionCheckBox.isSelected();
            String companionName = hasCompanion ? companionField.getText().trim() : "";

            Hotel selectedHotel = Storage.getHotels().stream()
                    .filter(h -> h.getName().equals(hotelListView.getSelectionModel().getSelectedItem()))
                    .findFirst().orElse(null);

            Participant participant = Controller.createParticipant(name, address, country, mobile);
            Controller.createEnrollment(true, true, false, isLecturer, startDatePicker.getValue(),
                    endDatePicker.getValue(), participant, conference, selectedHotel, null);

            thirdTab.updateParticipantList();
            popup.close();
        });

        popupContent.getChildren().addAll(
                nameField, addressField, countryField, mobileField,
                startDatePicker, endDatePicker, speakerCheckBox, companionCheckBox, companionField,
                accommodationCheckBox, hotelListView, eventCheckBox, eventListView, submitButton
        );

        Scene popupScene = new Scene(new ScrollPane(popupContent), 650, 750);  // Grundlæggende størrelse
        popup.setScene(popupScene);
        popup.sizeToScene();  // Automatisk tilpasning
        popup.setTitle("Tilmelding");
        popup.show();
    }
}
