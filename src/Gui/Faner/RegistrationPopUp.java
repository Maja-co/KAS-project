package Gui.Faner;

import Storage.Storage;
import application.controller.Controller;
import application.model.*;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class RegistrationPopUp {
    private ParticipantViewThirdTab participantViewThirdTab;
    private Conferences conference;

    public RegistrationPopUp(ParticipantViewThirdTab participantViewThirdTab, Conferences conference) {
        this.participantViewThirdTab = participantViewThirdTab;
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
        headerBox.setAlignment(Pos.CENTER);
        headerBox.setPadding(new Insets(10));
        Label label = new Label("Tilmeldelse til: " + conference.getName());
        label.setStyle("-fx-font-family: Georgia; -fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #FFFFFF;");
        headerBox.getChildren().add(label);
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
        companionCheckBox.selectedProperty().addListener((obs, oldVal, newVal) ->
                companionField.setDisable(!newVal));

        CheckBox accommodationCheckBox = new CheckBox("Ønsker du overnatning?");
        ListView<String> hotelListView = new ListView<>();
        hotelListView.getItems().addAll(Storage.getHotels().stream().map(Hotel::getName).toList());
        hotelListView.setPrefHeight(130);
        hotelListView.setDisable(true);
        accommodationCheckBox.selectedProperty().addListener((obs, oldVal, newVal) ->
                hotelListView.setDisable(!newVal));

        ListView<String> hotelFacilitiesListView = new ListView<>();
        hotelFacilitiesListView.setDisable(true);
        hotelFacilitiesListView.setPrefHeight(130);
        hotelFacilitiesListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        hotelListView.getSelectionModel().selectedItemProperty().addListener((obs, oldHotel, newHotel) -> {
            if (newHotel != null) {
                Hotel selectedHotel = Storage.getHotels().stream().filter(hotel -> hotel.getName().equals(newHotel)).findFirst().orElse(null);
                if (selectedHotel != null) {
                    // Ryd eksisterende faciliteter
                    hotelFacilitiesListView.getItems().clear();
                    hotelFacilitiesListView.getItems().addAll(
                            selectedHotel.getListOfHotelFacilities().stream().map(HotelFacilities::getNameOfFacility).toList()
                    );
                    // Aktiver hotelfaciliteterne, når et hotel er valgt
                    hotelFacilitiesListView.setDisable(false);
                }
            } else {
                // Hvis intet hotel er valgt, deaktiver faciliteterne
                hotelFacilitiesListView.setDisable(true);
            }
        });

        // Lyt efter ændringer i accommodationCheckBox og deaktiver/aktiver hotelfaciliteter
        accommodationCheckBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (!isNowSelected) {
                // Hvis overnatning ikke er valgt, deaktiver hotelfaciliteterne
                hotelFacilitiesListView.setDisable(true);
                hotelFacilitiesListView.getItems().clear();
            } else {
                // Hvis overnatning er valgt, aktiver hotelfaciliteterne, hvis der er et valgt hotel
                if (hotelListView.getSelectionModel().getSelectedItem() != null) {
                    hotelFacilitiesListView.setDisable(false);
                }
            }
        });
        CheckBox eventCheckBox = new CheckBox("Ønsker ledsager at deltage i udflugter/events?");
        ListView<String> eventListView = new ListView<>();
        eventListView.getItems().addAll(Storage.getEvents().stream().map(Event::getName).toList());
        eventListView.setDisable(true);
        eventListView.setPrefHeight(130);
        eventListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        eventCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> eventListView.setDisable(!newVal));

        // Knappen til at tilmelde sig
        Button submitButton = new Button("Tilmeld mig - Samlet pris: 0 kr");
        submitButton.setPrefWidth(300);

        // Beregning af prisen baseret på de valgte faciliteter og udflugter
        ChangeListener<Object> priceUpdater = (obs, oldVal, newVal) -> {
            LocalDate startDate = startDatePicker.getValue();
            LocalDate endDate = endDatePicker.getValue();
            double totalPrice = conference.calculateConferencePrice(startDate, endDate);

            // Beregn hotelpris baseret på valgt hotel
            if (accommodationCheckBox.isSelected() && hotelListView.getSelectionModel().getSelectedItem() != null) {
                String selectedHotelName = hotelListView.getSelectionModel().getSelectedItem();
                Hotel selectedHotel = Storage.getHotels().stream()
                        .filter(hotel -> hotel.getName().equals(selectedHotelName))
                        .findFirst()
                        .orElse(null);

                if (selectedHotel != null) {
                    // Tilføj prisen for faciliteterne, hvis der er nogen valgt
                    double facilitiesPrice = 0;
                    for (String facilityName : hotelFacilitiesListView.getSelectionModel().getSelectedItems()) {
                        HotelFacilities facility = selectedHotel.getListOfHotelFacilities().stream()
                                .filter(f -> f.getNameOfFacility().equals(facilityName))
                                .findFirst()
                                .orElse(null);
                        if (facility != null) {
                            facilitiesPrice += facility.getPricePerFacility();
                        }
                    }
                    totalPrice += facilitiesPrice;

                    // Hvis ledsager er valgt, tilføj ekstra omkostning for dobbeltværelse
                    if (companionCheckBox.isSelected()) {
                        totalPrice += selectedHotel.priceForHotelDobbel(startDate, endDate);
                    }
                }
            }

            // Beregn prisen for valgte udflugter/events
            if (eventCheckBox.isSelected()) {
                double eventsPrice = 0;
                for (String eventName : eventListView.getSelectionModel().getSelectedItems()) {
                    Event selectedEvent = Storage.getEvents().stream()
                            .filter(event -> event.getName().equals(eventName))
                            .findFirst()
                            .orElse(null);
                    if (selectedEvent != null) {
                        eventsPrice += selectedEvent.getPricePerEvent();
                    }
                }
                totalPrice += eventsPrice;
            }

            // Opdater knappen med den samlede pris
            submitButton.setText(String.format("Tilmeld mig - Samlet pris: %.2f kr", totalPrice));
        };

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

            Hotel selectedHotel = Storage.getHotels().stream().filter(h -> h.getName().equals(hotelListView.getSelectionModel().getSelectedItem())).findFirst().orElse(null);
            Participant participant = Controller.createParticipant(name, address, country, mobile);
            Enrollment enrollment = Controller.createEnrollment(true, true, false, isLecturer, startDatePicker.getValue(), endDatePicker.getValue(), participant, conference, selectedHotel
            );

            if (selectedHotel != null) {
                hotelFacilitiesListView.getSelectionModel().getSelectedItems().forEach(facilityName -> {
                    HotelFacilities facility = selectedHotel.getListOfHotelFacilities().stream().filter(hf -> hf.getNameOfFacility().equals(facilityName)).findFirst().orElse(null);
                    if (facility != null) {
                        enrollment.addHotelFacilities(facility);
                    }
                });
            }

            eventListView.getSelectionModel().getSelectedItems().forEach(eventName -> {
                Event selectedEvent = Storage.getEvents().stream().filter(ev -> ev.getName().equals(eventName)).findFirst().orElse(null);
                if (selectedEvent != null) {
                    enrollment.addEvent(selectedEvent);
                }
            });


            participantViewThirdTab.updateParticipantList();
            popup.close();
        });

        popupContent.getChildren().addAll(
                nameField, addressField, countryField, mobileField,
                startDatePicker, endDatePicker, speakerCheckBox, companionCheckBox, companionField,
                accommodationCheckBox, hotelListView, hotelFacilitiesListView, eventCheckBox, eventListView, submitButton
        );

        Scene popupScene = new Scene(new ScrollPane(popupContent), 650, 750);
        popup.setScene(popupScene);
        popup.sizeToScene();
        popup.setTitle("Tilmelding");
        popup.show();
    }
}
