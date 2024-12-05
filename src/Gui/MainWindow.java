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
        ConferencesViewFirstTab conferencesViewFirstTab = new ConferencesViewFirstTab(participantViewThirdTab);
        Tab tab1 = conferencesViewFirstTab.createFirstTab();

        //
        ConferencesCreationSecondTab conferencesCreationSecondTab = new ConferencesCreationSecondTab(participantViewThirdTab);
        Tab tab2 = conferencesCreationSecondTab.createSecondTab();
        tabPane.getTabs().addAll(tab1, tab2, participantViewThirdTab);

        tabPane.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
            //Find din næste konference - fane
            if (newTab == tab1) {
                primaryStage.setWidth(500);
                primaryStage.setHeight(800);
            //Opret Konference - fane
            } else if (newTab == tab2) {
                primaryStage.setWidth(500);
                primaryStage.setHeight(800);
            //Deltager liste - fane
            } else if (newTab == participantViewThirdTab) {
                primaryStage.setWidth(800);
                primaryStage.setHeight(800);

            }
        });

        // Scene og vindue
        Scene scene = new Scene(tabPane, 500, 800);
        scene.setFill(javafx.scene.paint.Color.LIGHTBLUE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}