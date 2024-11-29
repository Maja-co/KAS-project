package Gui.Faner;

import Storage.Storage;
import application.model.Conferences;
import application.model.Enrollment;
import application.model.Participant;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class ThirdTab extends Tab {

    private ListView<Participant> participantListView = new ListView<>();
    private TextField searchField = new TextField();
    private ComboBox<Conferences> conferenceComboBox = new ComboBox<>();
    private Label participantDetailsLabel = new Label(); // Label til at vise deltageroplysninger

    public ThirdTab() {
        this.setText("Deltagerliste");
        this.setClosable(false);

        // Opsæt layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setBackground(new Background(new BackgroundFill(Color.rgb(36, 74, 54, 0.5), null, null)));

        participantListView.setPrefWidth(500); // Sætter bredden til 300 pixels


        // Opsæt søgefelt
        searchField.setPromptText("Søg efter en deltager");
        searchField.textProperty().addListener((obs, oldText, newText) -> {
            filterParticipants(newText, conferenceComboBox.getValue());
        });

        // Opsæt ComboBox for konferencevalg
        conferenceComboBox.setPromptText("Vælg konference");
        conferenceComboBox.getItems().setAll(Storage.getConferences());
        conferenceComboBox.valueProperty().addListener((obs, oldConference, newConference) -> {
            filterParticipants(searchField.getText(), newConference);
        });

        // Tilføj komponenter til layoutet
        gridPane.add(searchField, 0, 0);
        gridPane.add(conferenceComboBox, 1, 0);
        gridPane.add(participantListView, 0, 1);
        gridPane.add(participantDetailsLabel, 1, 1);

        participantListView.setOnMouseClicked(event -> {
            Participant selectedItem = participantListView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                showParticipantDetails(selectedItem);
            }
        });
        this.setContent(gridPane);
        updateParticipantList();
    }

    void updateParticipantList() {
        List<Enrollment> enrollments = Storage.getEnrollments();
        ArrayList<Participant> participants = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            participants.add(enrollment.getParticipant());
        }
        participantListView.getItems().setAll(participants);
    }

    private void filterParticipants(String searchText, Conferences selectedConference) {
        List<Enrollment> enrollments = Storage.getEnrollments();
        ArrayList<Participant> filteredParticipants = new ArrayList<>();

        for (Enrollment enrollment : enrollments) {
            Participant participant = enrollment.getParticipant();
            Conferences conference = enrollment.getConference();

            // Filtrering baseret på søgetekst og konference
            boolean matchesSearch = searchText == null || searchText.isEmpty() ||
                    participant.getName().toLowerCase().contains(searchText.toLowerCase());
            boolean matchesConference = selectedConference == null || selectedConference.equals(conference);

            if (matchesSearch && matchesConference) {
                filteredParticipants.add(participant);
            }
        }
        participantListView.getItems().setAll(filteredParticipants);
    }

    private void showParticipantDetails(Participant selectedParticipant) {
        List<Enrollment> enrollments = Storage.getEnrollments();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getParticipant().equals(selectedParticipant)) {
                String details = "Konference: " + enrollment.getConference().getName() + "\n"
                        + "Navn: " + enrollment.getParticipant().getName() + "\n"
                        + "Adresse: " + enrollment.getParticipant().getAddress() + "\n"
                        + "Land: " + enrollment.getParticipant().getCountry() + "\n"
                        + "Mobil: " + enrollment.getParticipant().getPhoneNumber() + "\n"
                        + "Ankomstdato: " + enrollment.getArrivalDate() + "\n"
                        + "Afrejsedato: " + enrollment.getDepartureDate() + "\n"
                        + "Foredragsholder: " + (enrollment.isSpeaker() ? "Ja" : "Nej") + "\n"
                        + "Ledsager: " + (enrollment.hasCompanion()
                        ? "Ja - Navn: " + enrollment.getCompanionName()
                        : "Nej") + "\n"
                        + "Overnatning: " + (enrollment.wantsAccommodation()
                        ? "Ja - Hotel: " + enrollment.getHotelName()
                        : "Nej") + "\n"
                        + "Ledsagerudflugt: " + (enrollment.wantsCompanionTrip()
                        ? "Ja - " + enrollment.getCompanionTrip()
                        : "Nej");
                participantDetailsLabel.setText(details);
                break;
            }
        }
    }

}
