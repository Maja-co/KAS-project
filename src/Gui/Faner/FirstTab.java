package Gui.Faner;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;

public class FirstTab {

    private ThirdTab thirdTab;  // Reference til ThirdTab

    public FirstTab() {
        this.thirdTab = new ThirdTab();  // Sæt reference ved initialisering
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

        // Billeder og knapper
        String[] imagePaths = {
                "/Storage/resource/Picture 1.png",
                "/Storage/resource/Picture 2.png",
                "/Storage/resource/Picture 3.png",
                "/Storage/resource/Picture 4.png",
                "/Storage/resource/Picture 5.png",
                "/Storage/resource/Picture 6.png",
                "/Storage/resource/Picture 7.png",
                "/Storage/resource/Picture 8.png",
                "/Storage/resource/Picture 9.png",
                "/Storage/resource/Picture 10.png"
        };

        for (int i = 0; i < imagePaths.length; i++) {
            Button imageButton = createImageButton(imagePaths[i]);
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

    private Button createImageButton(String imagePath) {
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
        Tooltip tooltip = new Tooltip("Klik for at tilmelde dig!");
        button.setTooltip(tooltip);

        // Når knappen trykkes, vis pop-up og opdater ThirdTab deltagerliste
        button.setOnAction(e -> {
            new PopUp(this.thirdTab).showPopup();  // Send ThirdTab til PopUp
        });

        return button;
    }
}

