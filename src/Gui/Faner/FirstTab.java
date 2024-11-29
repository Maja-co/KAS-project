package Gui.Faner;

import application.model.Conferences;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
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

        // GridPane til billeder
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setBackground(new Background(new BackgroundFill(Color.rgb(36, 74, 54, 0.6), null, null)));


        // Konferencer og deres billede paths
        List<Conferences> conferences = Storage.getConferences(); // Hent konferencerne fra Storage
        for (int i = 0; i < conferences.size(); i++) {
            Conferences conference = conferences.get(i);
            Button imageButton = createImageButton(conference, conference.getImagePath()); // Giv knappen konferencen som parameter
            int row = i / 2;
            int col = i % 2;
            gridPane.add(imageButton, col, row);
        }

        // ScrollPane til GridPane
        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToWidth(true);

        // Tilføj ScrollPane til layout
        VBox content = new VBox(scrollPane);
        tab.setContent(content);

        return tab;
    }

    private Button createImageButton(Conferences conference, String imagePath) {
        Image image;
        try {
            image = new Image(getClass().getResourceAsStream(imagePath));
        } catch (Exception e) {
            System.err.println("Billede ikke fundet: " + imagePath);
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
