package Gui;

import Gui.Faner.FirstTab;
import Gui.Faner.SecondTab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Konferencer");

        // Opret TabPane og tilføj faner
        TabPane tabPane = new TabPane();
        ScrollPane scrollPane = new ScrollPane();

        // Tilføj FirstTab

        FirstTab firstTab = new FirstTab();
        Tab tab1 = firstTab.createFirstTab();

        // Tilføj ekstra faner (placeholder for nu)
        SecondTab secondTab = new SecondTab();
        Tab tab2 = secondTab.createSecondTab();

        tabPane.getTabs().addAll(tab1, tab2);

        // Scene og vindue
        Scene scene = new Scene(tabPane, 480, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
