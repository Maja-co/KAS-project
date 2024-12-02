package Gui;

import Gui.Faner.ConferencesViewFirstTab;
import Gui.Faner.ConferencesCreationSecondTab;
import Gui.Faner.ParticipantViewThirdTab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Konferencer");

        // Opret TabPane og tilføj faner
        TabPane tabPane = new TabPane();

        ParticipantViewThirdTab participantViewThirdTab = new ParticipantViewThirdTab();
        // Tilføj FirstTab
        ConferencesViewFirstTab conferencesViewFirstTab = new ConferencesViewFirstTab(participantViewThirdTab);
        Tab tab1 = conferencesViewFirstTab.createFirstTab();

        // Tilføj ekstra faner (placeholder for nu)
        ConferencesCreationSecondTab conferencesCreationSecondTab = new ConferencesCreationSecondTab();
        Tab tab2 = conferencesCreationSecondTab.createSecondTab();

        //Tilføjer ThirdTab

        tabPane.getTabs().addAll(tab1, tab2, participantViewThirdTab);

        // Scene og vindue
        Scene scene = new Scene(tabPane, 480, 800);
        scene.setFill(javafx.scene.paint.Color.LIGHTBLUE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
