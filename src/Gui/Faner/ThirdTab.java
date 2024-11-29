package Gui.Faner;

import Storage.Storage;
import application.model.Conferences;
import application.model.Enrollment;
import application.model.Participant;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ThirdTab extends Tab {

    private ListView<Participant> participantListView = new ListView<>();

    public ThirdTab() {
        this.setText("Deltagerliste");
        this.setClosable(false);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToWidth(true);

        VBox content = new VBox(scrollPane);
        //tab.setContent(content);

        gridPane.add(participantListView, 0, 1);
        this.setContent(gridPane);
        updateParticipantList();

        participantListView.setOnMouseClicked(event -> {
            Participant selectedItem = participantListView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
//                showParticipantDetails(selectedItem);
            }
        });
    }

    void updateParticipantList() {
        List<Enrollment> enrollments = Storage.getEnrollments();
        ArrayList<Participant> participants = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            participants.add(enrollment.getParticipant());
            Conferences conference = enrollment.getConference();
            if (conference != null) {
                // Brug conference.getName() her, hvis conference ikke er null
                System.out.println(conference.getName());
            } else {
                System.out.println("Ingen tilknyttet konference");
            }
        }
        participantListView.getItems().setAll(participants);
    }


    private void showParticipantDetails(Participant selectedParticipant) {
        List<Enrollment> enrollments = Storage.getEnrollments();
        for (Enrollment enrollment : enrollments) {
            // Tjek om den valgte deltager svarer til deltageren i tilmeldingen
            if (enrollment.getParticipant().equals(selectedParticipant)) {
                String details = "Konference: " + enrollment.getConference().getName() + "\n"
                        + "Navn: " + enrollment.getParticipant().getName() + "\n"
                        + "Adresse: " + enrollment.getParticipant().getAddress() + "\n"
                        + "Land: " + enrollment.getParticipant().getCountry() + "\n"
                        + "Mobil: " + enrollment.getParticipant().getPhoneNumber() + "\n"
                        + "Ankomstdato: " + enrollment.getArrivalDate() + "\n"
                        + "Afrejsedato: " + enrollment.getDepartureDate() + "\n"
                        + "Foredragsholder: " + (enrollment.isSpeaker() ? "Ja" : "Nej") + "\n"
                        + "Ledsager: " + (enrollment.isAccompanied()
                        ? "Ja - " + enrollment.getCompanionName()
                        : "Nej") + "\n"
                        + "Overnatning: " + (enrollment.wantsAccommodation()
                        ? "Ja - Hotel: " + enrollment.getHotelName()
                        : "Nej") + "\n"
                        + "Ledsagerudflugt: " + (enrollment.wantsCompanionTrip()
                        ? "Ja - " + enrollment.getCompanionTrip()
                        : "Nej");
                Alert detailsAlert = new Alert(Alert.AlertType.INFORMATION);
                detailsAlert.setTitle("Deltagerdetaljer");
                detailsAlert.setHeaderText("Detaljer for " + enrollment.getParticipant().getName());
                detailsAlert.setContentText(details);
                detailsAlert.showAndWait();
                break;
            }
        }
    }
}