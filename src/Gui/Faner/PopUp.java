package Gui.Faner;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUp {

    public void showPopup() {
        // Opret popup-vindue
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);

        // Layout
        VBox popupContent = new VBox(15);
        popupContent.setPadding(new Insets(15));

        // Sektion 1: Personlige oplysninger
        TextField nameField = new TextField();
        nameField.setPromptText("Navn");

        TextField adresseField = new TextField();
        adresseField.setPromptText("Adresse");

        TextField countryField = new TextField();
        countryField.setPromptText("Land");

        TextField mobileField = new TextField();
        mobileField.setPromptText("Mobilnummer");

        // Sektion 2: Datoer
        DatePicker startDatePicker = new DatePicker();
        startDatePicker.setPromptText("Ankomstdato");

        DatePicker endDatePicker = new DatePicker();
        endDatePicker.setPromptText("Afrejsedato");

        // Sektion 3: Ekstra valgmuligheder
        CheckBox speakerCheckBox = new CheckBox("Er du foredragsholder?");
        CheckBox companionCheckBox = new CheckBox("Medbringer du ledsager?");
        TextField companionField = new TextField();
        companionField.setPromptText("Ledsagers navn");
        companionField.setDisable(true); // Deaktiveret som standard
        companionCheckBox.selectedProperty().addListener((obs, wasSelected, isSelected) -> {
            companionField.setDisable(!isSelected);
        });

        CheckBox accommodationCheckBox = new CheckBox("Ønsker du overnatning?");
        ListView<String> hotelListView = new ListView<>();
        hotelListView.getItems().addAll("Hotel A", "Hotel B", "Hotel C");
        hotelListView.setPrefHeight(100);
        hotelListView.setDisable(true); // Deaktiveret som standard
        accommodationCheckBox.selectedProperty().addListener((obs, wasSelected, isSelected) -> {
            hotelListView.setDisable(!isSelected);
        });

        CheckBox eventCheckBox = new CheckBox("Ønsker ledsager at deltage i udflugter/events?");
        ListView<String> eventListView = new ListView<>();
        eventListView.getItems().addAll("Udflugt 1", "Udflugt 2", "Event 3");
        eventListView.setPrefHeight(150);
        eventListView.setDisable(true); // Deaktiveret som standard
        eventCheckBox.selectedProperty().addListener((obs, wasSelected, isSelected) -> {
            eventListView.setDisable(!isSelected);
        });

        // Tilmeld-knap
        Button submitButton = new Button("Tilmeld mig");
        submitButton.setOnAction(e -> {
            // Her kan du håndtere indsendelse af data
            System.out.println("Tilmelding sendt!");
            popup.close();
        });

        // Layout opsætning
        popupContent.getChildren().addAll(
                new Label("Personlige oplysninger:"),
                nameField, adresseField, countryField, mobileField,
                new Label("Datoer:"),
                startDatePicker, endDatePicker,
                new Label("Valgmuligheder:"),
                speakerCheckBox,
                companionCheckBox, companionField,
                accommodationCheckBox, hotelListView,
                eventCheckBox, eventListView,
                submitButton
        );

        // Scene og visning
        Scene popupScene = new Scene(popupContent, 400, 800);
        popup.setScene(popupScene);
        popup.setTitle("Tilmeld dig til konferencen");
        popup.show();

    }
}
