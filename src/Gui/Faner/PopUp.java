package Gui.Faner;

import Storage.Storage;
import application.controller.Controller;
import application.model.Conferences;
import application.model.Enrollment;
import application.model.Hotel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;

public class PopUp {

    private ThirdTab thirdTab;

    public PopUp(ThirdTab thirdTab) {
        this.thirdTab = thirdTab;
    }

    public void showPopup() {
        // Opret popup-vindue
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);

        // Layout for pop-up
        VBox popupContent = new VBox(15);
        popupContent.setPadding(new Insets(15));
        popupContent.setSpacing(10);

        // Felter til deltager
        TextField nameField = new TextField();
        nameField.setPromptText("Navn");

        TextField addressField = new TextField();
        addressField.setPromptText("Adresse");

        TextField countryField = new TextField();
        countryField.setPromptText("Land");

        TextField mobileField = new TextField();
        mobileField.setPromptText("Mobilnummer");

        DatePicker startDatePicker = new DatePicker();
        startDatePicker.setPromptText("Ankomstdato");

        DatePicker endDatePicker = new DatePicker();
        endDatePicker.setPromptText("Afrejsedato");

        CheckBox speakerCheckBox = new CheckBox("Er du foredragsholder?");
        CheckBox companionCheckBox = new CheckBox("Medbringer du ledsager?");
        TextField companionField = new TextField();
        companionField.setPromptText("Ledsagers navn");
        companionField.setDisable(true);
        companionCheckBox.selectedProperty().addListener((obs, wasSelected, isSelected) -> {
            companionField.setDisable(!isSelected);
        });

        CheckBox accommodationCheckBox = new CheckBox("Ønsker du overnatning?");
        ListView<String> hotelListView = new ListView<>();
        hotelListView.getItems().addAll("Hotel A", "Hotel B", "Hotel C");
        hotelListView.setPrefHeight(150);
        hotelListView.setDisable(true);
        accommodationCheckBox.selectedProperty().addListener((obs, wasSelected, isSelected) -> {
            hotelListView.setDisable(!isSelected);
        });

        CheckBox eventCheckBox = new CheckBox("Ønsker ledsager at deltage i udflugter/events?");
        ListView<String> eventListView = new ListView<>();
        eventListView.getItems().addAll("Udflugt 1", "Udflugt 2", "Event 3");
        eventListView.setPrefHeight(150);
        eventListView.setDisable(true);
        eventCheckBox.selectedProperty().addListener((obs, wasSelected, isSelected) -> {
            eventListView.setDisable(!isSelected);
        });

        // Tilmeld-knap
        Button submitButton = new Button("Tilmeld mig");
        submitButton.setOnAction(e -> {
            // Hent data fra formularen
            String name = nameField.getText();
            String address = addressField.getText();
            String country = countryField.getText();
            String mobile = mobileField.getText();
            LocalDate startDate = startDatePicker.getValue();
            LocalDate endDate = endDatePicker.getValue();
            boolean isSpeaker = speakerCheckBox.isSelected();
            boolean hasCompanion = companionCheckBox.isSelected();
            String companionName = companionField.getText();
            boolean needsAccommodation = accommodationCheckBox.isSelected();
            String selectedHotelName = hotelListView.getSelectionModel().getSelectedItem();
            boolean companionEvents = eventCheckBox.isSelected();
            String selectedEvent = eventListView.getSelectionModel().getSelectedItem();

            // Find hotel og konference
            Hotel selectedHotel = null;
            for (Hotel hotel : Storage.getHotels()) {
                if (hotel.getName().equals(selectedHotelName)) {
                    selectedHotel = hotel;
                    break;
                }
            }

            Conferences selectedConference = null;
            for (Conferences conference : Storage.getConferences()) {
                if (conference.getName().equals(selectedEvent)) {
                    selectedConference = conference;
                    break;
                }
            }

            // Debugging: Udskriv hvad der er valgt
            System.out.println("Navn: " + name);                        //Slet følgende
            System.out.println("Valgt Hotel: " + selectedHotelName);    //Slet følgende
            System.out.println("Valgt Konference: " + selectedEvent);   //Slet følende

            // Tjek om alle felter er udfyldt korrekt
            if (name.isEmpty() || address.isEmpty() || country.isEmpty() || mobile.isEmpty()
                    || startDate == null || endDate == null) {
                showError("Alle felter skal udfyldes!");
                return;
            }

            // Opret tilmelding
            Enrollment enrollment = Controller.createEnrollment(
                    name, address, country, mobile, selectedHotel, selectedConference, startDate, endDate,
                    isSpeaker, hasCompanion, companionName, needsAccommodation,
                    selectedHotelName, companionEvents, selectedEvent);

            if (enrollment != null) {
                System.out.println("Tilmelding oprettet: " + name);
                Storage.addEnrollment(enrollment);
                showSuccess("Tilmelding oprettet for: " + name);

                // Opdater ThirdTab
                if (thirdTab != null) {
                    thirdTab.updateParticipantList();
                } popup.close();
            } else {
                showError("Kunne ikke oprette tilmeldingen.");
            }
        });

        popupContent.getChildren().addAll(
                nameField, addressField, countryField, mobileField, startDatePicker, endDatePicker,
                speakerCheckBox, companionCheckBox, companionField, accommodationCheckBox, hotelListView, eventCheckBox, eventListView, submitButton
        );

        Scene popupScene = new Scene(new ScrollPane(popupContent), 400, 400);
        popup.setScene(popupScene);
        popup.setTitle("Tilmeld dig til konferencen");
        popup.show();
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
