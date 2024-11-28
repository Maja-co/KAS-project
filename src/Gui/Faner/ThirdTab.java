package Gui.Faner;

import Storage.Storage;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ThirdTab {

    private ListView<String> participantListView = new ListView<>();

    public Tab createThirdTab() {
        // Create the tab
        Tab tab = new Tab("Deltagerliste");
        tab.setClosable(false);

        // Create GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Create ScrollPane for GridPane
        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToWidth(true);

        // Opret VBox og tilføj ScrollPane
        VBox content = new VBox(scrollPane);
        tab.setContent(content);

        // Tilføj ListView til GridPane
        gridPane.add(participantListView, 0, 1);

        // Opdater deltagerlisten i GUI'en
        updateParticipantList();

        return tab;
    }

    // Opdater deltagerlisten i GUI'en med nye deltagere
    public void updateParticipantList() {
        Platform.runLater(() -> {
            if (participantListView == null) {
                System.err.println("participantListView er ikke initialiseret!"); //Slet det
                return;
            }

            participantListView.getItems().clear();

            // Hent tilmeldinger fra Storage
            var enrollments = Storage.getEnrollments();
            if (enrollments != null && !enrollments.isEmpty()) {
                System.out.println("Deltagerliste opdateres med " + enrollments.size() + " tilmeldinger."); //Ikke brug for slet det
                for (var enrollment : enrollments) {
                    if (enrollment.getParticipant() != null && enrollment.getParticipant().getName() != null) {
                        participantListView.getItems().add(enrollment.getParticipant().getName());
                    } else {
                        System.err.println("Tilmelding mangler gyldig deltager eller navn."); //Kan følgende slettes?
                    }
                }
            } else {
                System.out.println("Ingen tilmeldinger fundet på deltagerlisten."); //Kan dette slettes?
            }
        });
    }

    // Metode til at få ListView (hvis du har brug for det et andet sted)
    public ListView<String> getListView() {
        return participantListView;
    }
}
