package Gui.Faner;

import Storage.Storage;
import application.model.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/*
Dette er den tredjetab hvor man har mulighed for at se deltagerview
Når man klikker på en deltager gør det muligt at se tilmeldingsinformationerne
 */

public class ParticipantViewThirdTab extends Tab {

    private ListView<Participant> participantListView = new ListView<>();
    private TextField searchField = new TextField();
    private ComboBox<Conferences> conferenceComboBox = new ComboBox<>();
    private ComboBox<Hotel> hotelsComboBox = new ComboBox<>();
    private ComboBox<Event> eventsComboBox = new ComboBox<>();
    private Label participantDetailsLabel = new Label();

    public ParticipantViewThirdTab() {
        this.setText("Deltagerliste");
        this.setClosable(false);

        // Opsæt layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setBackground(new Background(new BackgroundFill(Color.rgb(36, 74, 54, 0.5), null, null)));
        gridPane.setStyle("-fx-font-family: Georgia; -fx-font-size: 14px;");

        // Opret og centrer overskriften
        Label titleLabel = new Label("Deltagerliste");
        titleLabel.setStyle("-fx-font-family: Georgia; -fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #FFFFFF;");
        HBox titleBox = new HBox(titleLabel);
        titleBox.setAlignment(javafx.geometry.Pos.CENTER);
        titleBox.setPadding(new Insets(10));

        // Opsæt søgefelt
        searchField.setPromptText("Søg efter en deltager");
        searchField.textProperty().addListener((obs, oldText, newText) -> {
            filterParticipants(newText, conferenceComboBox.getValue(), hotelsComboBox.getValue(), eventsComboBox.getValue());
        });

        // Opsæt ComboBox for konference valg
        conferenceComboBox.setPromptText("Vælg konference");
        conferenceComboBox.getItems().setAll(Storage.getConferences());
        conferenceComboBox.valueProperty().addListener((obs, oldConference, newConference) -> {
            filterParticipants(searchField.getText(), newConference, hotelsComboBox.getValue(), eventsComboBox.getValue());
        });

        // Opsæt ComboBox for hotel valg
        hotelsComboBox.setPromptText("Vælg hotel");
        hotelsComboBox.getItems().setAll(Storage.getHotels());
        hotelsComboBox.valueProperty().addListener((obs, oldHotel, newHotel) -> {
            filterParticipants(searchField.getText(), conferenceComboBox.getValue(), newHotel, eventsComboBox.getValue());
        });

        // Opsæt ComboBox for event valg
        eventsComboBox.setPromptText("Vælg event");
        eventsComboBox.getItems().setAll(Storage.getEvents());
        eventsComboBox.valueProperty().addListener((obs, oldEvent, newEvent) -> {
            filterParticipants(searchField.getText(), conferenceComboBox.getValue(), hotelsComboBox.getValue(), newEvent);
        });

        // Tilføj komponenter til layoutet
        gridPane.add(searchField, 0, 0);
        gridPane.add(participantListView, 0, 1);
        gridPane.add(conferenceComboBox, 1, 0);
        gridPane.add(hotelsComboBox, 2, 0);
        gridPane.add(eventsComboBox, 3, 0);

        gridPane.add(participantDetailsLabel, 1, 1, 2, 1);
        participantDetailsLabel.setStyle("-fx-font-size: 16px; -fx-font-family: Georgia; -fx-text-fill: #000000;");
        participantDetailsLabel.setWrapText(true);
        participantDetailsLabel.setMaxWidth(Double.MAX_VALUE);
        participantDetailsLabel.setPadding(new Insets(10));

        conferenceComboBox.setPrefWidth(300);
        hotelsComboBox.setPrefWidth(300);
        eventsComboBox.setPrefWidth(300);
        participantListView.setPrefWidth(400);
        participantListView.setPrefHeight(800);

        participantListView.setOnMouseClicked(event -> {
            Participant selectedItem = participantListView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                showParticipantDetails(selectedItem);
            }
        });
        this.setContent(gridPane);
        updateParticipantList();
    }

    // Opdaterer konferencelisten i ComboBox
    public void updateConferences() {
        conferenceComboBox.getItems().setAll(Storage.getConferences());
    }

    void updateParticipantList() {
        List<Enrollment> enrollments = Storage.getEnrollments();
        ArrayList<Participant> participants = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            participants.add(enrollment.getParticipant());
        }
        participantListView.getItems().setAll(participants);
    }

    private void filterParticipants(String searchText, Conferences selectedConference, Hotel selectedHotel, Event selectedEvent) {
        List<Enrollment> enrollments = Storage.getEnrollments();
        ArrayList<Participant> filteredParticipants = new ArrayList<>();

        for (Enrollment enrollment : enrollments) {
            Participant participant = enrollment.getParticipant();

            // Tjek filtreringskriterier
            boolean matchesSearch = searchText == null || searchText.isEmpty() ||
                    participant.getName().toLowerCase().contains(searchText.toLowerCase());
            boolean matchesConference = selectedConference == null || selectedConference.equals(enrollment.getConference());
            boolean matchesHotel = selectedHotel == null || selectedHotel.equals(enrollment.getHotel());
            boolean matchesEvent = selectedEvent == null || enrollment.getEvents().contains(selectedEvent);

            // Tilføj deltager hvis alle kriterier matcher
            if (matchesSearch && matchesConference && matchesHotel && matchesEvent) {
                filteredParticipants.add(participant);
            }
        }
        participantListView.getItems().setAll(filteredParticipants);
    }
    private void showParticipantDetails(Participant selectedParticipant) {
        List<Enrollment> enrollments = Storage.getEnrollments();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getParticipant().equals(selectedParticipant)) {
                StringBuilder details = new StringBuilder();
                details.append("Konference: ").append(enrollment.getConference().getName()).append("\n")
                        .append("Navn: ").append(selectedParticipant.getName()).append("\n")
                        .append("Adresse: ").append(selectedParticipant.getAddress()).append("\n")
                        .append("Land: ").append(selectedParticipant.getCountry()).append("\n")
                        .append("Mobil: ").append(selectedParticipant.getPhoneNumber()).append("\n")
                        .append("Ankomstdato: ").append(enrollment.getArrivalDate()).append("\n")
                        .append("Afrejsedato: ").append(enrollment.getDepartureDate()).append("\n")
                        .append("Foredragsholder: ").append(enrollment.isSpeaker() ? "Ja" : "Nej").append("\n");

                // Ledsager
                if (enrollment.isAccompanied() && enrollment.getCompanion() != null) {
                    Companion companion = enrollment.getCompanion();
                    details.append("Ledsager: ").append(companion.getName()).append("\n");
                    details.append("Telefon: ").append(companion.getPhoneNumber()).append("\n");

                    if (!companion.getSelectedEvents().isEmpty()) {
                        details.append("Valgte events: ");
                        for (Event event : companion.getSelectedEvents()) {
                            details.append(event.getName()).append(", ");
                        }
                        // Fjern sidste komma og mellemrum
                        details.setLength(details.length() - 2);
                        details.append("\n");
                    } else {
                        details.append("Ingen events valgt.\n");
                    }
                } else {
                    details.append("Ledsager: Ingen.\n");
                }

                // Overnatning
                if (enrollment.wantsAccommodation()) {
                    details.append("Overnatning: Ja:\nHotel: ").append(enrollment.getHotelName()).append("\n");

                    Hotel hotel = enrollment.getHotel();
                    if (hotel != null) {
                        List<HotelFacilities> facilities = hotel.getListOfHotelFacilities();
                        if (!facilities.isEmpty()) {
                            details.append("Hotel-faciliteter:\n ");
                            for (HotelFacilities facility : facilities) {
                                details.append(facility.getNameOfFacility()).append(",\n ");
                            }
                            details.setLength(details.length() - 2);
                            details.append("\n");
                        }
                    }
                } else {
                    details.append("Overnatning: Nej\n");
                }

                // Events
                List<Event> events = enrollment.getEvents();
                if (!events.isEmpty()) {
                    details.append("Deltager i følgende events:\n");
                    for (Event event : events) {
                        details.append("- ").append(event.getName()).append("\n");
                    }
                }

                // Total pris
                details.append("Total pris: ").append(enrollment.calculateTotalPrice()).append(" kr\n");

                participantDetailsLabel.setText(details.toString());
                break;
            }
        }
    }
}