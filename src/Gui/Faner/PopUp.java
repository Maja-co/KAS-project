package Gui.Faner;

import Storage.Storage;
import application.controller.Controller;
import application.model.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
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
        popupContent.setPadding(new Insets(15));
        popupContent.setSpacing(10);

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
        companionCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
            companionField.setDisable(!newVal);
        });

        CheckBox accommodationCheckBox = new CheckBox("Ønsker du overnatning?");
        ListView<String> hotelListView = new ListView<>();
        hotelListView.getItems().addAll(Storage.getHotels().stream().map(Hotel::getName).toList());
        hotelListView.setPrefHeight(150);
        hotelListView.setDisable(true);
        accommodationCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
            hotelListView.setDisable(!newVal);
        });

        CheckBox eventCheckBox = new CheckBox("Ønsker ledsager at deltage i udflugter/events?");
        ListView<String> eventListView = new ListView<>();
        eventListView.getItems().addAll(Storage.getEvents().stream().map(Event::getName).toList());
        eventListView.setDisable(true);
        eventListView.setPrefHeight(150);
        eventCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
            eventListView.setDisable(!newVal);
        });

        Button submitButton = new Button("Tilmeld mig");
        submitButton.setOnAction(e -> {
            // Hent input og valider det
            String name = nameField.getText().trim();
            String address = addressField.getText().trim();
            String country = countryField.getText().trim();
            String mobile = mobileField.getText().trim();

            if (name.isEmpty() || address.isEmpty() || country.isEmpty() || mobile.isEmpty()) {
                // Vis en advarsel, hvis input ikke er komplet
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Fejl");
                alert.setHeaderText("Udfyld venligst alle felter");
                alert.showAndWait();

                // Opdater deltagerlisten i ThirdTab
                thirdTab.updateParticipantList();
                return;
            }

            boolean isLecturer = speakerCheckBox.isSelected();
            boolean hasCompanion = companionCheckBox.isSelected();
            String companionName = hasCompanion ? companionField.getText().trim() : "";

            // Find det valgte hotel og event
            String selectedHotelName = hotelListView.getSelectionModel().getSelectedItem();
            Hotel selectedHotel = Storage.getHotels().stream()
                    .filter(h -> h.getName().equals(selectedHotelName))
                    .findFirst().orElse(null);

            String selectedEventName = eventListView.getSelectionModel().getSelectedItem();
            Conferences selectedEvent = Storage.getConferences().stream()
                    .filter(c -> c.getName().equals(selectedEventName))
                    .findFirst().orElse(null);

            // Opret deltager
            Participant participant = Controller.createParticipant(name, address, country, mobile);
            Controller.createEnrollment(true, true, false, isLecturer, LocalDate.of(2024, 2, 2), LocalDate.of(2024, 4, 4), participant, conference, selectedHotel);

            // Opdater deltagerlisten i ThirdTab
            thirdTab.updateParticipantList();

            // Luk popup
            popup.close();
        });

        popupContent.getChildren().

                addAll(nameField, addressField, countryField, mobileField,
                        startDatePicker, endDatePicker, speakerCheckBox, companionCheckBox, companionField,
                        accommodationCheckBox, hotelListView, eventCheckBox, eventListView, submitButton);

        Scene popupScene = new Scene(new ScrollPane(popupContent), 400, 400);
        popup.setScene(popupScene);
        popup.setTitle("Tilmelding");
        popup.show();
    }
}