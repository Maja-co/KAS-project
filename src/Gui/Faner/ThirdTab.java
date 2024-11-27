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

        // Add ScrollPane to layout
        VBox content = new VBox(scrollPane);
        tab.setContent(content);

        // Create ListView to show participants
        participantListView = new ListView<>();

        // Add ListView to GridPane
        gridPane.add(participantListView, 0, 0);

        // Update participant list in the GUI
        updateParticipantList();

        return tab;
    }

    // Update the ListView with participants from Storage
    public void updateParticipantList() {
        Platform.runLater(() -> {
            // Clear existing items
            participantListView.getItems().clear();

            // Fetch all enrollments from Storage and add participant names to ListView
            for (var enrollment : Storage.getEnrollments()) {
                participantListView.getItems().add(enrollment.getParticipant().getName());
            }
        });
    }

    // Get ListView (for external use if needed)
    public ListView<String> getListView() {
        return participantListView;
    }
}
