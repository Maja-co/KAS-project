package Gui.Faner;

import Storage.Storage;
import application.controller.Controller;
import application.model.Enrollment;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;

public class PopUp {

    public void showPopup() {
        // Opret popup-vindue
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);

        // Layout
        VBox popupContent = new VBox(15);
        popupContent.setPadding(new Insets(15));

        // Felter til deltager
        TextField nameField = new TextField();
        nameField.setPromptText("Navn");

        TextField addressField = new TextField();
        addressField.setPromptText("Adresse");

        TextField countryField = new TextField();
        countryField.setPromptText("Land");

        TextField mobileField = new TextField();
        mobileField.setPromptText("Mobilnummer");

        DatePicker startDatePicker = new DatePicker();
        startDatePicker.setPromptText("Ankomstdato");

        DatePicker endDatePicker = new DatePicker();
        endDatePicker.setPromptText("Afrejsedato");

        // Tilmeld-knap
        Button submitButton = new Button("Tilmeld mig");
        submitButton.setOnAction(e -> {
            String name = nameField.getText();
            String address = addressField.getText();
            String country = countryField.getText();
            String mobile = mobileField.getText();
            LocalDate startDate = startDatePicker.getValue();
            LocalDate endDate = endDatePicker.getValue();

            if (name.isEmpty() || address.isEmpty() || country.isEmpty() || mobile.isEmpty()
                    || startDate == null || endDate == null) {
                showError("Alle felter skal udfyldes!");
                return;
            }

            // Opret tilmelding gennem Controller
            Enrollment enrollment = Controller.createEnrollment(name, address, country, mobile, startDate, endDate);

            if (enrollment != null) {
                Storage.addEnrollment(enrollment);
                showSuccess("Tilmelding oprettet for: " + name);
                popup.close();
            } else {
                showError("Kunne ikke oprette tilmeldingen.");
            }
        });

        popupContent.getChildren().addAll(
                new Label("Udfyld oplysninger for tilmelding:"),
                nameField, addressField, countryField, mobileField,
                startDatePicker, endDatePicker, submitButton
        );

        // Scene og visning
        Scene popupScene = new Scene(popupContent, 400, 400);
        popup.setScene(popupScene);
        popup.setTitle("Tilmeld dig til konferencen");
        popup.show();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Fejl");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succes");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
