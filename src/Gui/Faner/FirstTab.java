package Gui.Faner;

import application.model.Conferences;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import Storage.Storage;
import javafx.scene.paint.Color;
import java.util.List;

public class FirstTab {

    private ThirdTab thirdTab;  // Reference til ThirdTab

    public FirstTab(ThirdTab thirdTab) {
        this.thirdTab = thirdTab;  // Sæt reference ved initialisering
    }

    public Tab createFirstTab() {
        // Opret fane
        Tab tab = new Tab("Konferencer");
        tab.setClosable(false);

        // Layout til overskriften og indhold
        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(20));
        vbox.setBackground(new Background(new BackgroundFill(Color.rgb(36, 74, 54, 0.6), null, null)));

        // HBox til at centrere overskriften
        HBox headerBox = new HBox();
        headerBox.setAlignment(javafx.geometry.Pos.CENTER);
        headerBox.setPadding(new Insets(10));

        // Overskriften
        Label label = new Label("Find din næste konference her");
        label.setStyle("-fx-font-family: Georgia; -fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #FFFFFF;");  // Opdateret med farve og fed skrift
        headerBox.getChildren().add(label);
        vbox.getChildren().add(headerBox);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setStyle("-fx-font-family: Georgia; -fx-font-size: 14px;");
        gridPane.setBackground(new Background(new BackgroundFill(Color.rgb(36, 74, 54, 0.6), null, null)));


        // Konferencer og deres billede paths
        List<Conferences> conferences = Storage.getConferences(); // Hent konferencerne fra Storage
        for (int i = 0; i < conferences.size(); i++) {
            Conferences conference = conferences.get(i);
            Button imageButton = createImageButton(conference, conference.getImagePath()); // Giv knappen konferencen som parameter
            int row = i / 2;
            int col = i % 2;

            // Set background for each GridPane cell (col, row)
            Region cell = new Region();
            cell.setBackground(new Background(new BackgroundFill(Color.rgb(36, 74, 54, 0.6), null, null)));
            gridPane.add(cell, col, row);  // Add the background cell

            // Add the image button to the grid cell
            gridPane.add(imageButton, col, row);
        }

        // ScrollPane til GridPane
        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToWidth(true);

        // Tilføj ScrollPane til VBox
        vbox.getChildren().add(scrollPane);  // Tilføj ScrollPane med konferencerne til VBox

        // Tilføj hele VBox til tab
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

        // Når knappen trykkes, tilmeld deltageren til konferencen
        button.setOnAction(e -> {
            // Åbn pop-up med konferencens detaljer og tilmeld deltageren
            new PopUp(this.thirdTab, conference).showPopup();
        });

        return button;
    }
}