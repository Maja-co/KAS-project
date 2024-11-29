package Gui.Faner;

import Storage.Storage;
import application.model.Conferences;
import application.model.Enrollment;
import application.model.Hotel;
import application.model.Participant;
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
        eventListView.getItems().addAll(Storage.getConferences().stream().map(Conferences::getName).toList());
        eventListView.setDisable(true);
        eventListView.setPrefHeight(150);
        eventCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
            eventListView.setDisable(!newVal);
        });

        Button submitButton = new Button("Tilmeld mig");
        submitButton.setOnAction(e -> {
            try {
                // Hent input og valider det
                String name = nameField.getText().trim();
                String address = addressField.getText().trim();
                String country = countryField.getText().trim();
                String mobile = mobileField.getText().trim();
                LocalDate startDate = startDatePicker.getValue();
                LocalDate endDate = endDatePicker.getValue();
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

                // Opret Participant objekt
                Participant participant = new Participant(name, address, country, mobile);

                // Opret Enrollment
                Enrollment enrollment = new Enrollment(
                        true,  // isParticipantPrivate
                        hasCompanion,  // isCompanion
                        accommodationCheckBox.isSelected(),  // hotelStay
                        isLecturer,  // isParticipantLecturer
                        startDate,  // dateOfArrival
                        endDate,  // dateOfDeparture
                        participant,  // participant
                        selectedEvent,  // conference
                        selectedHotel  // hotel
                );

                // Tilføj Enrollment til Storage
                Storage.addEnrollment(enrollment);

                // Opdater deltagerlisten i ThirdTab
                thirdTab.updateParticipantList();

                // Luk popup
                popup.close();
            } catch (Exception ex) {
                // Vis fejlmeddelelse, hvis der er problemer med input
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Fejl: " + ex.getMessage());
                alert.showAndWait();
            }
        });

        popupContent.getChildren().addAll(nameField, addressField, countryField, mobileField,
                startDatePicker, endDatePicker, speakerCheckBox, companionCheckBox, companionField,
                accommodationCheckBox, hotelListView, eventCheckBox, eventListView, submitButton);

        Scene popupScene = new Scene(new ScrollPane(popupContent), 400, 400);
        popup.setScene(popupScene);
        popup.setTitle("Tilmelding");
        popup.show();
    }
}