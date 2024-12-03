package Gui.Faner;

import Gui.Faner.RegistrationPopUp;
import application.model.Conferences;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import Storage.Storage;
import javafx.scene.paint.Color;

import java.util.List;

public class ConferencesViewFirstTab {

    private ParticipantViewThirdTab participantViewThirdTab;


    public ConferencesViewFirstTab(ParticipantViewThirdTab participantViewThirdTab) {
        this.participantViewThirdTab = participantViewThirdTab;
    }

    public Tab createFirstTab() {
        // Opret fane
        Tab tab = new Tab("Konferencer");
        tab.setClosable(false);

        // Layout til overskriften og indhold
        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(20));
        vbox.setBackground(new Background(new BackgroundFill(Color.rgb(36, 74, 54, 0.6), null, null)));
        HBox headerBox = new HBox();
        headerBox.setAlignment(javafx.geometry.Pos.CENTER);
        headerBox.setPadding(new Insets(10));
        Label label = new Label("Find din næste konference her");
        label.setStyle("-fx-font-family: Georgia; -fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #FFFFFF;");
        headerBox.getChildren().add(label);
        vbox.getChildren().add(headerBox);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setStyle("-fx-font-family: Georgia; -fx-font-size: 14px;");
        gridPane.setBackground(new Background(new BackgroundFill(Color.rgb(36, 74, 54, 0.6), null, null)));

        List<Conferences> conferences = Storage.getConferences();
        for (int i = 0; i < conferences.size(); i++) {
            Conferences conference = conferences.get(i);
            Button imageButton = createImageButton(conference, conference.getImagePath());
            int row = i / 2;
            int col = i % 2;
            Region cell = new Region();
            cell.setBackground(new Background(new BackgroundFill(Color.rgb(36, 74, 54, 0.6), null, null)));
            gridPane.add(cell, col, row);
            gridPane.add(imageButton, col, row);
        }

        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToWidth(true);
        vbox.getChildren().add(scrollPane);
        tab.setContent(vbox);

        return tab;
    }

    private Button createImageButton(Conferences conference, String imagePath) {
        Image image;
        try {
            image = new Image(getClass().getResourceAsStream(imagePath));
        } catch (Exception e) {
            System.err.println("Billede ej fundet: " + imagePath);
            image = new Image(getClass().getResourceAsStream("/Storage/resource/placeholder.png"));
        }

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(180);
        imageView.setFitHeight(180);

        Button button = new Button("", imageView);
        button.setUserData(conference);
        Tooltip tooltip = new Tooltip("Klik for at tilmelde dig til: " + conference.getName());
        button.setTooltip(tooltip);
        button.setOnAction(e -> {
            new RegistrationPopUp(this.participantViewThirdTab, conference).showPopup();
        });
        return button;
    }
}