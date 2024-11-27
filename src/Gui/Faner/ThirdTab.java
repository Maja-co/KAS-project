package Gui.Faner;

import Storage.Storage;
import javafx.application.Platform;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.geometry.Insets;

public class ThirdTab {

    private ListView<String> participantListView;

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

        // Opret ListView til at vise deltagere
        participantListView = new ListView<>();
        System.out.println("participantListView initialiseret");

        // Tilføj ListView til GridPane
        gridPane.add(participantListView, 0, 0);

        // Opdater deltagerlisten i GUI'en ved at kalde metoden
        updateParticipantList();

        return tab;
    }

    // Opdater deltagerlisten i GUI'en med nye deltagere
    public void updateParticipantList() {
        Platform.runLater(() -> {
            participantListView.getItems().clear();
            var enrollments = Storage.getEnrollments();
            System.out.println("Deltagerliste opdateres med " + enrollments.size() + " tilmeldinger.");
            for (var enrollment : enrollments) {
                participantListView.getItems().add(enrollment.getParticipant().getName());
            }
        });
    }

    // Metode til at få ListView (hvis du har brug for det et andet sted)
    public ListView<String> getListView() {
        return participantListView;
    }
}
